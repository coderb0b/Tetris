package my.game.tetrisproject.domain;

import java.util.ArrayList;

public class Tetromino {

    private ArrayList<Block> blocks = new ArrayList<Block>();
    //Tetrominon leveys ja korkeus
    private int width;
    private int heigth;

    public Tetromino(char shape) {
        switch (shape) {
            case 'I':
                tetrominoL();
        }

    }

    private Block createBlock(int x, int y, char color) {
        Block block = new Block(x, y, color);
        return block;
    }

    private void tetrominoL() {
        //Käytetään toistaiseksi värille vain kirjainta
        blocks.add(createBlock(0, -1, 'Y'));
        blocks.add(createBlock(0, 0, 'Y'));
        blocks.add(createBlock(0, 1, 'Y'));
        blocks.add(createBlock(0, 2, 'Y'));
    }

    public ArrayList<Block> getBlocks() {
        return this.blocks;
    }
}
