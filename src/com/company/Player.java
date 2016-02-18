package com.company;

/**
 * Created by torstein on 18-Feb-16.
 */
public class Player {

    private String name;
    private char character;

    public Player() {
        name = "noName";
        character = ' ';
        System.out.println("Player created");

    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
