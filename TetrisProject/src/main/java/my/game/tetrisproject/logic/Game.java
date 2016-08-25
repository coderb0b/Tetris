/*

 */
package my.game.tetrisproject.logic;

public class Game {
    
    private Board board;
    
    public Game() {
        this.board = new Board(22, 10);
    }
    
    public Board getBoard() {
        return this.board;
    }
    
    
    
}
