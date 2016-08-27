package my.game.tetrisproject.logic;

import my.game.tetrisproject.domain.Block;
import my.game.tetrisproject.domain.Tetromino;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class BoardTest {

    private Board board;
    private Tetromino tetro;
    private Game peli;

    public BoardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.peli = new Game();
        this.board = this.peli.getBoard();
        this.tetro = new Tetromino('Z');
    }

    @Before
    public void dropBlock() {

    }

    @After
    public void tearDown() {
    }
    
    private void drawBoard() {
        char b[][] = this.peli.getBoard().getBoardState();

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j]);

            }
            System.out.println();
        }
    }

    @Test
    public void returnCorrectDimensions() {
        Assert.assertEquals(22, this.board.getHeight());
        Assert.assertEquals(10, this.board.getWidth());
    }

    @Test
    public void returnCorrectRandomTetro() {
        System.out.println(this.board.getCurrentTetro().getShape());
    }
/*
    @Test
    public void returnBoardState() {
        this.board.addToBoard();
        drawBoard();

    }
*/
    @Test
    public void returnShapeFromCoords() {

        this.board.addToBoard();
        char b[][] = this.board.getBoardState();
        //drawBoard();

        System.out.println("Muoto:  " + this.board.getShapeFromBoard(3, 0));

    }
    
    
    @Test
    public void movingDown(){
        this.board.addToBoard();
        drawBoard();
        peli.moveDown();
        System.out.println("siirto");
        drawBoard();
        System.out.println("--------");
        
        //this.board.newPiece();
        this.board.addToBoard();
        drawBoard();        
        peli.moveDown();
        System.out.println("siirto2");
        drawBoard();
        
    }
    @Ignore
    @Test
    public void moveOneDown(){
        this.board.addToBoard();
        drawBoard();
        peli.moveOneDown();
        System.out.println("siirto");
        drawBoard();
        System.out.println("--------");
/*        
        this.board.newPiece();
        this.board.addToBoard();
        drawBoard();        
        peli.moveOneDown();
        System.out.println("siirto2");
        drawBoard();
*/        
    }

}
