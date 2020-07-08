package io.muzoo.ooc.homework2;

import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable {

    public static void main(String[] args) {
        Game zorkGame = new Game();

        zorkGame.menuConsole();
    }
}
