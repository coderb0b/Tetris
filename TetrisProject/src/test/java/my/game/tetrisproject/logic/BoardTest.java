package my.game.tetrisproject.logic;

import my.game.tetrisproject.domain.Block;
import my.game.tetrisproject.domain.Tetromino;
import my.game.tetrisproject.gui.TRenderer;
import my.game.tetrisproject.gui.Ui;

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
    private TRenderer trender;

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
        this.peli.setUpdater(trender);
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
    
     
     

    @Test
    public void returnShapeFromCoords() {

        this.board.addToBoard();
        char b[][] = this.board.getBoardState();

        System.out.println("Muoto:  " + this.board.getShapeFromBoard(3, 0));

    }


    @Ignore
    @Test
    public void moveOneDown() {
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
