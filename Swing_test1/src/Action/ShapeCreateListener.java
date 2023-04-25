package Action;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import Button.ButtonType;
import Button.ClassButton;
import FrameLayout.ButtonsPanel;
import FrameLayout.CanvasPanel;
import Shape.ClassShape;
import Shape.ShapeFactory;
import Shape.UseCaseShape;

public class ShapeCreateListener extends MouseAdapter{
	
	private CanvasPanel canvasPanel;
	private ButtonType btn;
	
	private String F_name;
	
	private Point shape_g = new Point();
	
	public ShapeCreateListener(CanvasPanel canvasPanel, ButtonType btn) {
		super();
		this.canvasPanel = canvasPanel;
		this.btn = btn;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("x:" + e.getX() + "y:" + e.getY());
		//setShapeGlobalPosition(e.getX(), e.getY());
		F_name = JOptionPane.showInputDialog("Function Name");
		if (F_name == null)
			return;
		ShapeFactory shape = new ShapeFactory(e.getX(), e.getY(), 100, 150, 5, F_name);
		canvasPanel.addShape(shape.createShape(btn));
		
		/*
		switch(btn) {
		case Class:
			//F_name = JOptionPane.showInputDialog("Function Name");
			//System.out.println("you click, x:" + e.getX() + "y:" + e.getY());
			F_name = JOptionPane.showInputDialog("Function Name");
			if (F_name == null)
				return;
			canvasPanel.addShape(new ClassShape(e.getX(), e.getY(), 100, 150, 5, F_name));
			break;
			
		case UseCase:
			//System.out.println("use case create");

			F_name = JOptionPane.showInputDialog("Function Name");
			if (F_name == null)
				return;
			//System.out.println("you click, x:" + e.getX() + "y:" + e.getY());
			canvasPanel.addShape(new UseCaseShape(e.getX(), e.getY(), 150, 100, 0, F_name));
			break;
		}
		*/
	}
	


	public void setShapeGlobalPosition(int x, int y) {
		shape_g.x = x;
		shape_g.y = y;
	}
	
	public Point getShapeGlobalPosition() {
		return shape_g;
	}
}
