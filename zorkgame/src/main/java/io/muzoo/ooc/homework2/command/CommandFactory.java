package io.muzoo.ooc.homework2.command;

import java.util.Map;
import java.util.HashMap;

public class CommandFactory {

    private static Map<String,Command> cmdMap = new HashMap<>();

    static {
        cmdMap.put("exit", new ExitCommand());
        cmdMap.put("echo", new EchoCommand());
    }

    public static Command getCommand(String cmd) {
        return cmdMap.get(cmd);
    }
}
