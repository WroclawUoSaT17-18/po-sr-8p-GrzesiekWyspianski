package Game;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTestFactoryGun {

	@Test
	public void test() {
		FactoryGun FactoryGun =new FactoryGun();
		FactoryGun.createProductB();
		for(int i=0;i<800;i++){ 
			for(int j=0;j<10;j++){ 
			FactoryGun.createProductA();
			FactoryGun.setPosition(i);
			}
		}
		
		boolean test = false;
		if(FactoryGun.RGUN==null) 
			 test=true;			
				
		assertEquals(true, test);
		fail("Not yet implemented");
	}

}
