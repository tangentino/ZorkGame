package io.muzoo.ooc.homework2.command;

import io.muzoo.ooc.homework2.Game;

public interface Command {

    void execute(String cmd, Game game);
    
}
