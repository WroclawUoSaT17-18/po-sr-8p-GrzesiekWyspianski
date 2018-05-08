package Game;

import java.awt.Graphics;
import java.util.ArrayList;

public class FactoryBall implements AbstractFactory {
	
	private ArrayList<RBall> RBALL;	
	private int sizeX, sizeY;
	
	Ball BALL;
	Player player;
	
	FactoryBall()	{
		
		RBALL = new ArrayList<RBall>();
		player= new Player(150);
		player.setPosition(800/2 );
		player.setY(600-50);	
	}
	
	public void setSize(int sizeX, int sizeY){
		this.sizeX =sizeX;
		this.sizeY =sizeY;
	}

	@Override	
	public void createProductA() {
		BALL = new Ball(18,800,600);
		BALL.setPosition(400,400);

	}
	public void move()
	{
		
			for(RBall f: RBALL){	
			if(f.getBound().intersects(BALL.getBound())){ RBALL.remove(f);BALL.swap(); }
			}
			if(BALL.getBound().intersects(player.getBound())){BALL.swap();}
				
	}

	@Override
	public void createProductB() {
		for(int j = 0; j <20; j++ ){
		for(int i =0; i<30 ;i++){
		RBall g = new RBall(sizeX, sizeY);
		g.setPosition(15+(i*sizeX), 30+(j*sizeY));
		RBALL.add(g);}}
	}

	
	public void render(Graphics g2d) {
		if(RBALL != null){
			 for (RBall  e: RBALL){
				   e.render(g2d);			   
				  }}
		if(BALL != null)BALL.render(g2d);
		player.render(g2d);
		
	}

}
