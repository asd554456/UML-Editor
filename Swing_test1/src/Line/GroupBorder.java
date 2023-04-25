package Line;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import Shape.BaseShape;

// Â^¨ú®Ø
public class GroupBorder extends JComponent{

	public int x;
	public int y;
	public int width = 0;
	public int height = 0;
	
	
	List<BaseShape> selectedShapes = new ArrayList<BaseShape>();
	List<BaseLine> selectedLines = new ArrayList<BaseLine>();
	public int shapeCount = 0;
	
	public GroupBorder(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		g.setColor(Color.green);
		
		// draw border
		g.drawRect(x, y, width, height);
	}
	
	public void updateBorder(int x, int y) {
		width = x-this.x;
		height = y-this.y;

	}
	
	public void releaseBorder() {
		x = y = width = height = 0;
	}
	
	public void checkShapeInBorder(List<BaseShape> shapes) {

		for (BaseShape shape:shapes) {
			// 4 condition
			if (x < shape.getX() && y < shape.getY() && x + width > shape.getX() + shape.getWidth() && y + height > shape.getY() + shape.getHeight()) {
				shape.setSelected(true);
				//selectedShapes.add(shape);
				//shapeCount++;
			}
		}
	}
	
	public void checkLineInBorder(List<BaseLine> lines) {
		for (BaseLine line:lines) {
			// 4 condition
			if (x < line.start.getX() && y < line.start.getY() && x + width > line.end.getX() && y + height > line.end.getY()) {
				//selectedLines.add(line);
				line.setInGroup(true);
				selectedLines.add(line);
			}
			
		}
	}
	
	
	
	public List<BaseShape> getSelectedShape(){
		return selectedShapes;
	}
	
	public List<BaseLine> getSelectedLine(){
		return selectedLines;
	}
	
	
	//public void AllForOne(List<BaseShape> shapes) {
	//	GroupClassShape shapeGroup = new GroupClassShape(shapes);
	//}
}
