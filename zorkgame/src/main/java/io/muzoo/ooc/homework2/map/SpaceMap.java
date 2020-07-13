package io.muzoo.ooc.homework2.map;

import io.muzoo.ooc.homework2.actor.Monster;
import io.muzoo.ooc.homework2.item.Food;
import io.muzoo.ooc.homework2.item.Weapon;

public class SpaceMap extends GameMap {

    public SpaceMap() {
        super("space.txt");

        // initialize maps
        Room shuttle = new Room("SHUTTLE BAY");
        Room engine = new Room("ENGINE ROOM");
        Room weapons = new Room("WEAPONS ROOM");
        Room airlock = new Room("AIRLOCK");
        Room crew = new Room("CREW DECK");
        Room cockpit = new Room("COCKPIT");
        Room mess = new Room("MESS HALL");
        Room infirmary = new Room("INFIRMARY");
        Room war = new Room("WAR ROOM");
        startingRoom = airlock;

        // add monsters to rooms
        airlock.setMonster(new Monster("Stray Alien",125,30));
        engine.setMonster(new Monster("Space Engineer",200,35));
        weapons.setMonster(new Monster("Stormtrooper Grunt",300,40));
        mess.setMonster(new Monster("Gordon the Space Chef",450,60));
        war.setMonster(new Monster("Stormtrooper Captain",500,50));
        crew.setMonster(new Monster("Karen the Navigator",666,69));
        cockpit.setMonster(new Monster("Darth Vader",1000,70));

        // add items to rooms
        shuttle.setItem(new Weapon("GLOWSTICK",15));
        cockpit.setItem(new Weapon("LIGHTSABER",50));
        engine.setItem(new Weapon("WRENCH",20));
        mess.setItem(new Food("GATORADE",25));
        weapons.setItem(new Weapon("BLASTER",35));
        infirmary.setItem(new Food("MEDKIT",50));

        // connect rooms
        shuttle.addExit("south",engine);
        engine.addExit("north",shuttle);
        engine.addExit("east",weapons);
        engine.addExit("south",airlock);
        weapons.addExit("west",engine);
        airlock.addExit("east",crew);
        airlock.addExit("south",mess);
        airlock.addExit("north",engine);
        crew.addExit("west",airlock);
        crew.addExit("east",cockpit);
        cockpit.addExit("west",crew);
        mess.addExit("north",airlock);
        mess.addExit("east",infirmary);
        mess.addExit("south",war);
        infirmary.addExit("west",mess);
        war.addExit("north",mess);

    }





}
