package my.game.tetrisproject;

//import javax.swing.Renderer;
import my.game.tetrisproject.gui.Ui;
import my.game.tetrisproject.gui.TRenderer;
import my.game.tetrisproject.gui.Updater;
import my.game.tetrisproject.logic.Board;
import my.game.tetrisproject.logic.Game;

/**
 * Main-luokka.
 */
public class Main {
    //ohjelman käynnistävä luokka

    public static void main(String[] args) {

        Game peli = new Game();

        TRenderer r = new TRenderer(peli);
        peli.setUpdater(r);

        Ui userInterface = new Ui(r);
        userInterface.run();

    }

}
