
package my.game.tetrisproject.domain;

public class Tetromino {
    
    private String shape;
    
    public static Tetromino I = new Tetromino("" +
                    "....\n" +
                    "IIII\n" +
                    "....\n" +
                    "....\n");
    
    
    public Tetromino(String shape) {
        this.shape = shape;
    }
    
    @Override
    public String toString() {
        return this.shape;
    }
    
}
