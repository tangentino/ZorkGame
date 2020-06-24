package io.muzoo.ooc.homework2.command;

import io.muzoo.ooc.homework2.Game;

public class ExitCommand implements Command {

    @Override
    public void execute(String cmd, Game game) {
        System.out.println("Exit complete");
        System.exit(0);
    }
}
