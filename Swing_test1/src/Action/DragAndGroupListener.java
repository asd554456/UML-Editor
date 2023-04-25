package Action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import FrameLayout.CanvasPanel;
import Line.BaseLine;
import Line.GroupBorder;
import Shape.BaseShape;

public class DragAndGroupListener extends MouseAdapter{
	
	// group border info
	private CanvasPanel canvasPanel;
	private GroupBorder groupBorder;
		
	// shape & line info
	private List<BaseShape> shapes;
	private List<BaseLine> lines;

	public DragAndGroupListener(CanvasPanel canvasPanel, List<BaseShape> shapes, List<BaseLine> lines) {
		super();
		this.canvasPanel = canvasPanel;
		this.shapes = shapes;
		this.lines = lines;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		resetSelected();
		groupBorder = new GroupBorder(e.getX(), e.getY());
		canvasPanel.newBorder(groupBorder);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		groupBorder.updateBorder(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// check shapes those contain in rect
		groupBorder.checkShapeInBorder(shapes);
		groupBorder.checkLineInBorder(lines);
		groupBorder.releaseBorder();
	}
	
	public void resetSelected() {
		for (BaseShape shape:shapes) {
			shape.setSelected(false);
		}
	}
}
