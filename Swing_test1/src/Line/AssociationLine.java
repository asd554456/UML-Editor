package Line;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import Shape.Port;
import Shape.BaseShape;
import UMLManager.FrameManager;

public class AssociationLine extends BaseLine{

	public AssociationLine(BaseShape shape1, BaseShape shape2, Port start, Port end) {
		super(shape1, shape2, start, end);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawYourLine(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		
		// draw line
		g.drawLine(minS.getPortPosition().getLocation().x, minS.getPortPosition().getLocation().y, (int)minE.getPortPosition().getLocation().x, (int)minE.getPortPosition().getLocation().y);
		
		// draw arrow
		Point Start = minS.getPortPosition().getLocation();
		Point End = minE.getPortPosition().getLocation();

        double phi = Math.toRadians(40);
        int barb = 20;
		Graphics2D g2 = (Graphics2D)g;
        double dy = End.y - Start.y;
        double dx = End.x - Start.x;
        double theta = Math.atan2(dy, dx);
        double x, y, rho = theta + phi;
        
        for(int j = 0; j < 2; j++)
        {
            x = End.x - barb * Math.cos(rho);
            y = End.y - barb * Math.sin(rho);
            g2.draw(new Line2D.Double(End.x, End.y, x, y));
            rho = theta - phi;
        }
	}
}
