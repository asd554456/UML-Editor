package UMLManager;

import java.awt.MenuBar;

import FrameLayout.*;

public class FrameManager {
	
	public static MainFrame mainFrame = null;
	
	public static ButtonsPanel buttonsPanel = null;
	
	public static CanvasPanel canvasPanel = null;
	
	public static MenuPanel menuPanel = null;
	
	public FrameManager() {}
	
	// Singleton Pattern
	public static MainFrame getMainFrame() {
		if (mainFrame == null) {
			mainFrame = new MainFrame();
		}
		return mainFrame;
	}
	
	public static ButtonsPanel getButtonsPanel() {
		if (buttonsPanel == null) {
			buttonsPanel = new ButtonsPanel();
		}
		return buttonsPanel;
	}
	
	public static CanvasPanel getCanvasPanel() {
		if (canvasPanel == null) {
			canvasPanel = new CanvasPanel();
		}
		return canvasPanel;
	}
	
	public static MenuPanel getMenuPanel() {
		if (menuPanel == null) {
			menuPanel = new MenuPanel(getCanvasPanel());
		}
		return menuPanel;
	}
}
