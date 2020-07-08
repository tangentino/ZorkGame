package io.muzoo.ooc.homework2.command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static Map<String,Command> cmdMap = new HashMap<>();

    static {
        cmdMap.put("exit",new ExitCommand());
        cmdMap.put("attack",new AttackCommand());
        cmdMap.put("autopilot",new AutopilotCommand());
        cmdMap.put("drop",new DropCommand());
        cmdMap.put("go",new GoCommand());
        cmdMap.put("help",new HelpCommand());
        cmdMap.put("map",new MapCommand());
        cmdMap.put("quit",new QuitCommand());
        cmdMap.put("load",new LoadCommand());
        cmdMap.put("info",new InfoCommand());
        cmdMap.put("take",new TakeCommand());
        cmdMap.put("save",new SaveCommand());
        cmdMap.put("play",new PlayCommand());
        cmdMap.put("eat", new EatCommand());
    }
    public static Command getCommand(String cmd) {
        return cmdMap.get(cmd);
    }

    public static boolean isCommand(String cmd) {
        return cmdMap.containsKey(cmd);
    }
}
