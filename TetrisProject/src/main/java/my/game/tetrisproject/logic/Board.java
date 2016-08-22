package my.game.tetrisproject.logic;

import java.util.Arrays;
import java.util.Random;
import my.game.tetrisproject.domain.Block;
import my.game.tetrisproject.domain.Tetromino;

public class Board {

    // Boardin sisältämät Blocksit
    private final char[][] boardBlocks;

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

        this.boardBlocks = new char[height][width]; //Standard size 22 X 10
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
        curX = width / 3;
        curY = height - 1;
    }

    public void addToBoard(Tetromino t) {
        isFallingStarted = false;

        for (int i = 0; i < t.getBlocks().size(); i++) {
            // Blockin x/y arvot asetetaan boardBlocksiin
            int x = t.getBlocks().get(i).getX();
            int y = t.getBlocks().get(i).getY();

            this.boardBlocks[x][y] = t.getShape();

        }

    }

}
