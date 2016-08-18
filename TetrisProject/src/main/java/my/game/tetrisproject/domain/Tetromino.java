package my.game.tetrisproject.domain;

import java.util.ArrayList;
import my.game.tetrisproject.gui.Direction;

public class Tetromino {

    private ArrayList<Block> blocks;
    private char shape;
    private Direction direction;

    public Tetromino(char shape) {
        this.blocks = new ArrayList<Block>();
        setTetrominoShape(shape);

        this.direction = direction.DOWN;

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
        }
    }

    public Direction getDir() {
        return this.direction;
    }

    public Direction setDir(Direction newDir) {
        return this.direction = newDir;
    }

    private void emptyBlocks() {
        this.blocks.clear();
    }

    private Block createBlock(int x, int y, char color) {
        Block block = new Block(x, y, color);
        return block;
    }

    private void tetrominoI() {
        emptyBlocks();
        this.shape = 'I';
        //Käytetään toistaiseksi värille vain kirjainta
        blocks.add(createBlock(0, -1, 'Y'));
        blocks.add(createBlock(0, 0, 'Y'));
        blocks.add(createBlock(0, 1, 'Y'));
        blocks.add(createBlock(0, 2, 'Y'));
    }

    private void tetrominoL() {
        emptyBlocks();
        this.shape = 'L';
        blocks.add(createBlock(-1, -1, 'B'));
        blocks.add(createBlock(0, -1, 'B'));
        blocks.add(createBlock(0, 0, 'B'));
        blocks.add(createBlock(0, 1, 'B'));
    }

    private void tetrominoZ() {
        emptyBlocks();
        this.shape = 'Z';
        blocks.add(createBlock(0, -1, 'R'));
        blocks.add(createBlock(0, 0, 'R'));
        blocks.add(createBlock(-1, 0, 'R'));
        blocks.add(createBlock(-1, 1, 'R'));
    }

    private void tetrominoS() {
        emptyBlocks();
        this.shape = 'S';
        blocks.add(createBlock(0, -1, 'G'));
        blocks.add(createBlock(0, 0, 'G'));
        blocks.add(createBlock(1, 0, 'G'));
        blocks.add(createBlock(1, 1, 'G'));
    }

    private void tetrominoT() {
        emptyBlocks();
        this.shape = 'T';
        blocks.add(createBlock(-1, 0, 'V'));
        blocks.add(createBlock(0, 0, 'V'));
        blocks.add(createBlock(1, 0, 'V'));
        blocks.add(createBlock(0, 1, 'V'));
    }

    private void tetrominoO() {
        emptyBlocks();
        this.shape = 'O';
        blocks.add(createBlock(0, 0, 'M'));
        blocks.add(createBlock(1, 0, 'M'));
        blocks.add(createBlock(0, 1, 'M'));
        blocks.add(createBlock(1, 1, 'M'));
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
