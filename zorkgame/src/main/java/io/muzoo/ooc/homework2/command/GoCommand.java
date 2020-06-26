package io.muzoo.ooc.homework2.command;

import io.muzoo.ooc.homework2.Game;

public class GoCommand implements Command {
    @Override
    public void execute(String cmd, Game game) {
        if (cmd != null) {
            if (game.isRunning()) {
                game.attackMonster(cmd);
            } else {
                System.out.println("Command only available in game");
            }
        }
        else {
            System.out.println("Invalid direction!");
        }
    }
}
