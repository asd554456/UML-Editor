package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import FrameLayout.CanvasPanel;
import Shape.BaseShape;

public class RenameShapeListener implements ActionListener{

	private CanvasPanel canvasPanel;
	
	public RenameShapeListener(CanvasPanel canvasPanel) {
		super();
		// TODO Auto-generated constructor stub
		this.canvasPanel = canvasPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("select rename");

		String name = JOptionPane.showInputDialog("Enter Name");
		
		// if cancel, then class name still not change
		if(name == null)
			return;
		
		// find select name and rename them
		for(BaseShape shape : canvasPanel.getShapes())
			if(shape.getSelected())
				shape.setName(name);
		
		// repaint draw panel
		canvasPanel.repaint();
	}

}
