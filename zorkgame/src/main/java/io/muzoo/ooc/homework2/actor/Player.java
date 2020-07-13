package io.muzoo.ooc.homework2.actor;

import io.muzoo.ooc.homework2.actor.Actor;
import io.muzoo.ooc.homework2.item.Item;
import io.muzoo.ooc.homework2.item.Weapon;

import java.util.HashMap;

public class Player extends Actor {

    private HashMap<String,Item> inventory;

    public Player(int health, int power) {
        super(health,power);
        inventory = new HashMap<>();
        Item fists = new Weapon("FISTS",3);
        addItem(fists);
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

}
