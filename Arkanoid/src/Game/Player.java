package Game;

import java.awt.Color;
import java.awt.Graphics;


public class Player {
	private int x,y,size;
	
	
	
	public Player(int size){this.size = size;}	
	public int getX(){return x;}
	public int getY(){return y;}
	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	
public void setPosition(int x){		
		this.x =x;
		
	}
	public void move(int dx){
		x+=dx;	
		
		///xD do poprawy xD@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		if(x<0){
			x=0;
		}
		else if(x>800-size)
		{
			x=800-size;
		}
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		
	}
	
	public void render(Graphics g2d){
		g2d.setColor(Color.green);		
		g2d.fillRect(x, y, size, 20); // 20 to wysokoœæ deski 
		
	}

}
