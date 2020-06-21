package io.muzoo.ooc.homework2;

import io.muzoo.ooc.homework2.command.Command;
import io.muzoo.ooc.homework2.command.CommandList;

import java.util.Scanner;

public class Parser {
    private CommandList commands;
    private Scanner scanner;

    public Parser() {
        commands = new CommandList();
        scanner = new Scanner(System.in);
    }

    public Command parseCommand() {
        String input;
        String cmd = null;
        String arg = null;

        System.out.println("> ");

        input = scanner.nextLine();

        Scanner reader = new Scanner(input);
        if (reader.hasNext()) {
            cmd = reader.next();
            if (reader.hasNext()) {
                arg = reader.next();
            }
        }

        if (commands.isCommand(cmd)) {
            return new Command(cmd,arg);
        }
        else {
            return new Command(null,arg);
        }
    }
}
