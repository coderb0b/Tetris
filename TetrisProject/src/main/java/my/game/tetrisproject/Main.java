
package my.game.tetrisproject;

//import javax.swing.Renderer;
import my.game.tetrisproject.gui.Ui;
import my.game.tetrisproject.gui.TRenderer;
import my.game.tetrisproject.gui.Updater;
import my.game.tetrisproject.logic.Board;
import my.game.tetrisproject.logic.Game;

public class Main {
    //ohjelman käynnistävä luokka
    
    public static void main(String[] args){
        
        
        
        //Board b = new Board(2, 4);
        Game peli = new Game();
        
        TRenderer r = new TRenderer(peli);
        
        
        Ui UserInterface = new Ui(r);
        UserInterface.run();
        
        
        
        
        
    }
    
    
}
