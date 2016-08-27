package my.game.tetrisproject.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import my.game.tetrisproject.domain.Block;
import my.game.tetrisproject.logic.Board;
import my.game.tetrisproject.logic.Game;

public class TRenderer extends JPanel implements Updater {
    //Piirtoalusta

    private Board board;
    private int scale = 10;

    public TRenderer(Board board) {
        this.board = board;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, board.getWidth() * this.scale, board.getHeight() * this.scale);

        drawBoard(g);
    }

    private void drawBoard(Graphics g) {
        /* 
         for (int i = 0; i < this.board.getBoard(); i++) {
            
         }
         */

        //g.drawLine(200, 100, 100, 300);
        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                //piirretään Tetrominot tällä.. Kesken..
                char shape = this.board.getShapeFromBoard(i, j);
                if (shape != 'X') {
                    g.setColor(Color.CYAN);
                    g.fillRect(i * this.scale + 1, j * this.scale + 1, 20, 20);

                }
            }
        }

        if (board.getCurrentTetro().getShape() != 'X') {
            for (Block b : board.getCurrentTetro().getBlocks()) {
                int x = board.getCurrentTetro().getTetroX() + b.getX();
                int y = board.getCurrentTetro().getTetroY() - b.getY();
                g.setColor(Color.CYAN);
                g.fillRect(x * this.scale + 1, y * this.scale + 1, 20, 20);
            }
        }
    }

    @Override
    public void update() {
        repaint();
    }

}
