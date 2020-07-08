package io.muzoo.ooc.homework2.command;

import io.muzoo.ooc.homework2.Game;

public class AutopilotCommand implements Command {
    @Override
    public void execute(String cmd, Game game) {
        if (game.isRunning()) {
            game.autopilot(cmd);
        }
        else if (cmd == null) {
            System.out.println("Please provide a valid command file");
        }
        else {
            System.out.println("Command only available in game");
        }
    }
}
