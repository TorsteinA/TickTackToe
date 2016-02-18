package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Created by torstein on 18-Feb-16.
 */
public class GUI extends JFrame implements ActionListener{
    private int width;
    private int height;
    public GUI() {
        width = 3;
        height = 3;
        System.out.println("GUI object emerged");

        setTitle("Tick Tack Toe");
        setSize(200*width, 200*height);
        setLayout(new GridLayout(width, height));

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent event){

    }
}
