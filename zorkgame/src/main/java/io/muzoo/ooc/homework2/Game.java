package io.muzoo.ooc.homework2;

import io.muzoo.ooc.homework2.command.Command;
import io.muzoo.ooc.homework2.command.CommandFactory;

import java.util.Scanner;

public class Game {
    private Player player;
    private Room currentRoom;
    private boolean running;
    private CommandFactory cmdList;

    // To-do list
    // 1. go to next room function
    // 2. Combat
    // 3. Health
    // 4. Item collect

    public Game() {
        player = new Player(100,25);
    }

    public boolean isRunning() { return running; }

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
            System.out.println("Please enter a valid command");
        }


    }

}
