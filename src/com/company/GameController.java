package com.company;

import javax.swing.*;

/**
 * Created by torstein on 18-Feb-16.
 */
public class GameController {

    private Board brd;
    private Player pa;
    private Player pb;
    private GUI gui;

    public GameController() {

        brd = new Board();
        pa = new Player(JOptionPane.showInputDialog("Player A, what's your name"));
        pb = new Player(JOptionPane.showInputDialog("Player B, what's your name"));
        gui = new GUI();


    }

    public void playerTurn(int i) {

        //TODO set player position on board
        //TODO place piece on board

        int playerPos = gui.getPPos();
        if (i % 2 == 0) {

            //Player A's turn


            pa.setPos(playerPos);

            int posPA = pa.getPos();

            brd.setChar(posPA, true);


            gui.setBtn(posPA, "X"); //String.valueOf(brd.getChar(posPA)) doesn't work to replace "X"


        } else if (i % 2 == 1) {

            //Player B's turn


            pb.setPos(playerPos);

            int posPB = pb.getPos();

            brd.setChar(posPB, false);

            gui.setBtn(posPB, "O");

        }




        //TODO remember checks for
            //TODO win
            //TODO tie
            //TODO position taken
            //TODO invalid input (If buttons, not needed)
    }
}
