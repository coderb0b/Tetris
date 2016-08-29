package my.game.tetrisproject.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import my.game.tetrisproject.gui.Updater;

/**
 * Luokka sisältää palojen siirtämiseen liittyvän logiikan ja peli-luupin.
 */
public class Game implements ActionListener {

    private Board board;
    private Updater updateBoard;
    private boolean gameStarted = false;
    private Timer timer; //Swing ajastin, jolla lähetetään ActionEventtejä.

    public Game() {
        this.board = new Board(22, 10);
        timer = new Timer(500, this); //lähetetään ActionEventtejä 0,5 sekunnin välein.
        start();
    }

    public void start() {
        gameStarted = true;
        timer.start(); //Ajastin käyntiin -> alkaa lähettämään ActionEventtejä.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (board.isFallingFinnished) {
            board.isFallingFinnished = false;
            board.newPiece();
            if (!board.newPiece()) {
                timer.stop();
            }
        } else {
            moveOneDown();
        }
    }

    /**
     * Asetetaan Gamelle piirtoalusta, jotta tuolle voidaan antaa
     * päivityskäskyjä
     */
    public void setUpdater(Updater updateBoard) {
        this.updateBoard = updateBoard;
    }

    public Board getBoard() {
        return this.board;
    }

    /**
     * Testataan onko haluttu siirto mahdollinen.
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

        this.board.getCurrentTetro().setTetroX(nextX);
        this.board.getCurrentTetro().setTetroY(nextY);

        return true;

    }

    /**
     * Siirretään laudan aktiivista tetrominoa rivikerrallaan alaspäin, kunnes
     * pohja tulee vastaan tai mahdollisesti muita palikoita.
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
        updateBoard.update();
    }

    /**
     * Siirretään laudan aktiivista tetrominoa yksi rivi alaspäin.
     */
    public void moveOneDown() {
        if (tryMove(this.board.getCurrentTetro().getTetroX(), this.board.getCurrentTetro().getTetroY() + 1)) {
            this.board.addToBoard();
            updateBoard.update();
        } else {
            this.board.isFallingFinnished = true;
            this.board.addToBoard();
            updateBoard.update();
        }

    }

}
