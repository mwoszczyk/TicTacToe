package pl.mwosz.TicTacToe;

import javax.swing.*;
import java.awt.*;

public class Cell extends JComponent {

    private String a = "";

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D tmp = (Graphics2D) g;
        super.paintComponent(g);
        tmp.setColor(Color.RED);
        tmp.drawRect(0,0, 100,100);
        Font font = new Font("Serif", Font.BOLD, 30);
        tmp.setFont(font);
        tmp.drawString(a, 38,50);
    }

    public void setA(String text) {
        this. a = text;
    }
}
