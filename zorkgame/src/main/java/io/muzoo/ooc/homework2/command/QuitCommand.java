package io.muzoo.ooc.homework2.command;

import io.muzoo.ooc.homework2.Game;

public class QuitCommand implements Command {
    @Override
    public void execute(String cmd, Game game) {
        if (game.isRunning()) {
            game.quitGame();
        }
        else {
            System.out.println("Command only available in game");
        }
    }
}
