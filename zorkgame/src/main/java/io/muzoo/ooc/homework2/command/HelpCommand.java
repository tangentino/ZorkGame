package io.muzoo.ooc.homework2.command;

import io.muzoo.ooc.homework2.Game;

public class HelpCommand implements Command {
    @Override
    public void execute(String cmd, Game game) {
        if (game.isRunning()) {
            System.out.println("Commands: attack, go, take, drop, info, map, save, quit, help");
        }
        else {
            System.out.println("Commands: play, load, autopilot, exit");
        }
    }
}
