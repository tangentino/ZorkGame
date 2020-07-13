package io.muzoo.ooc.homework2.map;

import io.muzoo.ooc.homework2.actor.Monster;
import io.muzoo.ooc.homework2.item.Food;
import io.muzoo.ooc.homework2.item.Weapon;

public class FantasyMap extends GameMap {

    public FantasyMap() {
        super("fantasy.txt");

        // initialize rooms
        Room village = new Room("VILLAGE");
        Room courtyard = new Room("COURTYARD");
        Room dungeons = new Room("DUNGEONS");
        Room palace = new Room("GRAND PALACE");
        Room throne = new Room("THRONE ROOM");
        startingRoom = village;

        // add monsters to rooms
        village.setMonster(new Monster("Goblin Scout",100,25));
        courtyard.setMonster(new Monster("Stone Guardian",150,35));
        dungeons.setMonster(new Monster("Torturer",250,40));
        palace.setMonster(new Monster("Guard Commander",300,50));
        throne.setMonster(new Monster("Hand of the King",500,70));

        // add items
        village.setItem(new Weapon("LONGSWORD",20));
        dungeons.setItem(new Weapon("MORNINGSTAR",35));
        throne.setItem(new Weapon("KINGSLAYER",50));
        courtyard.setItem(new Food("STEAK",50));

        // connect rooms
        village.addExit("east",courtyard);
        courtyard.addExit("west",village);
        courtyard.addExit("south",dungeons);
        courtyard.addExit("north",palace);
        dungeons.addExit("north",courtyard);
        palace.addExit("south",courtyard);
        palace.addExit("east",throne);
        throne.addExit("west",palace);
    }
}
