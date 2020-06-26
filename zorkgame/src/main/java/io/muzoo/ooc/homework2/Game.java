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
    private CommandFactory cmdList;

    // To-do list
    // Info command


    public Game() {
        player = new Player(100,25);
    }

    public boolean isRunning() { return running; }

    public void printInfo() {

    }

    public void takeItems() {
        Item item = currentRoom.getItem();
        System.out.println("Looted " + item.getName() + " from room!");
        player.addItem(item);
        currentRoom.removeItem();
    }

    public void dropItem(String arg) {
        System.out.println("Dropped " + arg + " from inventory.");
        player.removeItem(arg);
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

        if (cmdList.isCommand(cmdString)) {
            Command cmd = CommandFactory.getCommand(cmdString);
            cmd.execute(arg,this);
        }
        else {
            System.out.println("Invalid command. Type 'help' for list of commands");
        }


    }

}
