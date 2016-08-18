package my.game.tetrisproject.logic;

import my.game.tetrisproject.domain.Block;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BoardTest {
    
    private Board board;

    

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
        this.board = new Board(22, 10);
    }

    @Before
    public void dropBlock() {
        
    }

    @After
    public void tearDown() {
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

    
    
}
