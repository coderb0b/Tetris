package my.game.tetrisproject.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class TetrominoTest {

    private Tetromino tetroI = new Tetromino('I');

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

        //Tetromino tetroL = new Tetromino('I');
    }

    @After
    public void tearDown() {
    }

    @Test
    public void returnsRightCoordinates() {
        /*        for (int i = 0; i < tetroI.getBlocks().size(); i++) {
         System.out.println(tetroI.getBlocks().get(i).getX() + "  LOLOLOLOLOL   " + tetroI.getBlocks().get(i).getY());
         }
         */
        assertEquals(tetroI.getBlocks().get(0).getX(), 0);
        assertEquals(tetroI.getBlocks().get(0).getY(), -1);

        assertEquals(tetroI.getBlocks().get(1).getX(), 0);
        assertEquals(tetroI.getBlocks().get(1).getY(), 0);

        assertEquals(tetroI.getBlocks().get(2).getX(), 0);
        assertEquals(tetroI.getBlocks().get(2).getY(), 1);

        assertEquals(tetroI.getBlocks().get(3).getX(), 0);
        assertEquals(tetroI.getBlocks().get(3).getY(), 2);

    }

    @Test
    public void returnsRightCoordinatesWhenNewTetromino() {

        this.tetroI.setTetrominoShape('L');
        assertEquals(4, this.tetroI.getBlocks().size());

        assertEquals(tetroI.getBlocks().get(0).getX(), -1);
        assertEquals(tetroI.getBlocks().get(0).getY(), -1);

        assertEquals(tetroI.getBlocks().get(1).getX(), 0);
        assertEquals(tetroI.getBlocks().get(1).getY(), -1);

        assertEquals(tetroI.getBlocks().get(2).getX(), 0);
        assertEquals(tetroI.getBlocks().get(2).getY(), 0);

        assertEquals(tetroI.getBlocks().get(3).getX(), 0);
        assertEquals(tetroI.getBlocks().get(3).getY(), 1);

    }

    @Test
    public void returnsRightShapeChar() {

        this.tetroI.setTetrominoShape('L');
        assertEquals('L', tetroI.getShape());

    }

    @Test
    public void rotatesRight() {

        this.tetroI.setTetrominoShape('T');

        for (int i = 0; i < tetroI.getBlocks().size(); i++) {
            System.out.println(tetroI.getBlocks().get(i).getX() + "  LOLOLOLOLOL   " + tetroI.getBlocks().get(i).getY());
        }

        System.out.println("\n");
        tetroI.rotateRight();

        for (int i = 0; i < tetroI.getBlocks().size(); i++) {
            System.out.println(tetroI.getBlocks().get(i).getX() + "  LOLOLOLOLOL   " + tetroI.getBlocks().get(i).getY());
        }

        System.out.println("\n");

    }

    @Test
    public void doNotRotateRightIfShapeO() {

        this.tetroI.setTetrominoShape('O');

        for (int i = 0; i < tetroI.getBlocks().size(); i++) {
            System.out.println(tetroI.getBlocks().get(i).getX() + "  LOLOLOLOLOL   " + tetroI.getBlocks().get(i).getY());
        }

        System.out.println("\n");
        tetroI.rotateRight();

        for (int i = 0; i < tetroI.getBlocks().size(); i++) {
            System.out.println(tetroI.getBlocks().get(i).getX() + "  LOLOLOLOLOL   " + tetroI.getBlocks().get(i).getY());
        }
        System.out.println("\n");
    }

    @Test
    public void rotatesLeft() {

        this.tetroI.setTetrominoShape('T');

        for (int i = 0; i < tetroI.getBlocks().size(); i++) {
            System.out.println(tetroI.getBlocks().get(i).getX() + "  LOLOLOLOLOL   " + tetroI.getBlocks().get(i).getY());
        }

        System.out.println("\n");
        tetroI.rotateLeft();

        for (int i = 0; i < tetroI.getBlocks().size(); i++) {
            System.out.println(tetroI.getBlocks().get(i).getX() + "  LOLOLOLOLOL   " + tetroI.getBlocks().get(i).getY());
        }

        System.out.println("\n");

    }

}
