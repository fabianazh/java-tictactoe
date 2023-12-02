package TicTacToe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Panel extends JPanel {
    private JButton[][] buttons;
    private char currentPlayer;

    public Panel() {
        setLayout(new GridLayout(3, 3));
        initializeBoard();
    }

    private void initializeBoard() {
        buttons = new JButton[3][3];
        currentPlayer = 'X';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 36));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton source = (JButton) e.getSource();
                        if (source.getText().isEmpty()) {
                            source.setText(String.valueOf(currentPlayer));
                            if (checkForWinner()) {
                                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
                                resetBoard();
                            } else {
                                switchPlayer();
                            }
                        }
                    }
                });
                add(buttons[i][j]);
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        currentPlayer = 'X';
    }

    private boolean checkForWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (checkLine(buttons[i][0].getText(), buttons[i][1].getText(), buttons[i][2].getText())) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (checkLine(buttons[0][i].getText(), buttons[1][i].getText(), buttons[2][i].getText())) {
                return true;
            }
        }

        if (checkLine(buttons[0][0].getText(), buttons[1][1].getText(), buttons[2][2].getText()) ||
            checkLine(buttons[0][2].getText(), buttons[1][1].getText(), buttons[2][0].getText())) {
            return true;
        }

        return false;
    }

    private boolean checkLine(String a, String b, String c) {
        return a.equals(b) && b.equals(c) && !a.isEmpty();
    }
}
