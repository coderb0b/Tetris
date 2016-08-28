package my.game.tetrisproject.logic;

import java.util.Arrays;
import java.util.Random;
import my.game.tetrisproject.domain.Block;
import my.game.tetrisproject.domain.Tetromino;

/**
 * Board luokka vastaa lautaan liittyvästä logiikasta ja tilasta
 */
public class Board {

    // Boardin sisältämät muodot tietyissä koordinaateissa
    private char[][] boardCoords = null;
    private Block[][] stationaryBlocks = null;

    private final int width;
    private final int height;

    private Tetromino current; //Laudalla aktiivinen Tetromino    
    int curX = 0; //Tetromino palan x-koordinaatti.
    int curY = 0; //Tetromino palan y-koordinaatti.

    boolean isFallingFinnished = false;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.stationaryBlocks = new Block[height][width];
        this.boardCoords = new char[height][width]; //Standard size 22 X 10 for Tetris
        resetBoard(); //luodaan Board tyhjillä muodoilla
        newPiece(); //luodaan uusi random Tetromino        

    }

    /**
     * Palautetaan laudan sisältö halutusta koordinaatista
     */
    public char getShapeFromBoard(int x, int y) {
        return boardCoords[y][x];
    }

    public Block getStationaryBlock(int x, int y) {
        return stationaryBlocks[y][x];
    }

    /**
     * Palautetaan laudalla aktiivinen Tetromino
     *
     * @return
     */
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
        this.current = new Tetromino(muodot.charAt(r.nextInt(5)));
        //this.current = new Tetromino('I');
        this.isFallingFinnished = false;

        //minY Tetrominon pienin y-koordinaatin arvo suhteessa itseensä
        int minY = current.getBlocks().get(0).getY();
        for (int i = 0; i < 4; i++) {
            minY = Math.min(minY, current.getBlocks().get(i).getY());
        }

        this.current.setTetroX(width / 3);
        //this.current.setTetroY(height - 1 + minY);
        this.current.setTetroY(0 + 1 - minY);
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

    private void clearFallingStatus() {
        for (int i = 0; i < this.boardCoords.length; i++) {
            for (int j = 0; j < this.boardCoords[i].length; j++) {
                if (isFallingFinnished && getShapeFromBoard(j, i) == 'F') {
                    this.boardCoords[i][j] = 'X';
                } else if (!isFallingFinnished && getShapeFromBoard(j, i) == 'F') {
                    this.boardCoords[i][j] = 'X';
                }
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
    /**
     * Kiinnitetään tetromino laudalle
     */
    public void addToBoard() {

        for (Block b : this.current.getBlocks()) {
            int x = this.current.getTetroX() + b.getX();
            int y = this.current.getTetroY() - b.getY();
            if (isFallingFinnished) {
                boardCoords[y][x] = this.current.getShape();
                stationaryBlocks[y][x] = b;
            } else {
                clearFallingStatus();
                boardCoords[y][x] = 'F';
            }

        }
        if (isFallingFinnished) {
            clearFallingStatus();
            newPiece();
        }
    }

}
