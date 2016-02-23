package com.company;

/**
 * Created by torstein on 18-Feb-16.
 */
public class Board {

    char[] cArray;

    public Board() {
        System.out.println("Board is made");
        cArray = new char[9];
        fill();
    }

    private void fill() {
        for (int i = 0; i < cArray.length; i++) {
            cArray[i] = ' ';
        }
    }

    public void setChar(int pos, boolean player) { //true = player A, false = player B
        if (pos <= 0 && pos >= 8) {
            if (player) {
                cArray[pos] = 'X';
            } else if (!player) {
                cArray[pos] = 'O';
            }
        }
    }

    public String getChar(int pos) {
        if (pos <= 0 && pos >= 8) {
            String ret = String.valueOf(cArray[pos]);
            return ret;
        }
        return "";
    }
}
