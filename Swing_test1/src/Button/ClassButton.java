package Button;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

import UMLManager.ActionManager;
import UMLManager.FrameManager;

public class ClassButton extends BaseButton {

	public ClassButton(String iconPath) {
		super("class", iconPath);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onClicked() {
		// TODO Auto-generated method stub
		ActionManager.setAction("class");
	}
}
