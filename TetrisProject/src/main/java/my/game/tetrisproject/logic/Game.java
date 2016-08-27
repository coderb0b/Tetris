/*

 */
package my.game.tetrisproject.logic;

import my.game.tetrisproject.gui.Updater;

public class Game {

    private Board board;
    private Updater updateBoard;

    public Game() {
        this.board = new Board(22, 10);
    }

    public void setUpdater(Updater updateBoard) {
        this.updateBoard = updateBoard;
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
        

        //this.board.newPiece();
        this.board.getCurrentTetro().setTetroX(nextX);
        this.board.getCurrentTetro().setTetroY(nextY);
        
        //Tässä kohtaa logiikkaa pitäisi tehdä updateBoard.update();
        

        return true;

    }

    /**
     * Siirretään laudan aktiivista tetrominoa rivikerrallaan alaspäin, kunnes pohja tulee vastaan tai mahdollisesti muita palikoita.
     */
    public void moveDown() {
        int nextY = this.board.getCurrentTetro().getTetroY();

        while (nextY < board.getHeight()) {
            //System.out.println("uusi arvo:  " + nextY);
            if (!tryMove(this.board.getCurrentTetro().getTetroX(), nextY + 1)) {
                break;

            }

            ++nextY;

        }
        this.board.isFallingFinnished = true;
        this.board.addToBoard();
    }

    /**
     * Siirretään laudan aktiivista tetrominoa yksi rivi alaspäin.
     */
    public void moveOneDown() {
        if (tryMove(this.board.getCurrentTetro().getTetroX(), this.board.getCurrentTetro().getTetroY() + 1)) {
            this.board.addToBoard();
            

        }

    }

}
