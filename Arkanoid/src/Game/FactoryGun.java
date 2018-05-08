package Game;

import java.awt.Graphics;
import java.util.ArrayList;







public class FactoryGun implements AbstractFactory {
	
	private ArrayList<Gun> GUN;
	private ArrayList<RGun> RGUN;
	private int y;
	private int x;
	private int sizeX;
	private int sizeY;
	
	public void setY(int y){this.y = y-20;}
	
	
	FactoryGun()
	{
		GUN = new ArrayList<Gun>();
		RGUN = new ArrayList<RGun>();
	}
	
	
	public void setPosition(int x){		
		this.x =x;		
	}
	@Override
	public void setSize(int sizeX, int sizeY){
		this.sizeX =sizeX;
		this.sizeY =sizeY;
	}
	
	public void createProductA() {
		Gun g = new Gun(8);		
		g.setPosition(x,y);
		GUN.add(g);		
	}
	
	public void move()
	{
		for(Gun e: GUN){
			e.move(8);
			if(e.getY()<100) GUN.remove(e); 	
		
		}
		for(Gun e: GUN){
			for(RGun f: RGUN){	
			if(e.getBound().intersects(f.getBound())){RGUN.remove(f); GUN.remove(e); }
		}}
		
	}
	
	
	

	@Override
	public void createProductB() {
		
		for(int i =0; i<30 ;i++){
		RGun g = new RGun(sizeX, sizeY);
		g.setPosition(15+(i*sizeX), 300);
		RGUN.add(g);}
		
	}

	public void render(Graphics g2d) {
		if(GUN != null){
			 for (Gun  e: GUN){
				   e.render(g2d);			   
				  }}
		
		if(RGUN != null){
			 for (RGun  e: RGUN){
				   e.render(g2d);			   
				  }}
		
		
		
	}	

	

}
