package Line;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import Shape.Port;
import Shape.BaseShape;
import UMLManager.FrameManager;

public class CompositionLine extends BaseLine{

	public CompositionLine(BaseShape shape1, BaseShape shape2, Port start, Port end) {
		super(shape1, shape2, start, end);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawYourLine(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		
		// draw line
		g.drawLine((int)minS.getPortPosition().getX(), (int)minS.getPortPosition().getY(), (int)minE.getPortPosition().getX(), (int)minE.getPortPosition().getY());

		// draw arrow
		Point Start = minS.getPortPosition().getLocation();
		Point End = minE.getPortPosition().getLocation();
        double phi = Math.toRadians(40);
        int barb = 20;
		Graphics2D g2 = (Graphics2D)g;
        double dy = End.y - Start.y;
        double dx = End.x - Start.x;
        double theta = Math.atan2(dy, dx);
        
        double x, y, x2, y2, x3, y3, rho = theta + phi;
        
        x = End.x - barb * Math.cos(rho);
        y = End.y - barb * Math.sin(rho);
        g2.draw(new Line2D.Double(End.x, End.y, x, y));
        rho = theta - phi;
        
        x2 = x - barb * Math.cos(rho);
        y2 = y - barb * Math.sin(rho);
        g2.draw(new Line2D.Double(x, y, x2, y2));
        rho = theta - phi;

        x3 = End.x - barb * Math.cos(rho);
        y3 = End.y - barb * Math.sin(rho);
        g2.draw(new Line2D.Double(x2, y2, x3, y3));
        
        g2.draw(new Line2D.Double(End.x, End.y, x3, y3));
	}
}
