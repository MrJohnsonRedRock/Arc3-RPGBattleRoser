import java.util.ArrayList;

public class Party {
    private Combatant[] party;
    public Party(){
        party = new Combatant[4];

    }

    public Combatant[] getParty() {
        return party;
    }

    public String toString(){
        String toReturn = "";
        for (int i = 0; i < party.length; i++) {
            toReturn += party[i].toString() + "\n";
        }
        return toReturn;
    }

    public void print(String toPrint){
        System.out.println(toPrint);
    }
}
