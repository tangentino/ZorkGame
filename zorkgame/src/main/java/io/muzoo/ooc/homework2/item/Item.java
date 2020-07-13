package io.muzoo.ooc.homework2.item;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() { return name; }

    public int getStatValue() { return value; }
}
