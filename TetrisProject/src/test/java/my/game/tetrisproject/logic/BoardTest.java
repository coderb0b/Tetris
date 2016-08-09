package my.game.tetrisproject.logic;

import my.game.tetrisproject.domain.Block;
import my.game.tetrisproject.domain.Piece;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    private final Board board = new Board(3, 3);
    private final Block block = new Block(2, 3, 'C');

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
    }

    @Before
    public void dropBlock() {
        board.drop(new Block(1, 1, 'X'));
    }

    @After
    public void tearDown() {
    }
    /*
     @Test
     public void createEmptyBoard() {
     assertEquals(""
     + "...\n"
     + "...\n"
     + "...\n", board.toString());
     }
     */

    @Test
    public void createCorrectSizeBoard() {
        assertEquals(board.getRows(), 3);
        assertEquals(board.getCollumns(), 3);
    }

    @Test
    public void blockFalls() {
        assertTrue(board.hasFalling());
    }

    @Test
    public void blockIsDroppedInTheMiddle() {
        assertEquals(""
                + ".X.\n"
                + "...\n"
                + "...\n", board.toString());
    }

    @Test
    public void blockDropsOneRowPerTick() {

        board.tick();

        assertEquals(""
                + "...\n"
                + ".X.\n"
                + "...\n", board.toString());

    }

    @Test
    public void blockStopsAtTheBottom() {
        board.tick();
        board.tick();
        board.tick();
        assertEquals(""
                + "...\n"
                + "...\n"
                + ".X.\n", board.toString());
    }

    @Test
    public void blockStopsAtAnotherBlock() {
        board.tick();
        board.tick();
        board.tick();
        board.tick();

        assertEquals(""
                + "...\n"
                + "...\n"
                + ".X.\n", board.toString());
        assertFalse(board.hasFalling());

        board.drop(new Block(1, 1, 'O'));

        assertEquals(""
                + ".O.\n"
                + "...\n"
                + ".X.\n", board.toString());

        board.tick();
        board.tick();

        assertEquals(""
                + "...\n"
                + ".O.\n"
                + ".X.\n", board.toString());
        assertFalse(board.hasFalling());

    }

}
