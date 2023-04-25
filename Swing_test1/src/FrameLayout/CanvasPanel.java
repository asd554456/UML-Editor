package FrameLayout;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import Line.*;
import Shape.*;

public class CanvasPanel extends JPanel{
	
	public List<BaseShape> shapes = new LinkedList<BaseShape>();
	public List<BaseLine> lines = new LinkedList<BaseLine>();
	
	public GroupBorder a;
	public List<BaseShape> groupShape = new LinkedList<BaseShape>();
	public List<BaseShape> storeShape = new LinkedList<BaseShape>();
	public List<BaseLine> storeLine = new LinkedList<BaseLine>();
	
	public CanvasPanel() {
		super();
		this.setLayout(null);
	}
	
	public void addShape(BaseShape shape) {
		shapes.add(shape);
		this.add(shape);
	}
	
	public void removeShpae(BaseShape shape) {
		shapes.remove(shape);
		
		// remove all component in JLayerPanel, to reset z-order
		this.removeAll();
		
		// reset all component z-order
		for(int i=0; i<shapes.size(); i++)
			this.add(shapes.get(i), Integer.valueOf(i));

		repaint();
		
	}
	
	
	
	public void addLine(BaseLine line) {
		lines.add(line);
		this.add(line);
		
	}
	
	public void removeLine(BaseLine line) {
		lines.remove(line);
		this.removeAll();
		
		// reset all component z-order
		for(int i=0; i<lines.size(); i++)
			this.add(lines.get(i), Integer.valueOf(i));

		repaint();
		
	}
	
	public void newBorder(GroupBorder border) {
		a = border;
		this.add(a);
	}

	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(BaseShape shape:shapes) {
			shape.draw(g);
		}
		for(BaseLine line:lines) {
			line.draw(g);
		}
		
		repaint();
		
		if (a == null)
			return;
		
		a.draw(g);
	}
	
	public List<BaseShape> getShapes(){
		return shapes;
	}
	
	public List<BaseLine> getLines(){
		return lines;
	}
	
	public void storeShape(List<BaseShape> shapes) {
		storeShape = shapes;
	}
	
	public List<BaseShape> getStoreShapes(){
		return storeShape;
	}
}
