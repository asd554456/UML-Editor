package Action;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Button.ButtonType;
import FrameLayout.CanvasPanel;
import Line.AssociationLine;
import Line.CompositionLine;
import Line.GeneralizationLine;
import Line.LineFactory;
import Line.LineType;
import Shape.BaseShape;
import Shape.ClassShape;
import Shape.Port;

public class LineCreateListener extends MouseAdapter {

	private CanvasPanel canvasPanel;
	private ButtonType btn;
	private BaseShape start;
	private BaseShape end;
	private Port startp;
	private Port endp;
	
	public LineCreateListener(CanvasPanel canvasPanel, ButtonType btn) {
		super();
		this.canvasPanel = canvasPanel;
		this.btn = btn;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		start = (BaseShape)e.getSource();
		System.out.println("start position: " + start.getShape_global());
		Point p = getMouseClickPosition_global(e.getX(), e.getY());
		startp = start.getNearPort(p);
		
		
		start.setSelected(true);
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {

	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.MOUSE_RELEASED == 502) {
			end = (BaseShape)e.getSource();
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		if (end == null)
			return;
		
		end = null;
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e) {

		if (end == null)
			return;
		
		// e.getX() e.getY() will get the position relative with shape1 position
		Point p = getMouseClickPosition_global(e.getX(), e.getY());
		endp = end.getNearPort(p);
		
		LineFactory line = new LineFactory(start, end, startp, endp);
		canvasPanel.addLine(line.createLine(btn));
		
	}
	
	// it will get relative position only when use e.getLocation() method
	public Point getMouseClickPosition_global(int relative_x, int relative_y) {
		Point p = new Point();
		p.x = start.getShape_global().x + relative_x;
		p.y = start.getShape_global().y + relative_y;
		return p;
	}
}