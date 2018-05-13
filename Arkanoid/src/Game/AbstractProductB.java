package Game;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class AbstractProductB {
	
	public abstract int getX();
	public abstract int getY();
	public abstract void setX(int x);
	public abstract void setY(int y);	
	public abstract void setPosition(int x, int y);
	public abstract void render(Graphics g2d);
	public abstract Rectangle getBound();
	
	

}
