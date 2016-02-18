package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Created by torstein on 18-Feb-16.
 */
public class GUI extends JFrame implements ActionListener{
    private String tempName;
    private int width = 3;
    private int height = 3;



    private JTextField jTxt1 = new JTextField();
    private JPanel jp = new JPanel(new GridLayout(width, height));
    private JPanel jp2 = new JPanel(new BorderLayout(100, 10));



    public GUI() {
        System.out.println("GUI object emerged");

        playerASetup();
        playerBSetup();

        gameSetup();

    }


    private void playerASetup() {
        tempName = JOptionPane.showInputDialog(this, "Player A, what's your name");
        //get gc.pa's name set
    }

    private void playerBSetup() {
        tempName = JOptionPane.showInputDialog(this, "Player B, what's your name");
        //get gc.pb's name set
    }

    public void actionPerformed(ActionEvent event){
        JButton clicked = (JButton) event.getSource();
        /*if(clicked == ){
            JOptionPane.showMessageDialog(this, "Hello ");
        }*/
    }

    public void gameSetup(){

        JLabel jLbl1 = new JLabel("Tick Tack Toe", JLabel.CENTER);
        JLabel jLbl2 = new JLabel(tempName + "'s turn", JLabel.CENTER);

        JButton btn0 = new JButton("0");
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");

        setTitle("Tick Tack Toe");
        setSize(700, 700);

        add(jp, BorderLayout.CENTER);
        add(jp2, BorderLayout.NORTH);

        jp.add(btn0);
        jp.add(btn1);
        jp.add(btn2);
        jp.add(btn3);
        jp.add(btn4);
        jp.add(btn5);
        jp.add(btn6);
        jp.add(btn7);
        jp.add(btn8);

        jp2.add(jLbl1, BorderLayout.NORTH);
        jp2.add(jLbl2, BorderLayout.SOUTH);




        //add(jTxt1, BorderLayout.SOUTH); //TODO add textfield to name popup



        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
