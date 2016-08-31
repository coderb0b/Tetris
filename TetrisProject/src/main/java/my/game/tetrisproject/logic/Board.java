package my.game.tetrisproject.logic;

import java.util.Random;
import my.game.tetrisproject.domain.Block;
import my.game.tetrisproject.domain.Tetromino;

/**
 * Board luokka vastaa lautaan liittyvästä logiikasta ja tilasta sekä palojen
 * liikuttamisesta.
 */
public class Board {

    //Boardin sisältämät muodot tietyissä koordinaateissa
    private char[][] boardCoords = null;
    //Perille tulleet palikat
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
     * Palautetaan laudan sisältö halutusta koordinaatista.
     */
    public char getShapeFromBoard(int x, int y) {
        return boardCoords[y][x];
    }

    /**
     * Palauta laudalta block x/y-koordinaateista.
     * @param x
     * @param y
     */
    public Block getStationaryBlock(int x, int y) {
        return stationaryBlocks[y][x];
    }

    /**
     * Palautetaan laudalla aktiivinen Tetromino.
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

    /**
     * Luodaan uusi random Tetromino.
     */
    public boolean newPiece() {
        //Jos aloitusruudussa on kiinnitetty block, niin peli on loppu.
        if (this.stationaryBlocks[0][3] != null) {
            return false;
        }

        String muodot = "ILZSTO";
        Random r = new Random();
        this.current = new Tetromino(muodot.charAt(r.nextInt(6)));
        this.isFallingFinnished = false;

        //minY Tetrominon pienin y-koordinaatin arvo suhteessa itseensä
        int minY = current.getBlocks().get(0).getY();
        for (int i = 0; i < 4; i++) {
            minY = Math.min(minY, current.getBlocks().get(i).getY());
        }

        this.current.setTetroX(width / 3);
        //this.current.setTetroY(height - 1 + minY);
        this.current.setTetroY(0 + 1 - minY);

        return true;
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

    /**
     * Laudalta poistetaan aktiiviset palikat.
     */
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

    private void removeLine() {

        for (int i = this.height - 1; i > 0; i--) {
            //Oletetaan rivin olevan täysi
            boolean lineIsFull = true;

            for (int j = 0; j < this.width; j++) {
                if (getShapeFromBoard(j, i) == 'X') {
                    lineIsFull = false;
                    break;
                }
            }
            if (lineIsFull) {

                for (int k = 0; k < this.width; k++) {
                    for (int korkeus = i; korkeus > 0; korkeus--) {
                        stationaryBlocks[korkeus][k] = stationaryBlocks[korkeus - 1][k];
                        stationaryBlocks[korkeus - 1][k] = null;
                        boardCoords[korkeus][k] = getShapeFromBoard(k, korkeus - 1);
                        boardCoords[korkeus  - 1][k] = 'X';

                    }

                }
                removeLine();
            }

        }

    }

    /**
     * Kiinnitetään tetromino laudalle.
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
            removeLine();
            newPiece();
        }
    }

}
