package io.muzoo.ooc.homework2;

public class Monster {

    private String name;
    private int maxHP;
    private int currentHP;
    private int attackPower;

    public Monster(String name, int health, int damage) {
        this.name = name;
        maxHP = health;
        currentHP = health;
        attackPower = damage;
    }

    public int getCurrentHP() { return currentHP; }

    public int getMaxHP() { return maxHP; }

    public int getAttackPower() { return attackPower; }

    public void changeHealth(int n) {
        int newHP = currentHP + n;
        if (newHP > maxHP) {
            currentHP = maxHP;
        }
        else {
            currentHP = newHP;
        }
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeDamage(int n) {
        attackPower += n;
    }


}
