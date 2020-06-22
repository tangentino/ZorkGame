package io.muzoo.ooc.homework2;

import io.muzoo.ooc.homework2.item.Item;

import java.util.HashMap;

public class Room {
    private Monster monster; // Room's monster
    private HashMap<String,Item> itemList; // List of items in room
    public HashMap<String,Room> neighbors; // Neighboring rooms
    private String description; // description of room

    public Room(String description) {
        this.description = description;
        neighbors = new HashMap<String,Room>();
        itemList = new HashMap<String,Item>();
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

    public String getDescription() {
        // get description of room
        return description;
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

    public void addItem(Item item) {
        itemList.put(item.getName(),item);
    }

    public void removeItem(Item item) {
        itemList.remove(item.getName());
    }

    public String showItems() {
        // Displays string showing all items
        String ans = "ITEMS: ";
        for (String item : itemList.keySet()) {
            ans += "| " + item + " |";
        }
        return ans;
    }

    public void setMonster(Monster m) {
        monster = m;
    }

    public boolean hasMonster() {
        // Check if room has a monster
        return (!(monster == null));
    }

    public void removeMonster() {
        monster = null;
    }


}
