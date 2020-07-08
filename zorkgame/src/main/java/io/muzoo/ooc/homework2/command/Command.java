package io.muzoo.ooc.homework2.command;

import io.muzoo.ooc.homework2.Game;

import java.io.Serializable;

public interface Command extends Serializable {

    void execute(String cmd, Game game);
    
}
