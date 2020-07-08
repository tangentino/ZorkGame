package io.muzoo.ooc.homework2.command;

import io.muzoo.ooc.homework2.Game;

public class SaveCommand implements Command {
    @Override
    public void execute(String cmd, Game game) {
        if (game.isRunning()) {
            if (cmd == null) {
                game.save("default");
            }
            else {
                game.save(cmd);
            }
        }
        else {
            System.out.println("Command only available in game");
        }
    }
}
