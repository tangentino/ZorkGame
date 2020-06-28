package io.muzoo.ooc.homework2;

import io.muzoo.ooc.homework2.item.Item;
import io.muzoo.ooc.homework2.item.Weapon;

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
        Item fists = new Weapon("FISTS",10);
        addItem(fists);
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

    public String showInventory() {
        return inventory.keySet().toString();
    }

    public void addItem(Item item) {
        inventory.put(item.getName(),item);
    }

    public Item getItem(String name) {
        if (hasItem(name)) {
            return inventory.get(name);
        }
        return null;
    }

    public boolean hasItem(String name) {
        return inventory.containsKey(name);
    }

    public void removeItem(String name) {
        inventory.remove(name);
    }

    public int getCurrentHP() { return currentHP; }

    public int getMaxHP() { return maxHP; }

    public int getAttackPower() { return attackPower; }

    public void changeAttackPower(int n) {
        attackPower += n;
    }

}
