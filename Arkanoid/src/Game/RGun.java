package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;




public class RGun extends AbstractProductB {
	private int x,y,sizeX,sizeY;
	
	
	
	public RGun(int sizeX, int sizeY){
		this.sizeX = sizeX;
		this.sizeY = sizeY;}	
	
	public int getX(){return x;}
	public int getY(){return y;}
	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	
	public void setPosition(int x, int y) {
		this.x =x;
		this.y= y;
		
	}
	public void render(Graphics g2d){
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(x, y, sizeX-2, sizeY-1);		
	}
	public Rectangle getBound(){
		return new Rectangle(x,y, sizeX,  sizeY);	
		
	}

}
 