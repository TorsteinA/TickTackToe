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
    private JLabel jLbl3;

    public GUI(GameController gameController) {

        this.gameController = gameController;
        pPos = 4;
        System.out.println("GUI object emerged");
        JLabel jLbl1 = new JLabel("Tick Tack Toe", JLabel.CENTER);
        jLbl1.setFont(new Font("Onyx", Font.BOLD, 54));

        jLbl2 = new JLabel("Someone's turn", JLabel.CENTER);
        jLbl2.setFont(new Font("Serif", Font.PLAIN, 24));

        jLbl3 = new JLabel("Character", JLabel.CENTER);
        jLbl3.setFont(new Font("Serif", Font.PLAIN, 24));


        for (int i = 0; i <= 8; i++) {
            buttonList.add(new JButton());
        }
        setTitle("Tick Tack Toe");
        setSize(400, 500);
        int height = 3;
        int width = 3;

        JPanel jPanel = new JPanel(new GridLayout(width, height));
        add(jPanel, BorderLayout.CENTER);

        JPanel jp2 = new JPanel(new BorderLayout(100, 10));
        add(jp2, BorderLayout.NORTH);

        JPanel jp3 = new JPanel(new BorderLayout());
        jp2.add(jp3, BorderLayout.SOUTH);

        for (JButton jButton : buttonList) {
            jPanel.add(jButton);
            jButton.addActionListener(this);
        }
        jp2.add(jLbl1, BorderLayout.NORTH);
        jp3.add(jLbl2, BorderLayout.WEST);
        jp3.add(jLbl3, BorderLayout.EAST);
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
            gameController.resetGame();
        }
    }

    public void resetButtonList() {
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
        buttonList.get(button).setFont(new Font("Arial", Font.PLAIN, 40));
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
        jLbl3.setText(String.valueOf(player.getCharacter()));
    }

    public int winPrint(Player player) {
        int reply = JOptionPane.showConfirmDialog(this, player.getName() + " wins the game!\nDo you want to reset the game?", "Winner!", JOptionPane.YES_NO_OPTION);

        return reply;

    }

    public int tiePrint() {
        int reply = JOptionPane.showConfirmDialog(this, "There's a tie!\n" +
                "Do you want to reset the game?", "Tie", JOptionPane.YES_NO_OPTION);
        return reply;
    }

    public void showExit() {
        JOptionPane.showMessageDialog(this, "Goodbye!");
    }
}