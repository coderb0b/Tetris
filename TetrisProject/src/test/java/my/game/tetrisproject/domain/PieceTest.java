package my.game.tetrisproject.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class PieceTest {

    private Piece piece;

    public PieceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @Before
    public void createPiece() {
        piece = new Piece("" +
                    "..X.\n" +
                    "..X.\n" +
                    "..X.\n" +
                    "..X.\n");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void consists_of_many_blocks() {
        assertEquals(""
                + "..X.\n"
                + "..X.\n"
                + "..X.\n"
                + "..X.\n", piece.toString());
    }
    
    
    @Test
    public void rotateRight() {
        piece = piece.rotateRight();
        assertEquals(""
                + "....\n"                
                + "....\n"
                + "XXXX\n"
                + "....\n", piece.toString());        
    }
    
    @Test
    public void rotateLeft() {
        piece = piece.rotateLeft();
        assertEquals(""
                + "....\n"
                + "XXXX\n"
                + "....\n"
                + "....\n", piece.toString());        
    }

}
