package io.muzoo.ooc.homework2;

public class Player {

    private int currentHP;
    private int maxHP;
    private int attackPower;

    public Player(int health, int power) {
        maxHP = health;
        currentHP = health;
        attackPower = power;
    }

    public void changeHealth(int n) {
        int newHP = currentHP + n;
        if (newHP > maxHP) {
            currentHP = maxHP;
        }
        else {
            currentHP = newHP;
        }
    }

    public int getCurrentHP() { return currentHP; }

    public int getMaxHP() { return maxHP; }

    public int getAttackPower() { return attackPower; }


    public void changeDamage(int n) {
        attackPower += n;
    }

}
