package io.muzoo.ooc.homework2.command;

import io.muzoo.ooc.homework2.Game;

public class EatCommand implements Command {

    @Override
    public void execute(String cmd, Game game) {
        if (game.isRunning()) {
            if (cmd == null) {
                System.out.println("Eat what?");
            }
            else {
                game.eat(cmd);
            }
        }
        else {
            System.out.println("Command only available in game");
        }
    }
}
