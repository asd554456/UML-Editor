package Shape;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.JComponent;

import Line.BaseLine;

public abstract class BaseShape extends JComponent{

	protected int inset;
	protected boolean isSelected;
	protected String name;
	protected Port[] ports = new Port[4];				// Port 在 shape 的相對座標
	protected Port[] ports_g = new Port[4];			// Port 在 screen 上的座標
	
	protected int x_pos;
	protected int y_pos;
	protected int width_pos;
	protected int height_pos;
	
	protected int shapeCount;
	protected Point shape_g = new Point();
	
	int x;
	int y;
	
	public BaseShape() {
		super();
		this.inset = 0;
		super.setName("空");
		isSelected = false;
		
		shapeCount = 0;
	}

	public BaseShape(int x, int y ,int width, int height, int inset, String name) {
		super();
		//System.out.println("BaseShape cons");
		this.inset = inset;
		this.name = name;
		
		this.x_pos = x;
		this.y_pos = y;
		this.width_pos = width;
		this.height_pos = height;
		
		this.x = x;
		this.y = y;
		
		this.setBounds(x, y, width, height);
		setPortPosition_relative(x, y);
		this.setName(name);
		isSelected = false;
	}

	
	public void draw(Graphics g) {	
		drawYourShape(g);
		drawYourPort(g);
	}
	
	public abstract void drawYourShape(Graphics g);
	
	public void drawYourPort(Graphics g) {
		if (!isSelected)
			return;
		for (Port port:ports) {
			port.draw(this, g);
		}
	}
	
	@Override
	public void setName(String name) {
		if(name == null || name.isEmpty())
			name = "";
		super.setName(name);
	}
	/*
	public int getWidth_f() {
		return getWidth();
	}
	
	public int getHeight_f() {
		return getHeight();
	}
	*/
	public void setSelected(boolean flag) {
		this.isSelected = flag;
	}
	
	public boolean getSelected() {
		return this.isSelected;
	}
	
	public void addShape(BaseShape shape) {}
	
	public void setPortPosition_relative(int x, int y) {
		
		for (int i = 0; i < 4; i++) {
			ports[i] = new Port();
			ports_g[i] = new Port();
		}
		// Top
		ports[0].pos.x = getWidth()/2;
		ports[0].pos.y = 0;
		// Button
		ports[1].pos.x = getWidth()/2;
		ports[1].pos.y = getHeight() - 2;
		// Left
		ports[2].pos.x = 0;
		ports[2].pos.y = getHeight()/2;
		// Right
		ports[3].pos.x = getWidth() - 2;
		ports[3].pos.y = getHeight()/2;
		
		setPortPosition_global(x, y);
	}
	
	public void setPortPosition_global(int x, int y) {
		for (int i = 0; i < ports.length; i++) {
			ports_g[i].pos.x = ports[i].pos.x + x;
			ports_g[i].pos.y = ports[i].pos.y + y;
			//System.out.println("x_global:" + ports_g[i].getLocation() + "y_global:" + ports_g[i].getLocation());
		}
		
	}
	
	public Port[] getShapePort() {
		return ports_g;
	}
	
	public Point getShape_global() {
		Point p = new Point();
		p.x = x;
		p.y = y;
		return p;
	}
	
	public void updatePortPosition(int deltaX, int deltaY) {
		for(int i = 0; i < ports_g.length; i++) {
			ports_g[i].pos.x += deltaX;
			ports_g[i].pos.y += deltaY;
		}
	}
	
	public Port getNearPort(Point p) {
		//System.out.println("point:" + p);
		/*
		Port result = null;
		double min_distance = Integer.MAX_VALUE;
		
		for(Port position:ports_g) {
			System.out.println("Port的座標(before getDistance):" + position.pos.getLocation());
			double distance = getDistance(p, position.pos.getLocation());
			System.out.println("兩點座標:" + distance);

			if(distance < min_distance) {
				result = position;
				min_distance = distance;
			}
		}
		
		return result;
		*/
		int porta = 0;
		Port result = null;
		int min_distance = Integer.MAX_VALUE;
		System.out.println("mouse click position is " + p);
		for(int i = 0; i < ports_g.length; i++) {
			int d = (int)getDistance(ports_g[i].getPortPosition().getLocation(), p);
			System.out.println("No." + i + "，ports position is " + ports_g[i].getPortPosition().getLocation() + "，distance:" + d);
			if (d < min_distance) {
				min_distance = d;
				result = ports_g[i];
				porta = i;
				System.out.println(porta + " port is the shortest distance now");
			}
		}
		System.out.println("most short distance:" + min_distance + "，porta: " + porta);
		System.out.println("pos:" + result.pos.getLocation() + " PortPosistion:" + result.getPortPosition().getLocation());
		return result;
	}
	
	public double getDistance(Point A, Point B) {
		//System.out.println("我點的座標:" + A);
		//System.out.println("Port的座標:" + B);
		return Math.sqrt(Math.pow(A.x-B.x, 2)) + Math.pow(A.y-B.y, 2);
	}
	
	public int getShapeCount() {
		return shapeCount;
	}
}
