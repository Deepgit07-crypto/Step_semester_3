public class Character {
    private int health;               // Private health field[cite: 3]
    private final int maxHealth;      // Final maximum health, fixed on creation[cite: 3]

    // Constructor to initialize maximum and current health
    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    // Reduces health, clamping it at a minimum of 0[cite: 3]
    public void takeDamage(int amount) {
        this.health = Math.max(0, this.health - amount);
    }

    // Increases health, clamping it at a maximum of maxHealth[cite: 3]
    public void heal(int amount) {
        this.health = Math.min(this.maxHealth, this.health + amount);
    }

    // Read-only getter for current health[cite: 3]
    public int getHealth() {
        return this.health;
    }

    // Read-only getter for max health
    public int getMaxHealth() {
        return this.maxHealth;
    }
}