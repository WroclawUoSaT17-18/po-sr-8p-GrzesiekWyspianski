package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public  class Gun extends AbstractProductA {

	private int x,y,size;	
	
	
	public Gun(int size){this.size = size;}	
	
	public int getX(){return x;}
	public int getY(){return y;}
	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	
	public void setPosition(int x){		
		this.x =x;		
	}

	public void setPosition(int x, int y) {
		
		this.x =x;
		this.y =y;
	}
	
	public void move(int dy)
	{
		y-=dy;
	}
	
	public  void render(Graphics g2d) {
		g2d.setColor(Color.RED);		
		g2d.fillRect(x, y, size, 15);
		
	}
	public Rectangle getBound(){
		return new Rectangle(x,y, size, 15);
	}
	


	

}
