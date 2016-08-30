package my.game.tetrisproject.domain;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Tetromino luo omat palanasa ja luokka sisältää myös kiertoihin liittyvän logiikan. 
 */
public class Tetromino {

    //Tetrominon sisältämät palikat
    private ArrayList<Block> blocks;
    private char shape;

//Tetrominon koordinaatit pelilaudalla.
    private int tetroX;
    private int tetroY;

    public Tetromino(char shape) {
        this.blocks = new ArrayList<Block>();
        setTetrominoShape(shape);

        this.tetroX = 0;
        this.tetroY = 0;

    }

    public void setTetrominoShape(char shape) {
        switch (shape) {
            case 'I':
                tetrominoI();
                break;
            case 'L':
                tetrominoL();
                break;
            case 'Z':
                tetrominoZ();
                break;
            case 'S':
                tetrominoS();
                break;
            case 'T':
                tetrominoT();
                break;
            case 'O':
                tetrominoO();
                break;
            case 'X': //empty shape
                tetrominoX();
                break;
        }
    }

    public int getTetroX() {
        return this.tetroX;
    }

    public int getTetroY() {
        return this.tetroY;
    }

    public void setTetroX(int x) {
        this.tetroX = x;
    }

    public void setTetroY(int y) {
        this.tetroY = y;
    }

    private void emptyBlocks() {
        this.blocks.clear();
    }

    private Block createBlock(int x, int y, Color color) {
        Block block = new Block(x, y, color);
        return block;
    }

    private void tetrominoI() {
        emptyBlocks();
        this.shape = 'I';
        blocks.add(createBlock(0, -1, Color.YELLOW));
        blocks.add(createBlock(0, 0, Color.YELLOW));
        blocks.add(createBlock(0, 1, Color.YELLOW));
        blocks.add(createBlock(0, 2, Color.YELLOW));
    }

    private void tetrominoL() {
        emptyBlocks();
        this.shape = 'L';
        blocks.add(createBlock(-1, -1, Color.BLUE));
        blocks.add(createBlock(0, -1, Color.BLUE));
        blocks.add(createBlock(0, 0, Color.BLUE));
        blocks.add(createBlock(0, 1, Color.BLUE));
    }

    private void tetrominoZ() {
        emptyBlocks();
        this.shape = 'Z';
        blocks.add(createBlock(0, -1, Color.RED));
        blocks.add(createBlock(0, 0, Color.RED));
        blocks.add(createBlock(-1, 0, Color.RED));
        blocks.add(createBlock(-1, 1, Color.RED));
    }

    private void tetrominoS() {
        emptyBlocks();
        this.shape = 'S';
        blocks.add(createBlock(0, -1, Color.GREEN));
        blocks.add(createBlock(0, 0, Color.GREEN));
        blocks.add(createBlock(1, 0, Color.GREEN));
        blocks.add(createBlock(1, 1, Color.GREEN));
    }

    private void tetrominoT() {
        emptyBlocks();
        this.shape = 'T';
        blocks.add(createBlock(-1, 0, Color.MAGENTA));
        blocks.add(createBlock(0, 0, Color.MAGENTA));
        blocks.add(createBlock(1, 0, Color.MAGENTA));
        blocks.add(createBlock(0, 1, Color.MAGENTA));
    }

    private void tetrominoO() {
        emptyBlocks();
        this.shape = 'O';
        blocks.add(createBlock(0, 0, Color.CYAN));
        blocks.add(createBlock(1, 0, Color.CYAN));
        blocks.add(createBlock(0, 1, Color.CYAN));
        blocks.add(createBlock(1, 1, Color.CYAN));
    }

    private void tetrominoX() {
        emptyBlocks();
        this.shape = 'X';
    }

    public ArrayList<Block> getBlocks() {
        return this.blocks;
    }

    public Tetromino rotateRight() {

        //ei kierretä neliö Tetrominoa
        if (this.shape == 'O') {
            return this;
        }

        int xNew;
        int yNew;

        for (int i = 0; i < this.blocks.size(); i++) {

            xNew = this.blocks.get(i).getY();
            yNew = -this.blocks.get(i).getX();

            this.blocks.get(i).setX(xNew);
            this.blocks.get(i).setY(yNew);

        }

        return this;
    }

    public Tetromino rotateLeft() {

        //ei kierretä neliö Tetrominoa
        if (this.shape == 'O') {
            return this;
        }

        int xNew;
        int yNew;

        for (int i = 0; i < this.blocks.size(); i++) {

            xNew = -this.blocks.get(i).getY();
            yNew = this.blocks.get(i).getX();

            this.blocks.get(i).setX(xNew);
            this.blocks.get(i).setY(yNew);

        }

        return this;
    }

    public char getShape() {
        return this.shape;
    }

}
