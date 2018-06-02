package Game;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTestFactoryGun {

	@Test
	public void test() {
		boolean test = false;
		boolean test2 = false;
		boolean test3 = false;
		FactoryGun Gun = new FactoryGun();
		Gun.setY(300);		
		Gun.setPosition(300);
		
		// wyprodukowanie jednego produktu 
		Gun.createProductA();
		int i= Gun.getLength();		
		if(i==1)  test = true;
		assertEquals(true, test);
		
		//		wyprodukowanie dodatkowo 20 element�w 
		
		for(int a=0 ; a<20 ;a++)
		{
			Gun.createProductA();
			Gun.move();		
			i= Gun.getLength();
			System.out.println("d�ugo�� = "+i);
		}
		
	
		if(i==21)  test2 = true;
		assertEquals(true, test2);	
		
		// sprawdzanie czy obiekty s� usuwane 
				
		Gun.createProductB();
		for(int B=0 ; B<10 ;B++)
		{			
			Gun.move();	
	
		}
		i= Gun.getLength();
		System.out.println("d�ugo�� = "+i);
		
		if(i==21)  test3 = true;
		assertEquals(true, test3);		
		

		
	}

}
