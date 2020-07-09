package io.muzoo.ooc.homework2.map;

import io.muzoo.ooc.homework2.Room;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SpaceMap implements GameMap {
    private Room startingRoom;
    private transient BufferedReader reader;

    @Override
    public void printMap() {

    }

    @Override
    public Room getStartingRoom() {
        return null;
    }

    @Override
    public void loadMap() {
        try {
            reader = new BufferedReader(new FileReader(new File("src/main/gamemaps/space.txt")));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
