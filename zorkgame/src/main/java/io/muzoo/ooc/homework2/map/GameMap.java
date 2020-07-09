package io.muzoo.ooc.homework2.map;

import io.muzoo.ooc.homework2.Room;

import java.io.Serializable;

public interface GameMap extends Serializable {
    void printMap();
    Room getStartingRoom();
    void loadMap();
}
