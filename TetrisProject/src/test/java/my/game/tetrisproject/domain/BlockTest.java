
package my.game.tetrisproject.domain;

import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BlockTest {
    
    private final Block block = new Block(2, 3, Color.GREEN);
    
    public BlockTest() {
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
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void getCorrectCoordsFromBlock() {
        assertEquals(block.getX(), 2);
        assertEquals(block.getY(), 3);
    }
    
    @Test
    public void setCorrectCoordsToBlock() {
        block.setX(3);
        block.setY(4);
        
        assertEquals(block.getX(), 3);
        assertEquals(block.getY(), 4);
    }
    
    @Test
    public void setCorrectColorToBlock() {
        block.setColor(Color.GREEN);
        
        assertEquals(block.getColor(), Color.GREEN);
        
    }

    
}
