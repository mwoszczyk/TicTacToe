package pl.mwosz.TicTacToe;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI extends JFrame implements viewUpdate, MouseListener, winCheck {

    private TicTacToe game;
    private int n;
    private Cell[][] cellTab;

    public GUI(TicTacToe game) {
        this.game = game;
        this.game.setView(this);
        this.game.setWinInterface(this);
        this.n = game.getN();
        cellTab = new Cell[n][n];
        GridLayout layout = new GridLayout(n,n);
        setLayout(layout);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j ++) {
                cellTab[i][j] = new Cell();
                cellTab[i][j].addMouseListener(this);
                add(cellTab[i][j]);
            }
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(320,320));
        setVisible(true);
    }

    @Override
    public void isItWin(int i, int j, String reaction) {
        cellTab[i][j].setA(reaction);
        this.repaint();
    }

    @Override
    public void checkUpdate(int i, int j, String mark) {
        cellTab[i][j].setA(mark);
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Cell s = (Cell) e.getSource();
        boolean flag = true;
        for (int i = 0; i < cellTab.length && flag; i++) {
            for (int j = 0; j < cellTab[i].length && flag; j++) {
                if (cellTab[i][j] == s) {
                    game.move(i,j);
                    flag = false;
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Cross starts:");
                new GUI(game);
            }
        });
    }
}
