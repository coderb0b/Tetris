package my.game.tetrisproject.logic;

import java.util.Arrays;
import my.game.tetrisproject.domain.Block;
import my.game.tetrisproject.domain.Tetromino;

public class Board {

    private final char[][] stationaryBlocks; //tallettaa perille tulleet palat
    private final int rows;
    private final int columns;
    
    private Tetromino tetro = new Tetromino('I');
    

    private Block falling;
    private int fallingBlockRow;
    private int fallingBlockColumn;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.fallingBlockRow = 0;
        this.fallingBlockColumn = 1;
        this.stationaryBlocks = emptyBoard(rows, columns);

    }

    //Piirretään . kentän tyhjiin kohtiin
    private static char[][] emptyBoard(int rows, int columns) {
        char[][] board = new char[rows][columns];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        return board;
    }

    //Piirretään Tetrisalusta aluksi komentoriville:
    //"..."
    //"..."
    //"..."
    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                //Palan lokaatio
                s += blockLocation(row, col);
            }
            s += "\n";
        }
        return s;
    }

    private char blockLocation(int row, int col) {
        if (hasFallingAt(row, col)) {
            return falling.getColor();
        } else {
            //s += ".";
            return stationaryBlocks[row][col];
        }
    }

    private boolean hasFallingAt(int row, int col) {
        return hasFalling() && row == fallingBlockRow && col == fallingBlockColumn;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCollumns() {
        return this.columns;
    }

    //onko kentässä putoavaa palikaa
    public boolean hasFalling() {
        return falling != null;
    }

    //Pala pudotetaan keskeltä ruutua
    public void drop(Block block) {

        this.falling = block;

        this.fallingBlockRow = 0;
        this.fallingBlockColumn = 1;
    }

    private void stopBlock() {
        stationaryBlocks[fallingBlockRow][fallingBlockColumn] = falling.getColor();
        falling = null;
    }

    public void tick() {
        //Jos kentällä ei ole putoavaa palaa, niin ei yritetä edetä
        if (hasFalling()) {            
            //Jos pohja tulee vastaan, niin pysäytetään palikka
            if (blockHitsFloor()) {
                stopBlock();
            } else {
                //Jos toinen pala tulee vastaan, niin pysäytetään palikka
                if (blockHitsAnotherBlock()) {
                    fallingBlockRow++;
                } else {
                    stopBlock();
                }

            }
        }
    }
    
    private boolean blockHitsFloor() {
        return fallingBlockRow == this.rows - 1;
    }
    
    private boolean blockHitsAnotherBlock() {
        return stationaryBlocks[fallingBlockRow + 1][fallingBlockColumn] == '.';
    }

}
