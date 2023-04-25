package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import FrameLayout.CanvasPanel;
import Shape.BaseShape;

public class UnGroupShapeListener implements ActionListener{

	
	private CanvasPanel canvasPanel;
	private List<BaseShape> removeGroupShape;
	
	public UnGroupShapeListener(CanvasPanel canvasPanel) {
		super();
		// TODO Auto-generated constructor stub
		this.canvasPanel = canvasPanel;
		removeGroupShape = new ArrayList<BaseShape>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("select ungroup");
		
	
		for(BaseShape shape : canvasPanel.getShapes()) {
			if(shape.getShapeCount() > 0 && shape.getSelected()) {
				removeGroupShape.add(shape);
			}
				
		}
			
				
			
		if(removeGroupShape.size() == 0) {
			JOptionPane.showMessageDialog(canvasPanel,  "No Choose Group",  "WARNING", JOptionPane.WARNING_MESSAGE);

		}
				

		for(BaseShape shape : removeGroupShape) {
			canvasPanel.removeShpae(shape);
		}
			
		
		for (BaseShape shape:canvasPanel.getStoreShapes()) {
			canvasPanel.addShape(shape);
		}
				
		removeGroupShape.clear();
	}

}
