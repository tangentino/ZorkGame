package io.muzoo.ooc.homework2.actor;

import java.io.Serializable;

public abstract class Actor implements Serializable {

    private int currentHP;
    private int maxHP;
    private int attackPower;

    protected Actor(int health, int power) {
        currentHP = maxHP = health;
        attackPower = power;
    }

    public int getCurrentHP() { return currentHP; }

    public int getMaxHP() { return maxHP; }

    public int getAttackPower() { return attackPower; }

    public void changeAttackPower(int n) {
        attackPower += n;
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

    public boolean isDead() {
        return currentHP <= 0;
    }
}
