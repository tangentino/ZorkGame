package io.muzoo.ooc.homework2.command;

public class Command {
    private String commandWord;
    private String argument;

    public Command(String word, String arg) {
        commandWord = word;
        argument = arg;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public String getArgument() {
        return argument;
    }

    public boolean hasArgument() {
        return (argument != null);
    }

    public boolean isValid() {
        return (commandWord != null);
    }
}
