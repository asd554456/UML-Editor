package Shape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import Line.BaseLine;
import UMLManager.FrameManager;

public class GroupBaseShape extends BaseShape{

	
	private List<BaseShape> shapeGroup;
	
	//int i = 0;
	
	
	public GroupBaseShape() {
		super();
	}
	
	public GroupBaseShape(String name) {
		super();
		super.setName(name);
		shapeGroup = new ArrayList<BaseShape>();
	}
	
	@Override
	public void draw(Graphics g) {
		drawYourShape(g);
		
		// draw string
		g.setColor(Color.blue);
		g.setFont(new Font("Arial", Font.BOLD, 15));
		g.drawString(getName(), getX()+getWidth()/2, getY()+getHeight()/2);
		
		
		for(BaseShape shape : shapeGroup) {
			
			shape.drawYourShape(g);
		}
		
		drawYourPort(g);
		
		
	}
	
	@Override
	public void drawYourShape(Graphics g) {
		// TODO Auto-generated method stub
		Rectangle2D rectangle = new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(new Color(0,0,0,.2f));
		g2d.fill(rectangle);
		g2d.setColor(Color.black);
		g2d.draw(rectangle);
		
		
	}
	
	@Override
	public void drawYourPort(Graphics g) {
		if (!isSelected)
			return;
		for (Port port:ports) {
			port.draw(this, g);
		}
	}
	@Override
	public void setSelected(boolean flag) {
		super.setSelected(flag);
		for(BaseShape shape : shapeGroup)
			shape.setSelected(false);
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		super.setPortPosition_relative(x, y);
	}
	
	@Override
	public void setLocation(int x, int y) {
		Point oldPoint = this.getLocation();
		super.setLocation(x, y);
		
		int deltaX = x - oldPoint.x;
		int deltaY = y - oldPoint.y;
		for(BaseShape shape: shapeGroup) {
			shape.setLocation(shape.getX()+deltaX, shape.getY()+deltaY);
			shape.updatePortPosition(deltaX, deltaY);
		}


	}
	
	@Override
	public void addShape(BaseShape shape) {
		//System.out.println("addshpae");
		shapeGroup.add(shape);
		calculateBounds();
	}
	

	public List<BaseShape> getShapes(){
		return shapeGroup;
	}
	
	private void calculateBounds() {
		
		
		/*
		x = getMinInGroupShape(shapeGroup, "x");
		y = getMinInGroupShape(shapeGroup, "y");
		width = getLengthInGroupShape(shapeGroup, "x");
		height = getLengthInGroupShape(shapeGroup, "y");
		
		System.out.println("x:" + x + "y:" + y + "width:" + width + "height:" + height);

		
		this.setBounds(x, y, width, height);
		*/
		int minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE;
		int maxx = Integer.MIN_VALUE, maxy = Integer.MIN_VALUE;
		
		for(BaseShape shape : shapeGroup) {
			minx = shape.getX() < minx ? shape.getX() : minx;
			miny = shape.getY() < miny ? shape.getY() : miny;
			maxx = shape.getX()+shape.getWidth() > maxx ? shape.getX()+shape.getWidth() : maxx;
			maxy = shape.getY()+shape.getHeight() > maxy ? shape.getY()+shape.getHeight() : maxy;
		}
		
		this.setBounds(minx, miny, maxx-minx, maxy-miny);
	}
	/*
	public int getLengthInGroupShape(List<BaseShape> shapes, String XorY) {
		int max = 0;
		
		switch (XorY) {
		case "x":
			for (BaseShape shape:shapes) {
				if (max < shape.x_pos + shape.width_pos) {
					max = shape.x_pos + shape.width_pos;
				}
			}
			max -= x;
			break;
			
		case "y":
			for (BaseShape shape:shapes) {
				if (max < shape.y_pos + shape.height_pos) {
					max = shape.y_pos + shape.height_pos;
				}
			}
			max -= y;
		}

		return max;
	}
	
	public int getMinInGroupShape(List<BaseShape> shapes, String XorY) {
		int min = 99999;
		switch (XorY) {
		case "x":
			for (BaseShape shape:shapes) {
				if (min > shape.x_pos) {
					min = shape.x_pos;
				}
			}
			break;
			
		case "y":
			for (BaseShape shape:shapes) {
				if (min > shape.y_pos) {
					min = shape.y_pos;
				}
			}
		}
		return min;
	}
	*/
	@Override
	public int getShapeCount() {
		return this.shapeGroup.size();
	}
}
