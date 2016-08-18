package my.game.tetrisproject.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import my.game.tetrisproject.domain.Tetromino;

public class KeyboardListener implements KeyListener {

    private final Tetromino tetro;

    public KeyboardListener(Tetromino tetro) {
        this.tetro = tetro;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.tetro.setDir(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.tetro.setDir(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.tetro.setDir(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.tetro.setDir(Direction.LEFT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
