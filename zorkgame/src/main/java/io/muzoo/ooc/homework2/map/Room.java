package io.muzoo.ooc.homework2.map;

import io.muzoo.ooc.homework2.actor.Monster;
import io.muzoo.ooc.homework2.item.Item;

import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable {
    private Monster monster; // Room's monster
    private Item item; // List of items in room
    public HashMap<String,Room> neighbors; // Neighboring rooms
    private String name; // description of room

    public Room(String name) {
        this.name = name;
        neighbors = new HashMap<String,Room>();
        item = null;
        this.monster = null;
    }

    public void addExit(String direction, Room exit) {
        // adds exit to a room
        neighbors.put(direction,exit);
    }

    public Room getNeighbor(String direction) {
        // get directional neighbor
        return neighbors.get(direction);
    }

    public String getName() {
        // get description of room
        return name;
    }

    public String showExits() {
        // Displays a string showing all exits
        // Will look something like "EXITS: | north | east | west | south |"
        String ans = "EXITS: ";
        for (String direction : neighbors.keySet()) {
            ans += "| " + direction + " |";
        }
        return ans;
    }

    public void setItem(Item item) {
        this.item  = item;
    }

    public void removeItem() {
        this.item = null;
    }

    public Item getItem() {
        return item;
    }

    public Monster getMonster() { return monster; }

    public void setMonster(Monster m) {
        monster = m;
    }

    public void removeMonster() {
        monster = null;
    }
    
}
