package io.muzoo.ooc.homework2;

public class GameMap {
    private Room startingRoom;

    public GameMap() {
        startingRoom = new Room();
    }

    public Room createMap() {
        Monster m = new Monster("Bob",150,20);
        startingRoom.setMonster(m);
        return startingRoom;
    }
}
