public class GameCharacter {
    private int health;
    private final int maxHealth;

    public GameCharacter(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        int newHealth = this.health - amount;
        if (newHealth < 0) {
            this.health = 0;
        } else {
            this.health = newHealth;
        }
    }

    public void heal(int amount) {
        int newHealth = this.health + amount;
        if (newHealth > this.maxHealth) {
            this.health = this.maxHealth;
        } else {
            this.health = newHealth;
        }
    }

    public int getHealth() {
        return this.health;
    }

    public static void main(String[] args) {
        GameCharacter c = new GameCharacter(100);
        c.takeDamage(30);
        System.out.println("health = " + c.getHealth());
        c.heal(50);
        System.out.println("health = " + c.getHealth());
        c.takeDamage(150);
        System.out.println("health = " + c.getHealth());
    }
}
