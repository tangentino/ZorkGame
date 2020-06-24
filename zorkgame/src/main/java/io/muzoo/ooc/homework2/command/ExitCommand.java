package io.muzoo.ooc.homework2.command;

public class ExitCommand implements Command {

    @Override
    public void execute(String cmd) {
        System.out.println("Exit complete");
        System.exit(0);
    }
}
