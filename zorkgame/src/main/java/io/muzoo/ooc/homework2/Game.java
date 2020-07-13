package io.muzoo.ooc.homework2;

import io.muzoo.ooc.homework2.actor.Monster;
import io.muzoo.ooc.homework2.actor.Player;
import io.muzoo.ooc.homework2.command.Command;
import io.muzoo.ooc.homework2.command.CommandFactory;
import io.muzoo.ooc.homework2.item.Food;
import io.muzoo.ooc.homework2.item.Item;
import io.muzoo.ooc.homework2.item.Weapon;
import io.muzoo.ooc.homework2.map.FantasyMap;
import io.muzoo.ooc.homework2.map.GameMap;
import io.muzoo.ooc.homework2.map.Room;
import io.muzoo.ooc.homework2.map.SpaceMap;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Game implements Serializable {
    private Player player;
    private Room currentRoom;
    private boolean running;
    private GameMap gameMap;

    public Game() {
        running = false;
    }

    public boolean isRunning() { return running; }

    public void menuConsole() {
        System.out.println("Welcome to Zork!");
        System.out.println("You are currently in the menu");
        System.out.println("Type 'help' to see all the available commands");
        while (!running) {
            parser();
        }
    }

    public void printMap() {
        gameMap.printMap();
        System.out.println("[CURRENT ROOM]: "+currentRoom.getName());
    }

    public void startNewGame(String map) {
        switch (map) {
            case "fantasy":
                gameMap = new FantasyMap();
                currentRoom = gameMap.getStartingRoom();
                player = new Player(100,25);
                playGame();
                break;
            case "space":
                gameMap = new SpaceMap();
                currentRoom = gameMap.getStartingRoom();
                player = new Player(100,25);
                playGame();
                break;
            default:
                System.out.println("Please enter a valid map!");
        }
    }

    private void playGame() {
        printInfo();
        running = true;
        while (running) {
            parser();
        }
        System.out.println("Successfully exited to menu");
    }

    public void quitGame() {
        running = false;
    }

    public void printInfo() {
        Monster monster = currentRoom.getMonster();
        System.out.println("=============================================");
        System.out.println("[PLAYER STATS]:");
        System.out.println("Health - "+player.getCurrentHP()+"/"+player.getMaxHP());
        System.out.println("Attack Power - "+player.getAttackPower());
        System.out.println("Inventory - "+player.showInventory());
        System.out.println("=============================================");
        System.out.println("=============================================");
        System.out.println("CURRENT ROOM: "+currentRoom.getName());
        System.out.println("---------------------------------------------");
        Item item = currentRoom.getItem();
        if (monster == null) {
            System.out.println("No monster in this room");
        }
        else {
            System.out.println("[MONSTER]: "+monster.getName());
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
        if (item == null) {
            System.out.println("Nothing to take!");
        }
        else {
            System.out.println("Looted " + item.getName() + " from room!");
            player.addItem(item);
            currentRoom.removeItem();
        }
    }

    public void dropItem(String arg) {
        if (player.hasItem(arg)) {
            if (arg.equals("FISTS")) {
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
        Room nextRoom = currentRoom.getNeighbor(direction);
        if (nextRoom == null) {
            System.out.println("There is no room in that direction");
        }
        else {
            System.out.println("You regain 20 health");
            player.changeHealth(20);
            System.out.println("You travel " + direction + ".");
            currentRoom = nextRoom;
            System.out.println("You arrive at "+currentRoom.getName());
        }
    }

    public void attackMonster(String arg) {
        Item item = player.getItem(arg);
        if (item != null && item instanceof Weapon) {
            Monster monster = currentRoom.getMonster();
            if (monster == null) {
                System.out.println("There is no monster to attack.");
            } else {
                int playerDmg = player.getAttackPower() + item.getStatValue();
                monster.changeHealth(-playerDmg);
                System.out.println("Attacked monster with " + item.getName() + " for " + playerDmg + " damage!");
                System.out.println("["+monster.getName().toUpperCase()+"]: "+monster.getCurrentHP()+"/"+monster.getMaxHP() +" HP");
                if (monster.isDead()) {
                    currentRoom.removeMonster();
                    System.out.println("You have slain the monster!");
                    System.out.println("You feel like you have gotten stronger...");
                    System.out.println("Attack power increased by 10!");
                    player.changeAttackPower(10);
                    System.out.println("Current attack power is: "+player.getAttackPower());
                }
                else {
                    int rng = new Random().nextInt(monster.getAttackPower());
                    int monsterDmg = Math.round(rng);
                    System.out.println(monster.getName()+" attacks you for " + monsterDmg + " damage!");
                    player.changeHealth(-monsterDmg);
                    System.out.println("[PLAYER]: "+player.getCurrentHP()+"/"+player.getMaxHP()+" HP");
                    if (player.isDead()) {
                        System.out.println("Game over! You have died.");
                        System.out.println("Returning to menu. Better luck next time");
                        System.out.println("=============================================");
                        running = false;
                    }
                }
            }
        }
        else {
            System.out.println("Can't attack with that!");
        }
    }

    public void useItem(String arg) {
        Item item = player.getItem(arg);
        if (item != null && item instanceof Food) {
            System.out.println("You regain "+item.getStatValue()+" health from "+item.getName()+"!");
            player.changeHealth(item.getStatValue());
            System.out.println("[PLAYER]: "+player.getCurrentHP()+"/"+player.getMaxHP()+" HP");
            player.removeItem(arg);
        }
        else {
            System.out.println("You can't use that!");
        }
    }

    public void save(String filename) {
        try {
            Player p = player;
            Room room = currentRoom;
            GameMap map = gameMap;

            FileOutputStream file = new FileOutputStream(new File("src/main/saves/" + filename));
            ObjectOutputStream output = new ObjectOutputStream(file);

            output.writeObject(p);
            output.writeObject(room);
            output.writeObject(map);

            System.out.println("Successfully saved game!");

            file.close();
            output.close();
        }
        catch (IOException e) {
            System.out.println("Error saving game");
        }
    }

    public void load(String filename) {
        try {
            FileInputStream file = new FileInputStream(new File("src/main/saves/" + filename));
            ObjectInputStream input = new ObjectInputStream(file);

            player = (Player) input.readObject();
            currentRoom = (Room) input.readObject();
            gameMap = (GameMap) input.readObject();

            System.out.println("Successfully loaded game!");

            file.close();
            input.close();

            playGame();
        }
        catch (FileNotFoundException e) {
            System.out.println("Save file not found");
        }
        catch (IOException e) {
            System.out.println("Error loading game");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Error loading game");
        }
    }
    private void parser() {
        System.out.print("> ");

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        processCommandLine(line);

    }

    public void autopilot(String filename) {
        try {
            FileInputStream stream = new FileInputStream("src/main/autopilot/" + filename);
            Scanner scanner = new Scanner(stream);
            while (scanner.hasNextLine()) {
                processCommandLine(scanner.nextLine());
            }
        }
        catch (IOException e) {
            System.out.println("File not found. Try again");
        }
    }

    private void processCommandLine(String line) {
        Scanner parser = new Scanner(line); // scan input line
        String cmdString = null;
        String arg = null;
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
