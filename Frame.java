package TicTacToe;

import javax.swing.JFrame;

public class Frame extends JFrame {
    public Frame() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        Panel panel = new Panel();
        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
