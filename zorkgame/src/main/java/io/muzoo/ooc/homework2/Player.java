package io.muzoo.ooc.homework2;

import io.muzoo.ooc.homework2.item.Item;

import java.util.HashMap;

public class Player {

    private int currentHP;
    private int maxHP;
    private int attackPower;
    private HashMap<String,Item> inventory;

    public Player(int health, int power) {
        maxHP = health;
        currentHP = health;
        attackPower = power;
        inventory = new HashMap<>();
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

    public void addItem(Item item) {
        inventory.put(item.getName(),item);
    }

    public Item getItem(String name) {
        return inventory.get(name);
    }

    public int getCurrentHP() { return currentHP; }

    public int getMaxHP() { return maxHP; }

    public int getAttackPower() { return attackPower; }


    public void changeDamage(int n) {
        attackPower += n;
    }

}
