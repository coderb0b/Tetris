package my.game.tetrisproject.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class TetrominoTest {

    private Tetromino shape;

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
        this.shape = Tetromino.I;
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hasCorrectShape() {
        assertEquals(""                
                + "....\n"
                + "IIII\n"
                + "....\n"
                + "....\n", shape.toString());
    }
    @Ignore
    @Test
    public void rotateRight() {
        this.shape.rotateRight();
        assertEquals(""                
                + "..I.\n"
                + "..I.\n"
                + "..I.\n"
                + "..I.\n", shape.toString());
    }

}
