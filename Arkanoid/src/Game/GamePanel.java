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
	public static final int SIZE_PLAYER = 100;	
	//Render
	//private Graphics g2d;

	//game loop
	private Thread thread; 
	private boolean running;
	//game items 
	private Player player;
	private Ball ball;
	
	//movment
	private int dx=20;


	
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

		if(k == KeyEvent.VK_LEFT) player.move(-dx);//left =true; //update();player.move(-dx);}
		if(k == KeyEvent.VK_RIGHT) player.move(dx);//right =true;//update();player.move(dx);}

		
		

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
		player = new Player(SIZE_PLAYER);
		player.setPosition(WIDTH/2 );
		player.setY(HEIGHT-50);	
		ball= new Ball(20,WIDTH,HEIGHT);
		ball.setPosition(WIDTH/2, HEIGHT/2);
		
			
	}
	
	private void update(){
		   repaint(); // xD 		
	}

	
	public void paint(Graphics g2d){
		g2d.setColor(Color.black); // czarne t³o 
		g2d.fillRect(0,0,WIDTH,HEIGHT);		
		
		player.render(g2d); // paletka 
		ball.render(g2d);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
