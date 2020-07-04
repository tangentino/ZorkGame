package io.muzoo.ooc.homework2.command;

import io.muzoo.ooc.homework2.Game;

public class GoCommand implements Command {
    @Override
    public void execute(String cmd, Game game) {
        if (game.isRunning()) {
            if (cmd == null) {
                System.out.println("Please give a valid direction!");
            }
            else {
                game.goRoom(cmd.toLowerCase());
            }
        }
        else {
            System.out.println("Command only available in game");
        }
    }
}
