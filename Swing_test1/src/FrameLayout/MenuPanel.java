package FrameLayout;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Action.GroupShapeListener;
// import Action.MenuClickedListener;
import Action.RenameShapeListener;
import Action.UnGroupShapeListener;
import Shape.BaseShape;

public class MenuPanel extends JMenuBar {

	CanvasPanel canvasPanel;
	
	public MenuPanel(CanvasPanel canvasPanel) {
		super();
		this.canvasPanel = canvasPanel;
		initMenuBar();
	}
	
	public void initMenuBar() {
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		
		JMenuItem renameItem = new JMenuItem("Rename Object");
		JMenuItem groupItem = new JMenuItem("Group Object");
		JMenuItem unGroupItem = new JMenuItem("UnGroup Object");
		
		renameItem.addActionListener(new RenameShapeListener(canvasPanel));
		groupItem.addActionListener(new GroupShapeListener(canvasPanel));
		unGroupItem.addActionListener(new UnGroupShapeListener(canvasPanel));
		
		editMenu.add(renameItem);
		editMenu.add(groupItem);
		editMenu.add(unGroupItem);
		
		this.add(fileMenu);
		this.add(editMenu);
	}

}
