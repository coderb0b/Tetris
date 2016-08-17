
package my.game.tetrisproject.gui;

import javax.swing.JFrame;
import my.game.tetrisproject.Tetris;
import my.game.tetrisproject.logic.Board;

public class Ui implements Runnable {
    
    private JFrame frame;
    private Tetris tetris;
    private Board board;
    
    public Ui(Tetris tetris) {
        this.tetris = tetris;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
