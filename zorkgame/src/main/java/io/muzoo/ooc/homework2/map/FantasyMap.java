package io.muzoo.ooc.homework2.map;

import io.muzoo.ooc.homework2.Monster;
import io.muzoo.ooc.homework2.Room;
import io.muzoo.ooc.homework2.item.Weapon;

import java.io.*;
import java.util.stream.Collectors;

public class FantasyMap implements GameMap {
    private Room startingRoom;
    private BufferedReader reader;

    public FantasyMap() {
        try {
            reader = new BufferedReader(new FileReader(new File("src/main/gamemaps/fantasy.txt")));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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
        palace.setMonster(new Monster("King's Guard",300,50));
        throne.setMonster(new Monster("Hand of the King",500,70));

        // add items
        village.setItem(new Weapon("LONGSWORD",20));
        dungeons.setItem(new Weapon("MORNINGSTAR",35));
        throne.setItem(new Weapon("KINGSLAYER",50));

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
    @Override
    public void printMap() {
        System.out.println(reader.lines().collect(Collectors.joining(System.lineSeparator())));
    }

    @Override
    public Room getStartingRoom() {
        return startingRoom;
    }
}
