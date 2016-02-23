package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by torstein on 18-Feb-16.
 */
public class GUI extends JFrame implements ActionListener {
    private int width = 3;
    private int height = 3;

    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;


    private int pPos;


    private JTextField jTxt1 = new JTextField();
    private JPanel jp = new JPanel(new GridLayout(width, height));
    private JPanel jp2 = new JPanel(new BorderLayout(100, 10));


    public GUI() {
        pPos = -1;
        System.out.println("GUI object emerged");

        JLabel jLbl1 = new JLabel("Tick Tack Toe", JLabel.CENTER);
        JLabel jLbl2 = new JLabel("someone's turn", JLabel.CENTER);

        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");

        JButton btnR = new JButton("Reset game");

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

        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);

        jp2.add(jLbl1, BorderLayout.NORTH);
        jp2.add(jLbl2, BorderLayout.SOUTH);

        add(btnR, BorderLayout.SOUTH);


        //add(jTxt1, BorderLayout.SOUTH); //TODO add textfield to name popup


        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent event) {
        JButton clicked = (JButton) event.getSource();
        if (clicked == btn0) {
            pPos = 0;
        } else if (clicked == btn1) {
            pPos = 1;
        } else if (clicked == btn2) {
            pPos = 2;
        } else if (clicked == btn3) {
            pPos = 3;
        } else if (clicked == btn4) {
            pPos = 4;
        } else if (clicked == btn5) {
            pPos = 5;
        } else if (clicked == btn6) {
            pPos = 6;
        } else if (clicked == btn7) {
            pPos = 7;
        } else if (clicked == btn8) {
            pPos = 8;
        }
    }

    public int getPPos() {
        return pPos;
    }

    public void setBtn(int button, String character) {
        switch (button) {
            case 0:
                btn0.setText(character);
                break;
            case 1:
                btn1.setText(character);
                break;
            case 2:
                btn2.setText(character);
                break;
            case 3:
                btn3.setText(character);
                break;
            case 4:
                btn4.setText(character);
                break;
            case 5:
                btn5.setText(character);
                break;
            case 6:
                btn6.setText(character);
                break;
            case 7:
                btn7.setText(character);
                break;
            case 8:
                btn8.setText(character);
                break;
        }
    }
}