package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {


	public static final int WIDTH =800;
	public static final int HEIGHT = 600;	
	public static final int SIZE_PLAYER = 150;	
	
	public static final int sizeX = 25;	
	public static final int sizeY = 10;	
	//Render
	//private Graphics g2d;

	//game loop
	private Thread thread; 
	private boolean running;
	//game items 

	
		
	//movment
	private int dx=20;
	//Abstract Factory
	private FactoryBall FactoryBall;
	private FactoryGun FactoryGun;

	
	//key input 

	
	public GamePanel(){		
		 setPreferredSize(new Dimension(WIDTH,HEIGHT));
		 setFocusable(true);
		 requestFocus();
		 addKeyListener(this);
		 }
	
	public void addNotify(){
		super.addNotify();  
		thread = new Thread(this);
		thread.start();
	}
	




	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();		

		if(k == KeyEvent.VK_LEFT) FactoryBall.player.move(-dx);
		if(k == KeyEvent.VK_RIGHT) FactoryBall.player.move(dx);
		if(k == KeyEvent.VK_SPACE){FactoryGun.setPosition(FactoryBall.player.getX()); FactoryGun.createProductA();		
		FactoryGun.setPosition(FactoryBall.player.getX()+SIZE_PLAYER-8); FactoryGun.createProductA();	}	

	}



	@Override
	 public void run() {
		  init();
		
		  if (running == true){					
		  update();	 		
		  for(;;){	
		    try{		  
		     Thread.sleep(10);		    	
		     update();			     
		    }catch(Exception e  ){
		     e.printStackTrace();		    
		   }
		  }
		  }
		 }
	
	private void init() 
	{
	
		
	
	
		running= true;		
		


		
		FactoryGun = new FactoryGun();
		FactoryGun.setY(530);
		FactoryGun.setSize(sizeX, sizeY);	
		FactoryGun.createProductB();
		
		
		FactoryBall = new FactoryBall();
		FactoryBall.setSize(sizeX, sizeY);	
		FactoryBall.createProductB();
		FactoryBall.createProductA();
		
			
	}
	
	private void update(){
		   repaint(); 
		   FactoryGun.move();
		   FactoryBall.move();
	}

	
	public void paint(Graphics g2d){
		g2d.setColor(Color.black); // czarne t³o 
		g2d.fillRect(0,0,WIDTH,HEIGHT);		
		
		//player.render(g2d); // paletka 
	
		
		FactoryGun.render(g2d);
		FactoryBall.render(g2d);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
