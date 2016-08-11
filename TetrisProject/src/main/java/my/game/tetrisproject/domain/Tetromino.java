package my.game.tetrisproject.domain;

import java.util.ArrayList;

public class Tetromino {

    private ArrayList<Block> blocks;
    //Tetrominon leveys ja korkeus
    private int width;
    private int heigth;

    public Tetromino(char shape) {
        this.blocks = new ArrayList<Block>();

        setTetrominoShape(shape);

    }

    public void setTetrominoShape(char shape) {
        switch (shape) {
            case 'I':
                tetrominoI();
                break;
            case 'L':
                tetrominoL();
        }
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
        //Käytetään toistaiseksi värille vain kirjainta
        blocks.add(createBlock(0, -1, 'Y'));
        blocks.add(createBlock(0, 0, 'Y'));
        blocks.add(createBlock(0, 1, 'Y'));
        blocks.add(createBlock(0, 2, 'Y'));
    }

    private void tetrominoL() {
        emptyBlocks();
        blocks.add(createBlock(-1, -1, 'B'));
        blocks.add(createBlock(0, -1, 'B'));
        blocks.add(createBlock(0, 0, 'B'));
        blocks.add(createBlock(0, 1, 'B'));
    }

    public ArrayList<Block> getBlocks() {
        return this.blocks;
    }

    public Tetromino rotateRight() {
        //kesken...

        int xNew;
        int yNew;

        for (int i = 0; i < this.blocks.size(); i++) {
            
            xNew = this.blocks.get(i).getY();
            yNew = -this.blocks.get(i).getX();
            
            this.blocks.get(i).setX(xNew);
            this.blocks.get(i).setY(yNew);

             //this.blocks.get(i).setX(-this.blocks.get(i).getY());
            //this.blocks.get(i).setY(this.blocks.get(i).getX());
        }

        /*
         xNew = -y
         yNew = x
         
         */
        return this;
    }

}
