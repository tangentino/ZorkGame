package io.muzoo.ooc.homework2;

public class Monster {

    private int maxHP;
    private int currentHP;
    private int attackPower;
    private String name;

    public Monster(String name, int health, int damage) {
        this.name = name;
        maxHP = health;
        currentHP = health;
        attackPower = damage;
    }

    public String getName() {
        return name;
    }

    public boolean isDead() { return currentHP <= 0; }

    public int getCurrentHP() { return currentHP; }

    public int getMaxHP() { return maxHP; }

    public int getAttackPower() { return attackPower; }

    public void changeHealth(int n) {
        int newHP = currentHP + n;
        if (newHP > maxHP) {
            currentHP = maxHP;
        }
        else if (newHP < 0) {
            currentHP = 0;
        }
        else {
            currentHP = newHP;
        }
    }

    public void changeDamage(int n) {
        attackPower += n;
    }


}
