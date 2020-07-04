package io.muzoo.ooc.homework2.command;

import io.muzoo.ooc.homework2.Game;

public class ExitCommand implements Command {

    @Override
    public void execute(String cmd, Game game) {
        if (game.isRunning()) {
            System.out.println("Command only available in menu");
        }
        else {
            System.out.println("Successfully quit game");
            System.exit(0);
        }
    }
}
