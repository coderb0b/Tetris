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
    private Game game;
    private int scale = 10;

    public TRenderer(Game peli) {
        this.board = peli.getBoard();
        this.game = peli;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, board.getWidth() * this.scale, board.getHeight() * this.scale);

        drawBoard(g);
    }

    private void drawBoard(Graphics g) {
        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                //piirretään Tetrominot tällä.. Kesken..
                char shape = this.board.getShapeFromBoard(i, j);
                Block b = this.board.getStationaryBlock(i, j);
                if (shape == 'F') {
                    g.setColor(board.getCurrentTetro().getBlocks().get(0).getColor());
                    g.fillRect(i * scale + 1, j * scale + 1, scale, scale);

                } else if (b != null) {
                    g.setColor(b.getColor());
                    g.fillRect(i * scale + 1, j * scale + 1, scale, scale);
                }
            }
        }

        if (board.getCurrentTetro().getShape() != 'X') {
            for (Block b : board.getCurrentTetro().getBlocks()) {
                int x = board.getCurrentTetro().getTetroX() + b.getX();
                int y = board.getCurrentTetro().getTetroY() - b.getY();
                g.setColor(b.getColor());
                g.fillRect(x * scale + 1, y * scale + 1, scale, scale);
            }
        }
    }

    @Override
    public void update() {
        this.repaint();
    }

}
