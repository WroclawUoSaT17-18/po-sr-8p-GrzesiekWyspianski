package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends AbstractProductA implements Runnable {
	private int x,y,size;

	private int WIDTH ;
	public int HEIGHT ;
	private boolean UD;
	private boolean RL;
	private boolean PAUSE; 
	
	private Thread thread; 
	

	public int getX(){return x;}
	public int getY(){return y;}
	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	public void setPAUSE(boolean PAUSE){this.PAUSE = PAUSE;}
	
	public void swap(){
		UD =! UD;		
	}
	
	public Ball(int size,int WIDTH ,int HEIGHT){
		this.size = size;
		thread = new Thread(this);
		thread.start();	
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		UD = false;
		RL = true;
	}
	

	
	

	
	public void setPosition(int x, int y){		
		this.x =x;
		this.y =y;
		
	}
	

	 public void run() {
		 try {
			Thread.sleep(1000); // odczekanie 1 s przed startem 
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
		 for (;;) 			 
		 {		
			 if(!PAUSE){
			 if(UD== true)y++;else y--;
			 if(RL== true)x++;else x--;			 
			 if(x>WIDTH-size)RL=!RL;
			 if(x<0)RL= !RL;			 
			 if(y<0)UD= !UD;
			 }

			 
			 try {
				
				Thread.sleep(5);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}	
		 }
	 }	
	
	public void render(Graphics g2d){
		g2d.setColor(Color.RED);		
		g2d.fillOval(x, y, size, size);		
		
		if(y>HEIGHT){
			g2d.drawString("GAME OVER",370, 250);
		}

	}
	public Rectangle getBound(){
		return new Rectangle(x,y, size,  size);			
		
	}

}
