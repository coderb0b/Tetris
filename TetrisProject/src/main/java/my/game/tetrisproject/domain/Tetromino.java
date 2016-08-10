
package my.game.tetrisproject.domain;

public class Tetromino {
    
    private String shape;
    
    public static Tetromino I = new Tetromino("" +
                    "....\n" +
                    "IIII\n" +
                    "....\n" +
                    "....\n");
    
    public static Tetromino J = new Tetromino("" +
                    ".I..\n" +
                    ".III\n" +
                    "....\n" +
                    "....\n");
    
    public static Tetromino L = new Tetromino("" +
                    "....\n" +
                    ".III\n" +
                    ".I..\n" +
                    "....\n");
    
    public static Tetromino O = new Tetromino("" +
                    ".II.\n" +
                    ".II.\n" +
                    "....\n" +
                    "....\n");
    
    public static Tetromino S = new Tetromino("" +
                    "..II\n" +
                    ".II.\n" +
                    "....\n" +
                    "....\n");
    
    public static Tetromino Z = new Tetromino("" +
                    "II..\n" +
                    ".II.\n" +
                    "....\n" +
                    "....\n");
    
    public static Tetromino T = new Tetromino("" +
                    "..I.\n" +
                    ".III\n" +
                    "....\n" +
                    "....\n");
    
    
    public Tetromino(String shape) {
        this.shape = shape;
    }
    
    @Override   
    public String toString() {
        return this.shape;
    }
    
    public void rotateRight() {
        
    }
    
}
