package my.game.tetrisproject.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class TetrominoTest {
    
    private Tetromino tetro = new Tetromino('I');

    public TetrominoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    //Luodaan haluttu Tetromino
    @Before
    public void setUp() {
        
       //Tetromino tetro = new Tetromino('I');

    }

    @After
    public void tearDown() {
    }
    
    
    @Test
    public void returnsRightCoordinates() {        
        //for (int i= 0; i< tetro.getBlocks().size(); i++) {
            //System.out.println(tetro.getBlocks().get(i).getX() + "     ytrewrtyyyy   " + tetro.getBlocks().get(i).getY());
            
            assertEquals(tetro.getBlocks().get(0).getX(), 0);
            assertEquals(tetro.getBlocks().get(0).getY(), -1);
            
            assertEquals(tetro.getBlocks().get(1).getX(), 0);
            assertEquals(tetro.getBlocks().get(1).getY(), 0);
            
            assertEquals(tetro.getBlocks().get(2).getX(), 0);
            assertEquals(tetro.getBlocks().get(2).getY(), 1);
            
            assertEquals(tetro.getBlocks().get(3).getX(), 0);
            assertEquals(tetro.getBlocks().get(3).getY(), 2);
        //}
    }

    

}
