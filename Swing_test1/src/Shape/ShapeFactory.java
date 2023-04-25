package Shape;

import javax.swing.JOptionPane;

import Button.ButtonType;

public class ShapeFactory {
	
	public int x;
	public int y;
	public int width;
	public int height;
	public int inset;
	public String name;
	
	public ShapeFactory(int x, int y ,int width, int height, int inset, String name) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.inset = inset;
		this.name = name;
	}
	
	public BaseShape createShape(ButtonType btn) {
		String F_name = null;
		BaseShape result = null;
		switch(btn) {
		case Class:
			result = new ClassShape(x, y, width, height, inset, F_name);
			break;
			
		case UseCase:
			result = new UseCaseShape(x, y, width, height, inset, F_name);
			break;
		}
		return result;
	}
}
