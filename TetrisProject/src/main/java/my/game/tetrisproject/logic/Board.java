package my.game.tetrisproject.logic;

import java.util.Arrays;
import java.util.Random;
import my.game.tetrisproject.domain.Block;
import my.game.tetrisproject.domain.Tetromino;

public class Board {

    //private final int[][] board;
    private Tetromino[] board;
    private final int width;
    private final int height;
    private Tetromino current;
    int curX = 0;
    int curY = 0;
    boolean isFallingFinnished = false;
    boolean isFallingStarted = false;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.board = new Tetromino[width * height];
        //this.board = new int[height][width]; //Standard size 22 X 10
        newPiece(); //luodaan uusi random Tetromino

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

    private void newPiece() {
        String muodot = "ILZSTO";
        Random r = new Random();
        this.current = new Tetromino(muodot.charAt(r.nextInt(5)));
    }

    public void addToBoard(Tetromino t) {
        for (int i = 0; i < t.getBlocks().size(); i++) {

        }
    }

}
