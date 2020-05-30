package io.muzoo.ooc.homework2.item;

public class Weapon implements Item {

    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}
