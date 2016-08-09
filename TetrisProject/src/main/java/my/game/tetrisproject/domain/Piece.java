package my.game.tetrisproject.domain;

public class Piece {

    private final char[][] blocks; //Kaksiulotteinen taulukko kuvaa Tetrominopalaa, taulukossa oleva String kuvaa palanmuotoa.
    //private final String shape;

    public Piece(String shape) {
        String[] rows = shape.split("\n");
        this.blocks = new char[rows.length][rows.length];
        for (int row = 0; row < rows.length; row++) {
            this.blocks[row] = rows[row].toCharArray();
        }
        //this.shape = shape;
    }

    private Piece(char[][] blocks) {
        this.blocks = blocks;
    }
    
    
    @Override
    public String toString() {
        String s = "";
        for (int row = 0; row < blocks.length; row++) {
            for (int col = 0; col < blocks[row].length; col++) {
                char c = blocks[row][col];
                s += c;
            }
            s += '\n';

        }

        return s;
    }

    //blocks taulukko kopioidaan uuteen taulukkoon rotated
    // 90 astetta myötäpäivään
    public Piece rotateRight() {
        char[][] rotated = new char[blocks.length][blocks.length];

        for (int row = 0; row < blocks.length; row++) {
            for (int col = 0; col < blocks[row].length; col++) {
                rotated[col][4 - 1 - row] = blocks[row][col];
            }

        }
        return new Piece(rotated);
    }
    
    //90 astetta vastapäivään = 3 X myötäpäivään
    public Piece rotateLeft() {
        return this.rotateRight().rotateRight().rotateRight();
    }
    
    public int getRows() {
        return this.blocks.length;
    }
    
    public int getCollumns() {
        return this.blocks.length;
    }

}
