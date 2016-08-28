/*
 Luodaan seitsemän palikkaa, jotka koostuvat neljästä Block luokan palasta.
 */
package my.game.tetrisproject.domain;

import java.awt.Color;

public class Block {

     
    private int x;
    private int y;
    //private char color;
    private Color color;

    public Block(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    

}
