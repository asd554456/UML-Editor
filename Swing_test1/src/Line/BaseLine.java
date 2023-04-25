package Line;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;
import Shape.Port;

import Shape.BaseShape;

public abstract class BaseLine extends JComponent {

	protected int inset;
	public BaseShape start;
	public BaseShape end;
	protected Port minS;
	protected Port minE;
	protected boolean inGroup;
	
	public Port start_p[];
	public Port end_p[];
	
	public BaseLine(BaseShape shape1, BaseShape shape2, Port start, Port end) {
		super();
		this.start = shape1;
		this.end = shape2;
		this.minS = start;
		this.minE = end;
		System.out.println("minS:" + minS.getPortPosition().getLocation());
		System.out.println("minE:" + minE.getPortPosition().getLocation());

		this.setBounds(5, 5, 5, 5);
		this.inGroup = false;
		// getTwoPort();

		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		drawYourLine(g);
	}
	
	/* old method, port will connect with shortest distance by 4vs4 16 lines
	public void getTwoPort() {
		//start_p = start.getShapePort();
		//end_p = end.getShapePort();
		//findShortestDistance(start_p, end_p);
	}
	
	public void findShortestDistance(Port[] A, Port[] B) {
		int min = Integer.MAX_VALUE;
		Port[] minP = new Port[2];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				//int d = (int)getDistance(A[i].getPortPosition(), B[j].getPortPosition());
				if (d < min) {
					min = d;
					minS = A[i];
					minE = B[j];
				}	
			}
		}
	}
	*/
	
	public double getDistance(Point A, Point B) {
		return Math.sqrt((B.getX()-A.x)*(B.x-A.x) + (B.y -A.y) * (B.y -A.y));
	}
	
	public void setInGroup(boolean flag) {
		inGroup = flag;
	}
	
	public boolean getInGroup() {
		return inGroup;
	}

	public abstract void drawYourLine(Graphics g);
	
}
