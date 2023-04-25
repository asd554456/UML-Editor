package Line;

import java.awt.Color;
import Shape.Port;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

import Shape.BaseShape;
import UMLManager.FrameManager;
import Shape.Port;
public class GeneralizationLine extends BaseLine{

	public GeneralizationLine(BaseShape shape1, BaseShape shape2, Port start, Port end) {
		super(shape1, shape2, start, end);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawYourLine(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		
		// draw line
		g.drawLine((int)minS.getPortPosition().getX(), (int)minS.getPortPosition().getY(), (int)minE.getPortPosition().getX(), (int)minE.getPortPosition().getY());
		
		
		Point Start = minS.getPortPosition().getLocation();
		Point End = minE.getPortPosition().getLocation();
		
        double phi = Math.toRadians(40);
        int barb = 20;
		Graphics2D g2 = (Graphics2D)g;
        double dy = End.y - End.y;
        double dx = End.x - End.x;
        double theta = Math.atan2(dy, dx);
        double x, y, x2, y2, rho = theta + phi;
        
        x = End.x - barb * Math.cos(rho);
        y = End.y - barb * Math.sin(rho);
        g2.draw(new Line2D.Double(End.x, End.y, x, y));
        rho = theta - phi;
        
        x2 = End.x - barb * Math.cos(rho);
        y2 = End.y - barb * Math.sin(rho);
        g2.draw(new Line2D.Double(x, y, x2, y2));

        g2.draw(new Line2D.Double(End.x, End.y, x2, y2));
	}
}
