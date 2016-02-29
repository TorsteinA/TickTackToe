package com.company;

/**
 * Created by torstein on 18-Feb-16.
 */
public class GameController {

    private Board brd;
    private Player pa;
    private Player pb;
    private GUI gui;

    public GameController() {
//
        brd = new Board();
        pa = new Player();
        pb = new Player();
        gui = new GUI();
    }

    public void playerTurn(Player p){
        //TODO set player position on board
        //TODO place piece on board
        //TODO remember checks for
            //TODO win
            //TODO tie
            //TODO position taken
            //TODO invalid input (If buttons, not needed)
    }

    public void playerNameSet(String name, boolean player){ //player is 0 or 1
        if(player == true) {
            pa.setName(name);
        }
        else if(player == false){
            pb.setName(name);
        }
    }
}
