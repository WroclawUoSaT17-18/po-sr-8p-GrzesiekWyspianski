package Game;

import java.awt.Color;
import java.awt.Graphics;

public class Ball implements Runnable {
	private int x,y,size;

	private int WIDTH ;
	public int HEIGHT ;
	
	
	private Thread thread; 
	

	public int getX(){return x;}
	public int getY(){return y;}
	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	
	
	public Ball(int size,int WIDTH ,int HEIGHT){
		this.size = size;
		thread = new Thread(this);
		thread.start();	
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
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
			 if((x-size)<WIDTH)x++;
			

			 
			 try {
				
				Thread.sleep(10);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}	
		 }
	 }
	

	
	
	public void render(Graphics g2d){
		g2d.setColor(Color.RED);		
		g2d.fillOval(x, y, size, size);		
	}
	

}
