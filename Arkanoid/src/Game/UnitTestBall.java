package Game;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTestBall {

	@Test
	public void test() throws InterruptedException {
		boolean test = false;
		boolean test2 = false;
		int x1 = 400;
		int y1 = 400;
		Ball Ball = new Ball(10,x1,y1);
		Thread.sleep(1200); 
		int x = Ball.getX();
		int y = Ball.getY();
		if(x1 != x && y1 != y) test = true;			
		assertEquals(true, test);
		
		
		if( Ball.getBound().intersects(Ball.getBound())) test2=true;
		assertEquals(true, test2);
	}

}
