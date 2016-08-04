/*
 Luodaan seitsemän palikkaa, jotka koostuvat neljästä Block luokan palasta.
 */
package my.game.tetrisproject.domain;

public class Block {

    private int x;
    private int y;
    private char color;

    public Block(int x, int y, char color) {
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

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }
    
    

}
