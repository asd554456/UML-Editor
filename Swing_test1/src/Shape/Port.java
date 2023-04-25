package Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

public class Port extends JComponent{

	protected Point pos = new Point();
	
	public Port() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void draw(JComponent j, Graphics g) {
		g.setColor(Color.black);
		g.fillRect(j.getX() + pos.x - 7, j.getY() + pos.y - 7, 15, 15);
	}
	
	public Point getPortPosition() {
		return pos;
	}
}
