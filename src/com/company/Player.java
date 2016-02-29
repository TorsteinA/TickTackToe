package com.company;

/**
 * Created by torstein on 18-Feb-16.
 */
public class Player {

    private String name;
    private char character;
    private int pos; //position for character placement


    public Player(String name) {
        this.name = name;
        character = ' ';
        pos = -2;
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

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}