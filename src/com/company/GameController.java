package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by torstein on 18-Feb-16.
 */
public class GameController {

    private Board b;
    private Player pa;
    private Player pb;
    private GUI g;

    public GameController() {
        start();
    }

    /**
     * Creates objects for game to work
     */
    public void start(){
        b = new Board();
        pa = new Player();
        pb = new Player();
        g = new GUI();
    }

}
