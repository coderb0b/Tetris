/*

 */
package my.game.tetrisproject.logic;

public class Game {
    
    private Board board;
    
    public Game(Board b) {
        this.board = b;
    }
    
    public Board getBoard() {
        return this.board;
    }
    
}
