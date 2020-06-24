package io.muzoo.ooc.homework2.command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static Map<String,Command> cmdMap = new HashMap<>();

    public static Command getCommand(String cmd) {
        return cmdMap.get(cmd);
    }

    public boolean isCommand(String cmd) {
        return cmdMap.containsKey(cmd);
    }
}
