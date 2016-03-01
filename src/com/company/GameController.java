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

        String name = gui.getPlayerName("A");
        pa = new Player(name);
        pa.setCharacter(PlayerSign.X);

        name = gui.getPlayerName("B");
        pb = new Player(name);
        pb.setCharacter(PlayerSign.O);


    }

    public void guiClicked() {
        if (iterator % 2 == 0) {
            if (playerTurn(pa)) {
                gui.updatePlayerTurn(pb);
            } else {
                iterator++;
            }
        } else {
            if (playerTurn(pb)) {
                gui.updatePlayerTurn(pa);
            } else {
                iterator++;
            }
        }
        iterator++;
    }

    public void start() {
        brdArray = new char[9];
        fillBoard();
        System.out.println("Board is made");

        gui.updatePlayerTurn(pa);
    }

    public boolean playerTurn(Player player) {

        int playerPos = gui.getPPos();
        gui.setClicked(false);

        if (brdArray[playerPos] == ' ') {
            player.setPos(playerPos);
            int posP = player.getPos();
            setChar(posP, player);
            gui.setBtn(posP, player.getCharacter());
            if (!winCheck(player)) {
                tieCheck();
            }
            return true;
        } else {
            return false;
        }
    }

    private void fillBoard() {
        for (int i = 0; i < brdArray.length; i++) {
            brdArray[i] = ' ';
        }
    }

    private void setChar(int position, Player player) { //true = player A, false = player B
        if (position < 0 || position > 8) {
            throw new RuntimeException("Position is out of bounds: " + position);
        }
        brdArray[position] = player.getCharacter();
    }

    private char getBoardChar(int position) {
        if (position <= 0 && position >= 8) {
            return brdArray[position];
        }
        return 'U';
    }

    /**
     * Checks if a player has won.
     */
    public boolean winCheck(Player player) {
        if (horizontalWin(player) || verticalWin(player) || diagonalWin(player)) {
            gui.winPrint(player);
            return true;
        }
        return false;
    }

    /**
     * Checks if it's a tie.
     */
    public void tieCheck() {
        if (!(new String(brdArray).contains(" "))) {
            gui.tiePrint();
        }
    }

    /**
     * Checks horizontal win conditions
     */
    private boolean horizontalWin(Player player) {
        if (brdArray[0] == brdArray[1] && brdArray[1] == brdArray[2] && brdArray[2] == player.getCharacter()) {
            return true;
        } else if (brdArray[3] == brdArray[4] && brdArray[4] == brdArray[5] && brdArray[5] == player.getCharacter()) {
            return true;
        } else if (brdArray[6] == brdArray[7] && brdArray[7] == brdArray[8] && brdArray[8] == player.getCharacter()) {
            return true;
        }
        return false;
    }

    /**
     * Checks vertical win conditions
     */
    private boolean verticalWin(Player player) {
        if (brdArray[0] == brdArray[3] && brdArray[3] == brdArray[6] && brdArray[6] == player.getCharacter()) {
            return true;
        } else if (brdArray[1] == brdArray[4] && brdArray[4] == brdArray[7] && brdArray[7] == player.getCharacter()) {
            return true;
        } else if (brdArray[2] == brdArray[5] && brdArray[5] == brdArray[8] && brdArray[8] == player.getCharacter()) {
            return true;
        }
        return false;
    }

    /**
     * Checks diagonal win conditions
     */
    private boolean diagonalWin(Player player) {
        if (brdArray[0] == brdArray[4] && brdArray[4] == brdArray[8] && brdArray[8] == player.getCharacter()) {
            return true;
        } else if (brdArray[2] == brdArray[4] && brdArray[4] == brdArray[6] && brdArray[6] == player.getCharacter()) {
            return true;
        }
        return false;
    }
}
