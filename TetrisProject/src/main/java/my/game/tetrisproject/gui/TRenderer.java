package my.game.tetrisproject.gui;

import java.awt.Graphics;
import javax.swing.JPanel;
import my.game.tetrisproject.logic.Board;
import my.game.tetrisproject.logic.Game;

public class TRenderer extends JPanel implements Updater {
    //Piirtoalusta

    private Board board;

    public TRenderer(Board board) {
        this.board = board;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
    }

    private void drawBoard(Graphics g) {
        /* 
         for (int i = 0; i < this.board.getBoard(); i++) {
            
         }
         */

        //g.drawLine(200, 100, 100, 300);
        
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                //piirretään Tetrominot tällä.. Kesken..
                
            }
            
        }
    }

    @Override
    public void update() {
        repaint();
    }

}
