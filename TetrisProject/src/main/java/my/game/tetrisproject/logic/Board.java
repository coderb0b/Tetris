package my.game.tetrisproject.logic;

import java.util.Arrays;
import java.util.Random;
import my.game.tetrisproject.domain.Block;
import my.game.tetrisproject.domain.Tetromino;

public class Board {

    //*private char[] boardBlocks;
    // Boardin sisältämät muodot tietyissä koordinaateissa
    private char[][] boardCoords = null;

    private final int width;
    private final int height;

    private Tetromino current; //Laudalla aktiivinen Tetromino    
    int curX = 0; //Tetromino palan x-koordinaatti.
    int curY = 0; //Tetromino palan y-koordinaatti.

    boolean isFallingFinnished = false;
    boolean isFallingStarted = false;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;

        //this.boardBlocks = new Block[height][width]; //Standard size 22 X 10
        //*this.boardBlocks = new char[width * height];
        newPiece(); //luodaan uusi random Tetromino
        this.isFallingStarted = true;
        this.boardCoords = new char[height][width];
        resetBoard(); //luodaan Board tyhjillä muodoilla

    }

    /**
     * Palautetaan laudan sisältö halutusta koordinaatista
     */
    public char getShapeFromBoard(int x, int y) {
        return boardCoords[y][x];
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

    public char[][] getBoardState() {
        return this.boardCoords;
    }

    public void newPiece() {
        String muodot = "ILZSTO";
        Random r = new Random();
        //this.current = new Tetromino(muodot.charAt(r.nextInt(5)));
        this.current = new Tetromino('I');
        this.isFallingStarted = true;

        //minY Tetrominon pienin y-koordinaatin arvo suhteessa itseensä
        int minY = current.getBlocks().get(0).getY();
        for (int i = 0; i < 4; i++) {
            minY = Math.min(minY, current.getBlocks().get(i).getY());
        }

        curX = width / 3;
        curY = height - 1 + minY;
    }

    /**
     * Alustetaan lauta, tyhjät ruudut merkataan 'X' charilla.
     */
    private void resetBoard() {
        for (int i = 0; i < this.boardCoords.length; i++) {
            for (int j = 0; j < this.boardCoords[i].length; j++) {
                this.boardCoords[i][j] = 'X';

            }
        }

    }

    /*
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
     */
    public void addToBoard() {

        for (Block b : this.current.getBlocks()) {
            int x = curX + b.getX();
            int y = curY - b.getY();
            if (isFallingFinnished) {
                boardCoords[y][x] = this.current.getShape();
            } else{
                boardCoords[y][x] = 'F';
            }
            
        }
    }

}
