package my.game.tetrisproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class Tetris extends Timer implements ActionListener {

    private int width;
    private int length;

    public Tetris(int width, int length) {

        this.width = width;
        this.length = length;
        //this.con
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
