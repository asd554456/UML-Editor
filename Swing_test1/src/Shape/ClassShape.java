package Shape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class ClassShape extends BaseShape {
	
	//ImageIcon icon = new ImageIcon("select.png");
	//Image img = icon.getImage();
	
	public ClassShape() {
		super();
		System.out.println("empty ClassShape create");
	}
	
	public ClassShape(int x, int y ,int width, int height, int inset, String name) {
		super(x, y ,width, height, inset, name);
		//System.out.println("ClassShape create");
	}

	@Override
	public void drawYourShape(Graphics g) {
		// TODO Auto-generated method stub
		//System.out.println("X:" + x_pos + "Y:" + y_pos + "inset:" + inset);
		
		
		g.setColor(Color.white);
		g.fillRect(getX()+inset, getY()+inset, getWidth()-inset*2, getHeight()-inset*2);

		// outside Border
		g.setColor(Color.black);
		g.fillRect(getX(), getY(), getWidth(), inset);	// Top
		g.fillRect(getX(), getY()+getHeight()-inset, getWidth(), inset);	// Buttom
		g.fillRect(getX(), getY(), inset, getHeight());	// Left
		g.fillRect(getX()+getWidth()-inset, getY(), inset, getHeight());	// Right
		
		// inside Border
		g.fillRect(getX(), getY()+(getHeight()/3-inset), getWidth(), inset);	// First
		g.fillRect(getX(), getY()+(2*getHeight()/3-inset), getWidth(), inset);	// Second
		
		
		g.setFont(new Font("Arial", Font.BOLD, 15));
		g.drawString(getName(), getX()+20, getY()+30);

	}
	
}
