package com.company;

/**
 * Created by torstein on 18-Feb-16.
 */
public class GameController {

    private Player pa;
    private Player pb;
    private GUI gui;

    private char[] brdArray;
    private int iterator = 0;

    public GameController() {
        gui = new GUI(this);

        //
        String name = gui.getPlayerName("A");
        pa = new Player(name);
        pa.setCharacter(PlayerSign.X);

        name = gui.getPlayerName("B");
        pb = new Player(name);
        pb.setCharacter(PlayerSign.O);

        brdArray = new char[9];
        fillBoard();
        System.out.println("Board is made");

        gui.updatePlayerTurn(pa);
    }

    public void guiClicked() {
        if (iterator % 2 == 0) {
            gui.updatePlayerTurn(pb);
            playerTurn(pa);
        } else {
            gui.updatePlayerTurn(pa);
            playerTurn(pb);
        }

        iterator++;
    }

    public void playerTurn(Player player) {

        //TODO set player position on board
        //TODO place piece on board


        int playerPos = gui.getPPos();

        player.setPos(playerPos);
        int posP = player.getPos();
        setChar(posP, true);
        gui.setBtn(posP, player.getCharacter()); //String.valueOf(getBoardChar(posPA)) doesn't work to replace "X"
        gui.setClicked(false);
        System.out.println(getBoardChar(posP));

        //TODO remember checks for
        //TODO win
        //TODO tie
        //TODO position taken
        //TODO invalid input (If buttons, not needed)
    }

    private void fillBoard() {
        for (int i = 0; i < brdArray.length; i++) {
            brdArray[i] = ' ';
        }
    }

    private void setChar(int position, boolean player) { //true = player A, false = player B
        if (position > 0 || position < 8) {
            throw new RuntimeException("Position is out of bounds: " + position);
        }

        brdArray[position] = player ? PlayerSign.X : PlayerSign.O; //ternary operator
    }

    private char getBoardChar(int position) {
        if (position <= 0 && position >= 8) {
            return brdArray[position];
        }
        return 'U';
    }
}