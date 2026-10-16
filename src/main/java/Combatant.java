

public abstract class Combatant {

    private int health;
    private int strength;
    private int dexterity;
    private boolean isKnockedOut;
    private String name;
    private String charClass;

    public Combatant(int health, int strength, int dexterity, String name, String charClass){
        this.health = health;
        this.name = name;
        this.charClass = charClass;
        this.strength = strength;
        this.dexterity = dexterity;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Name: " + name + "Class: " + charClass + " Health:" + health;
    }

    public abstract void attack();
    public void takeDamage(int damage){
        if(damage < 0){
            return;
        }

        health -= damage;

        if(health < 0){
            isKnockedOut = true;
        }

    }

    public void die(){

    }

}
