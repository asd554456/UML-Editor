package Shape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

//import Action.MenuClickedListener;

public class UseCaseShape extends BaseShape {

	public UseCaseShape() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UseCaseShape(int x, int y ,int width, int height, int inset, String name) {
		super(x, y ,width, height, inset, name);
		//System.out.println("ClassShape create");
	}
	
	public void drawYourShape(Graphics g) {
		
		g.setColor(Color.black);
		g.drawOval(getX(), getY(), getWidth(), getHeight());
		
		g.setColor(Color.white);
		//g.fillOval(getX()+inset, getY()+inset, getHeight()-inset*2, getWidth()-inset*2);
		g.fillOval(getX()+1, getY()+1, getWidth()-2, getHeight()-2);
		
		g.setColor(Color.black);
		g.setFont(new Font("abc", Font.BOLD, 15));
		g.drawString(getName(), getX()+40, getY()+40);
		
	}

}
