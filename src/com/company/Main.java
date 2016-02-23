package com.company;

public class Main {
    public static void main(String[] args) {
	// write your program here
        GameController gc = new GameController();
        boolean finished = false;
        int i = 0;



        //TODO gameloop with loopCounter. Odd numbers for one player, even numbers for the other.

        while (!finished) {
            gc.playerTurn(i);
            i++;
        }


        //finished = true;
    }

}
