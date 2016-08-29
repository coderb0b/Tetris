package my.game.tetrisproject.gui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Ui implements Runnable {

    private JFrame frame;
    private TRenderer renderer;

    public Ui(TRenderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void run() {
        this.frame = new JFrame("Tetris");
        this.frame.setPreferredSize(new Dimension(400, 500));
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents();
        this.frame.pack();
        this.frame.setVisible(true);
    }

    private void createComponents() {
        this.frame.getContentPane().add(this.renderer);
        
        KeyboardListener keysPressed = new KeyboardListener(this.renderer.getGame());
        this.frame.addKeyListener(keysPressed);

    }

/*    
    public Updater getUpdater() {
        return this.renderer;
    }
*/
}
