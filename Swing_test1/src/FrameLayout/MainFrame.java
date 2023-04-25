package FrameLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import UMLManager.FrameManager;

public class MainFrame extends JFrame{
	
	private int width = 1280;
	private int height = 720;
	
	private ButtonsPanel buttonsPanel;
	private CanvasPanel canvasPanel;
	private MenuPanel menuPanel;
	private JSplitPane splitPane;
	
	private JButton button;
	
	public MainFrame() {
		super();
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buttonsPanel = FrameManager.getButtonsPanel();
		canvasPanel = FrameManager.getCanvasPanel();
		menuPanel = FrameManager.getMenuPanel();
		this.setJMenuBar(menuPanel);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonsPanel, canvasPanel);
		splitPane.setResizeWeight(.15f);
		this.getContentPane().add(splitPane);
		
		this.setVisible(true);
	}
}
