package my.game.tetrisproject.logic;

import java.util.Arrays;
import my.game.tetrisproject.domain.Block;

public class Board {

    private final char[][] stationaryBlocks;
    private final int rows;
    private final int columns;

    private Block falling;
    private int fallingBlockRow = 0;
    private int fallingBlockColumn = 1;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.stationaryBlocks = emptyBoard(rows, columns);

    }

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
                //Tetrominon lokaatio
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

    public void drop(Block block) {

        this.falling = block;
    }

    public void tick() {
        if (fallingBlockRow == this.rows - 1) {
            stationaryBlocks[fallingBlockRow][fallingBlockColumn] = falling.getColor();
            falling = null;
        } else {
            fallingBlockRow++;
        }

    }

}
