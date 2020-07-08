package io.muzoo.ooc.homework2.command;

import io.muzoo.ooc.homework2.Game;

public class LoadCommand implements Command {
    @Override
    public void execute(String cmd, Game game) {
        if (game.isRunning()) {
            System.out.println("Command only available in menu");
        }
        else if (cmd == null) {
            game.load("default");
        }
        else {
            game.load(cmd);
        }
    }
}
