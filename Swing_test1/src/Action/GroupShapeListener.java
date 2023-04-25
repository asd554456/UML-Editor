package Action;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import FrameLayout.CanvasPanel;
import FrameLayout.MainFrame;
import Line.AssociationLine;
import Line.BaseLine;
import Line.GroupBorder;
import Shape.BaseShape;
import Shape.GroupBaseShape;
import UMLManager.ActionManager;
import UMLManager.FrameManager;

public class GroupShapeListener extends MouseAdapter implements ActionListener{

	
	// group border info
	private CanvasPanel canvasPanel;
	
	// shape info
	private List<BaseShape> shapes = new ArrayList<BaseShape>();
	private BaseShape groupBaseShape;

	public GroupShapeListener(CanvasPanel canvasPanel) {
		super();
		this.canvasPanel = canvasPanel;
		//this.shapes = shapes;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("select group");
		
		List<BaseShape> groupShapes = new ArrayList<BaseShape>();
		
		// get selected shape
		for (BaseShape shape:canvasPanel.getShapes()) {
			if (shape.getSelected()) {
				shape.setSelected(false);
				groupShapes.add(shape);
			}
		}

		// check selected item count, if ==0 || ==1, return
		if(groupShapes.size() == 0) {
			JOptionPane.showMessageDialog(canvasPanel,  "No Choose Object",  "WARNING", JOptionPane.WARNING_MESSAGE);
			return;
		}
		else if(groupShapes.size() == 1) {
			JOptionPane.showMessageDialog(canvasPanel,  "Only Choose One Object",  "WARNING", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		// group name
		String G_name = JOptionPane.showInputDialog("Function Name");
		if (G_name == null)
			return;
		groupBaseShape = new GroupBaseShape(G_name);
		
		// before remove store groupShape in temp
		canvasPanel.storeShape(groupShapes);
		for (BaseShape shape:groupShapes) {
			canvasPanel.removeShpae(shape);
		}
		
		for (BaseShape shape:groupShapes) {
			groupBaseShape.addShape(shape);
		}
	
		
		ActionManager.addActionListener(groupBaseShape, new DragAndDropListener(canvasPanel));
		
		
		canvasPanel.addShape(groupBaseShape);
	}
}
