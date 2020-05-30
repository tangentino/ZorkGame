package io.muzoo.ooc.homework2.command;

public class EchoCommand implements Command {

    @Override
    public void execute(String cmd) {
        System.out.println("You typed: " + cmd);
    }
}
