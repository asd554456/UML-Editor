package FrameLayout;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import Button.*;

public class ButtonsPanel extends JPanel{
	
	private BaseButton currentButton = null;
	private List<BaseButton> buttons;
	
	public ButtonsPanel() {
		super();
		initButton();
		this.setLayout(new GridLayout(buttons.size(), 1));
		for(BaseButton button : buttons) {
			this.add(button);
		}
	}
	
	
	public void initButton() {
		buttons = new LinkedList<BaseButton>();
		
		buttons.add(new SelectButton("src/select-removebg.png"));
		buttons.add(new AssociationButton("src/associationLine-removebg.png"));
		buttons.add(new GeneralizationButton("src/generalizationLine-removebg.png"));
		buttons.add(new CompositionButton("src/compositionLine-removebg.png"));
		buttons.add(new ClassButton("src/class-removebg.png"));
		buttons.add(new UseCaseButton("src/use_case-removebg.png"));
	}
	
	public BaseButton getCurrentButton() {
		return currentButton;
	}
	
	public void setCurrentButton(BaseButton btn) {
		currentButton = btn;
	}
}
