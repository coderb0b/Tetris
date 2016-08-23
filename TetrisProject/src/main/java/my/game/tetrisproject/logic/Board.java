package my.game.tetrisproject.logic;

import java.util.Arrays;
import java.util.Random;
import my.game.tetrisproject.domain.Block;
import my.game.tetrisproject.domain.Tetromino;

public class Board {

    // Boardin sisältämät Blocksit
    private char[] boardBlocks;

    private final int width;
    private final int height;
    private Tetromino current;
    //Tetromino palan sijainti laudalla.
    int curX = 0;
    int curY = 0;
    boolean isFallingFinnished = false;
    boolean isFallingStarted = false;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;

        //this.boardBlocks = new Block[height][width]; //Standard size 22 X 10
        this.boardBlocks = new char[width * height];
        createBoard();
        newPiece(); //luodaan uusi random Tetromino

    }

    private char getShapeFromBoard(int x, int y) {
        return boardBlocks[(y * width) + x];
    }

    public Tetromino getCurrentTetro() {
        return this.current;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public char[] getBoard() {
        return this.boardBlocks;
    }

    private void newPiece() {
        String muodot = "ILZSTO";
        Random r = new Random();
        this.current = new Tetromino(muodot.charAt(r.nextInt(5)));
        
        int minY = current.getBlocks().get(0).getY();
        for (int i = 0; i < 4; i++) {
            minY = Math.min(minY, current.getBlocks().get(i).getY());
        }
        
        curX = width / 3;
        curY = height - 1 + minY;
    }
    
    //Alustetaan lauta
    private void createBoard() {
        for (int i = 0; i < height * width; i++) {
            this.boardBlocks[i] = 'X';
        }
        
    }

    public void addToBoard() {
        //isFallingStarted = false;

        //int x = t.getBlocks().get(i).getX();
        //int y = t.getBlocks().get(i).getY();
        for (int i = 0; i < this.current.getBlocks().size(); i++) {
            
            int x = curX + this.current.getBlocks().get(i).getX();
            int y = curY - this.current.getBlocks().get(i).getY();

            this.boardBlocks[y * width + x] = this.current.getShape();
        }

    }

}
