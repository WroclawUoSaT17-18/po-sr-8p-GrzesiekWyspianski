package Game;

import java.awt.Graphics;

public interface AbstractFactory {
	
	public void createProductA();
	public void createProductB();	
	public void render(Graphics g2d);
	public void setSize(int sizeX, int sizeY);

}
