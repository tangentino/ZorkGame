package io.muzoo.ooc.homework2;

import io.muzoo.ooc.homework2.command.Command;
import io.muzoo.ooc.homework2.command.CommandFactory;
import io.muzoo.ooc.homework2.item.Item;
import io.muzoo.ooc.homework2.item.Weapon;

import java.util.Scanner;

public class Game {
    private Player player;
    private Room currentRoom;
    private boolean running;
    private GameMap map;

    // To-do list
    // MAPS
    // load save?


    public Game() {
        player = new Player(100,25);
        map = new GameMap();
        currentRoom = map.createMap();
    }

    public boolean isRunning() { return running; }

    public void menuConsole() {
        System.out.println("Welcome to Zork!");
        System.out.println("You are currently in the menu");
        System.out.println("Type 'help' to see all the available commands");
        while (!running) {
            parseCommand();
        }
    }

    public void playGame() {
        printInfo();
        running = true;
        while (running) {
            parseCommand();
        }
        System.out.println("Successfully exited to menu");
    }

    public void quitGame() {
        running = false;
    }

    public void printInfo() {
        System.out.println("=============================================");
        System.out.println("[PLAYER STATS]:");
        System.out.println("Health - "+player.getCurrentHP()+"/"+player.getMaxHP());
        System.out.println("Attack Power - "+player.getAttackPower());
        System.out.println("Inventory - "+player.showInventory());
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("CURRENT ROOM INFO");
        System.out.println("---------------------------------------------");
        System.out.println("[MONSTER]:");
        Monster monster = currentRoom.getMonster();
        Item item = currentRoom.getItem();
        if (monster == null) {
            System.out.println("No monster in this room");
        }
        else {
            System.out.println("Health - " + monster.getCurrentHP() + "/" + monster.getMaxHP());
            System.out.println("Attack Power - " + monster.getAttackPower());
        }
        System.out.println("---------------------------------------------");
        if (item == null) {
            System.out.println("No item in this room");
        }
        else {
            System.out.println("[ITEM]: " + item.getName());
        }
        System.out.println("---------------------------------------------");
        System.out.println(currentRoom.showExits());
        System.out.println("=============================================");
    }

    public void takeItems() {
        Item item = currentRoom.getItem();
        System.out.println("Looted " + item.getName() + " from room!");
        player.addItem(item);
        currentRoom.removeItem();
    }

    public void dropItem(String arg) {
        if (player.hasItem(arg)) {
            if (arg == "FISTS") {
                System.out.println("You can't drop your fists!");
            }
            else {
                System.out.println("Dropped " + arg + " from inventory.");
                player.removeItem(arg);
            }
        }
        else {
            System.out.println("No such item");
        }
    }

    public void goRoom(String direction) {
        System.out.println("You travel " + direction + ".");
        Room nextRoom = currentRoom.getNeighbor(direction);
        if (nextRoom == null) {
            System.out.println("There is no room in that direction");
        }
        else {
            currentRoom = nextRoom;
        }
    }

    public void attackMonster(String arg) {
        Item item = player.getItem(arg);
        if (item != null && item instanceof Weapon) {
            Monster monster = currentRoom.getMonster();
            if (monster == null) {
                System.out.println("There is no monster to attack.");
            } else {
                int playerDmg = player.getAttackPower() + ((Weapon) item).getDamage();
                monster.changeHealth(-playerDmg);
                System.out.println("Attacked monster with " + item.getName() + " for " + playerDmg + " damage!");
                System.out.println("[MONSTER]: "+monster.getCurrentHP()+"/"+monster.getMaxHP() +" HP");
                if (monster.isDead()) {
                    currentRoom.removeMonster();
                    System.out.println("You have slain the monster!");
                }
            }
        }
        else {
            System.out.println("Can't attack with that!");
        }
    }

    public void parseCommand() {
        Scanner scanner = new Scanner(System.in);
        String input;
        String cmdString = null;
        String arg = null;

        System.out.print("> ");

        input = scanner.nextLine();
        Scanner parser = new Scanner(input); // scan input line

        if (parser.hasNext()) {
            cmdString = parser.next(); // command word
            if(parser.hasNext()) {
                arg = parser.next(); // argument (2nd word)
            }
        }

        if (CommandFactory.isCommand(cmdString)) {
            Command cmd = CommandFactory.getCommand(cmdString);
            cmd.execute(arg,this);
        }
        else {
            System.out.println("Invalid command. Type 'help' for list of commands");
        }


    }

}
