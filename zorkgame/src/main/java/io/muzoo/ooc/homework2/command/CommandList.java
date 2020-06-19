package io.muzoo.ooc.homework2.command;

import java.util.HashMap;

public class CommandList {

    private HashMap<String,CommandWord> gameCommands;

    public CommandList() {
        gameCommands = new HashMap<String,CommandWord>();
    }

    public boolean isCommand(String cmd) {
        return (gameCommands.containsKey(cmd));
    }
}
