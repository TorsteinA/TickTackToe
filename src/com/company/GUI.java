package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by torstein on 18-Feb-16.
 */
public class GUI extends JFrame implements ActionListener {

    JButton btnR = new JButton("Reset game");
    private List<JButton> buttonList = new ArrayList<>();
    private int pPos;
    private boolean btnClicked;
    private GameController gameController;
    private JLabel jLbl2;

    public GUI(GameController gameController) {

        this.gameController = gameController;
        pPos = -1;
        System.out.println("GUI object emerged");
        JLabel jLbl1 = new JLabel("Tick Tack Toe", JLabel.CENTER);
        jLbl2 = new JLabel("someone's turn", JLabel.CENTER);
        for (int i = 0; i <= 8; i++) {
            buttonList.add(new JButton());
        }
        setTitle("Tick Tack Toe");
        setSize(500, 500);
        int height = 3;
        int width = 3;
        JPanel jPanel = new JPanel(new GridLayout(width, height));
        add(jPanel, BorderLayout.CENTER);
        JPanel jp2 = new JPanel(new BorderLayout(100, 10));
        add(jp2, BorderLayout.NORTH);
        for (JButton jButton : buttonList) {
            jPanel.add(jButton);
            jButton.addActionListener(this);
        }
        jp2.add(jLbl1, BorderLayout.NORTH);
        jp2.add(jLbl2, BorderLayout.SOUTH);
        add(btnR, BorderLayout.SOUTH);
        btnR.addActionListener(this);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) {
        JButton clicked = (JButton) event.getSource();

        for (int i = 0; i < buttonList.size(); i++) {
            if (clicked == buttonList.get(i)) {
                pPos = i;
                break;
            }
        }
        btnClicked = true;
        gameController.guiClicked();

        if (clicked == btnR) {
            resetGame();
        }
    }

    public void resetGame() {
        gameController.start();

        for (JButton jButton : buttonList) {
            jButton.setText("");
        }
    }

    public int getPPos() {
        return pPos;
    }

    public void setBtn(int button, char playerCharacter) {
        String character = String.valueOf(playerCharacter);
        buttonList.get(button).setText(character);
    }

    public String getPlayerName(String player) {
        return JOptionPane.showInputDialog("Player " + player + ", what's your name");
    }

    public void setClicked(boolean clicked) {
        this.btnClicked = clicked;
    }

    public void updatePlayerTurn(Player player) {
        String name = player.getName();
        jLbl2.setText(name + "'s turn");
    }

    public void winPrint(Player player) {
        //JOptionPane.showMessageDialog(this, player.getName() + " wins the game!");
        int reply = JOptionPane.showConfirmDialog(this, player.getName() + " wins the game!\nDo you want to reset the game?", "Winner!", JOptionPane.YES_NO_OPTION);

        if (reply == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            exitGame();
        }

    }

    public void tiePrint() {
        int reply = JOptionPane.showConfirmDialog(this, "There's a tie!\n" +
                "Do you want to reset the game?", "Tie", JOptionPane.YES_NO_OPTION);

        if (reply == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            exitGame();
        }
    }

    public void exitGame() {
        JOptionPane.showMessageDialog(this, "Goodbye!");
        System.exit(0);

    }
}