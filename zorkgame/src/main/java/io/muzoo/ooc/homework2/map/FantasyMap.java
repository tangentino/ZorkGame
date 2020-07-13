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
        village.setMonster(new Monster("Goblin Scout",100,35));
        courtyard.setMonster(new Monster("Stone Guardian",150,35));
        dungeons.setMonster(new Monster("Torturer",250,25));
        palace.setMonster(new Monster("Guard Commander",300,25));
        Monster handOfTheKing = new Monster("Hand of the King",500,25);
        throne.setMonster(handOfTheKing);
        boss = handOfTheKing;

        // add items
        village.setItem(new Weapon("LONGSWORD",20));
        dungeons.setItem(new Weapon("MORNINGSTAR",50));
        throne.setItem(new Weapon("KINGSLAYER",75));
        courtyard.setItem(new Food("STEAK",70));

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
