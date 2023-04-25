package Action;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import Button.BaseButton;
import Shape.BaseShape;
import UMLManager.FrameManager;

// 在BaseButton 被 new 時加入
public class ButtonClickedListener extends MouseAdapter{
	
	public ButtonClickedListener() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void mousePressed(MouseEvent m) {
		BaseButton prev = FrameManager.getButtonsPanel().getCurrentButton();
		BaseButton curr = (BaseButton)(m.getSource());
		
		// reset port if any shape have been selected
		List<BaseShape> shapes = FrameManager.getCanvasPanel().getShapes();
		resetPort(shapes);

		if(prev != null && curr != prev) {
			prev.setBackground(Color.white);
		}
			
		curr.setBackground(Color.gray);
		curr.onClicked();
		
		FrameManager.getButtonsPanel().setCurrentButton(curr);
		
		//System.out.println("curr click is" + curr);
		//System.out.println("prev click is" + prev);
	}
	
	
	public void resetPort(List<BaseShape> shapes) {
		for (BaseShape shape:shapes) {
			shape.setSelected(false);
		}
	}
}
