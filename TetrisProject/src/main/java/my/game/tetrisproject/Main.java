
package my.game.tetrisproject;

//import javax.swing.Renderer;
import my.game.tetrisproject.gui.Ui;
import my.game.tetrisproject.gui.TRenderer;
import my.game.tetrisproject.logic.Board;

public class Main {
    //ohjelman käynnistävä luokka
    
    public static void main(String[] args){
        
        Board b = new Board(2, 4);
        TRenderer r = new TRenderer(b);
        
        Ui UserInterface = new Ui(r);
        UserInterface.run();
    }
    
    
}
