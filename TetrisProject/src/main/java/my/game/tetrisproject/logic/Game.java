/*

 */
package my.game.tetrisproject.logic;

public class Game {

    private Board board;

    public Game() {
        this.board = new Board(22, 10);
    }

    public Board getBoard() {
        return this.board;
    }

    /**
     * Testataan onko siirto mahdollista.
     *
     * @param nextX mihin ruutuun yritetään siirtyä x-koordinaatti
     * @param nextY mihin ruutuun yritetään siirtyä y-koordinaatti
     */
    public boolean tryMove(int nextX, int nextY) {
        for (int i = 0; i < this.board.getCurrentTetro().getBlocks().size(); i++) {

            int x = nextX + this.board.getCurrentTetro().getBlocks().get(i).getX();
            int y = nextY - this.board.getCurrentTetro().getBlocks().get(i).getY();

            //Tarkistetaan onko koordinaatti laudalla
            if (x < 0 || x >= this.board.getWidth() || y < 0 || y >= this.board.getHeight()) {
                return false;
            }

            //System.out.println("siirrytään x  " + x);
            //System.out.println("siirrytään y  " + y);

            if (this.board.getShapeFromBoard(x, y) != 'X' && this.board.getShapeFromBoard(x, y) != 'F') {

                return false;
            }
        }

        this.board.newPiece();
        this.board.curX = nextX;
        this.board.curY = nextY;
        this.board.isFallingFinnished = true;

        return true;

    }

    /**
     * Siirretään laudan aktiivista tetrominoa rivikerrallaan alaspäin.
     */
    public void moveDown() {
        int nextY = this.board.curY;

        while (nextY > 0) {
            //System.out.println("uusi arvo:  " + nextY);
            if (!tryMove(this.board.curX, nextY - 1)) {
                break;

            }

            --nextY;

        }
        this.board.addToBoard();
    }

}
