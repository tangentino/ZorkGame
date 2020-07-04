package io.muzoo.ooc.homework2.item;

import io.muzoo.ooc.homework2.Player;

public class Food implements Item {
    private String name;
    private int healValue;

    public Food(String name, int healValue) {
        this.name = name;
        this.healValue = healValue;
    }

    public void eatFood(Player player) {
        player.changeHealth(healValue);
    }

    @Override
    public String getName() {
        return name;
    }
}
