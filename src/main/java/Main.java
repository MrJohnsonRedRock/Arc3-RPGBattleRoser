import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        SimpleAudioPlayer narrator = new SimpleAudioPlayer();
        narrator.setPreviewMode(false);   // delete this line for the final version





        print("Welcome, traveler.  You must choose your combatants before you enter the");
        print("");
        print(" ___");
        print("|    \\ __ __ _ ___  ____  ___  ___  _ __ ____");
        print("| | \\ | | | | '_ \\ / _` |/ _ \\/ _ \\ | '_ \\/ __|");
        print("| |_//| |_| | | | | (_| |  __/ (_) |  | | \\__ \\");
        print(" \\___/ \\__,_|_| |_|\\__,/ \\___|\\____/|_| |_|___/");
        print("                     | |");
        print("                     / /");
        print("                    '-'");
        narrator.play("EnterTheDungeon.wav");


        print("You may only choose three");
        for (int i = 0; i < 4; i++) {
            print("Choose your next party member");
            print("What is the characters class?");
            print("1. Wizard - A Powerful ranged caster with a checkered background");
            print("2. Fighter - He's big, but only half as dumb as he looks!");
            print("3. Rogue - Her wit is the only thing as sharp as her knives!");
            print("4. Monk - Her fists of fury can break trees...but her temper can break hearts");
            print("5. Draco - Heavily armored and smells of bath salts");
            print("6. Pyro - If you know, you know.... Hehehe, fire!  FIRE!!!");


        }

    }

    public static void print(String toPrint){
        System.out.println(toPrint);
    }

    public static boolean getValidInput(int[] validChoices, int choice){

        for (int i = 0; i <validChoices.length ; i++) {
            if(choice == validChoices[i]){
                return true;
            }
        }
        return false;
    }

}
