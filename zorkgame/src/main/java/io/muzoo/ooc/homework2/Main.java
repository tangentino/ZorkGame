package io.muzoo.ooc.homework2;

import io.muzoo.ooc.homework2.command.Command;
import io.muzoo.ooc.homework2.command.CommandFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cmd = "";
        while(true) {
            System.out.print("> ");
            cmd = scanner.nextLine();
            String[] words = cmd.split(" ");
            Command command = CommandFactory.getCommand(words[0]);
            if (command != null) {
                command.execute(words.length == 1 ? null : words[1]);
            }
        }
    }
}
