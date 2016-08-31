package my.game.tetrisproject.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import my.game.tetrisproject.domain.Tetromino;
import my.game.tetrisproject.logic.Game;

/**
 * Luokka kuuntelee näppäimistön komentoja ja käskyttää näiden perusteella
 * peliä ja tetrominoa.
 */
public class KeyboardListener implements KeyListener {

    private final Game game;

    public KeyboardListener(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Kuuntelee painettuja näppäinkomentoja.
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        Tetromino active = game.getBoard().getCurrentTetro();
        
        
        if (e.getKeyCode() == KeyEvent.VK_UP) {            
            active.rotateLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            active.rotateRight();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.game.tryMove(active.getTetroX() + 1, active.getTetroY());
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.game.tryMove(active.getTetroX() - 1, active.getTetroY());
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.game.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            this.game.moveOneDown();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
