package Action;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import Button.ButtonType;
import FrameLayout.CanvasPanel;
import Line.BaseLine;
import Shape.BaseShape;
import Shape.GroupBaseShape;
import UMLManager.ActionManager;
import UMLManager.FrameManager;

public class DragAndDropListener extends MouseAdapter {

	private CanvasPanel canvasPanel;
	private BaseShape curshape;
	private BaseShape prevshape = null;
	private int mouseX;
	private int mouseY;
	
	public DragAndDropListener(CanvasPanel canvasPanel) {
		super();
		this.canvasPanel = canvasPanel;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		//System.out.println("you press " + e.getSource());
		//System.out.println("store size " + canvasPanel.getStoreShapes().size());
		
		curshape = (BaseShape)e.getSource();
		curshape.setSelected(true);
		
		if (curshape != prevshape && prevshape != null) {
			prevshape.setSelected(false);
		}
		
		prevshape = curshape;
		
		mouseX = e.getX();
		mouseY = e.getY();	
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// get new drag point
		Point newDragP = e.getPoint();
		
		// get previous point and dragging distance
		int prev_x = curshape.getX();
		int prev_y = curshape.getY();
		int deltX = newDragP.x-mouseX;
		int deltY = newDragP.y-mouseY;
		
		// update shape location
		curshape.setLocation((prev_x+deltX), (prev_y+deltY));
		
		// update shape port position
		curshape.updatePortPosition(deltX, deltY);
	}

}
