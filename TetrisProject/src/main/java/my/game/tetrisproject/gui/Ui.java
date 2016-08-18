package my.game.tetrisproject.gui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import my.game.tetrisproject.Tetris;
import my.game.tetrisproject.logic.Board;

public class Ui implements Runnable {

    private JFrame frame;
    private Tetris tetris;
    private Board board;
    private TRenderer renderer;

    public Ui(TRenderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void run() {
        this.frame = new JFrame("Tetris");
        this.frame.setPreferredSize(new Dimension(500, 400));
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents();
        this.frame.pack();
        this.frame.setVisible(true);
    }

    private void createComponents() {
        this.frame.getContentPane().add(this.renderer);
        
        
    }

}
