package io.muzoo.ooc.homework2.actor;

public class Monster extends Actor {

    private String name;

    public Monster(String name, int health, int damage) {
        super(health,damage);
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
