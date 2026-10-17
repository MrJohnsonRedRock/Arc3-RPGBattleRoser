import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SimpleAudioPlayer {

    private static final String AUDIO_DIR = "src/main/Audio/";
    private static final long PREVIEW_MS = 1500;
    private boolean previewMode = false;

    public SimpleAudioPlayer() { }

    // Turn on while testing: shows the filename and plays only the first 1.5 seconds
    public void setPreviewMode(boolean on) {
        previewMode = on;
    }

    // Plays the file and waits until it finishes. Never crashes the program.
    public void play(String fileName) {
        File file = new File(AUDIO_DIR + fileName);

        if (!file.exists()) {
            System.out.println("   [missing audio: " + file.getPath() + "]");
            return;
        }
        if (previewMode) {
            System.out.println("   [audio: " + fileName + "]");
        }

        try (AudioInputStream in = AudioSystem.getAudioInputStream(file);
             Clip clip = AudioSystem.getClip()) {

            clip.open(in);
            CountDownLatch done = new CountDownLatch(1);
            clip.addLineListener(e -> {
                if (e.getType() == LineEvent.Type.STOP) done.countDown();
            });

            clip.start();
            if (previewMode) {
                done.await(PREVIEW_MS, TimeUnit.MILLISECONDS);
                clip.stop();
            } else {
                done.await();
            }

        } catch (UnsupportedAudioFileException e) {
            System.out.println("   [can't play " + fileName + ": must be a 16-bit PCM .wav]");
        } catch (Exception e) {
            System.out.println("   [audio error on " + fileName + ": " + e.getMessage() + "]");
        }
    }
}