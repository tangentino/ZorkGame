package io.muzoo.ooc.homework2.map;

import io.muzoo.ooc.homework2.actor.Monster;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public abstract class GameMap implements Serializable {
    private StringBuilder mapArt;
    protected Room startingRoom;
    protected Monster boss;

    protected GameMap(String filename) {
        mapArt = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get("src/main/gamemaps/"+filename), StandardCharsets.UTF_8)) {
            // load map line by line and store into string
            // do this in constructor so it doesn't have to read the file everytime we call printMap()
            stream.forEach(s -> mapArt.append(s).append("\n"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printMap() {
        System.out.println(mapArt.toString());
    }

    public Room getStartingRoom() {
        return startingRoom;
    }

    public Monster getBoss() { return boss; }

}
