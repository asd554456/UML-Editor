package UMLManager;

import java.awt.Button;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

import javax.swing.JComponent;

import Action.DragAndDropListener;
import Action.DragAndGroupListener;
import Action.GroupShapeListener;
import Action.LineCreateListener;
import Action.ShapeCreateListener;
import Button.ButtonType;
import FrameLayout.CanvasPanel;
import Line.AssociationLine;
import Line.BaseLine;
import Line.CompositionLine;
import Line.GeneralizationLine;
import Line.LineType;
import Shape.BaseShape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;
import java.util.List;

public class ActionManager {

	public ActionManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void setAction(String btn) {
		
		CanvasPanel canvasPanel = FrameManager.getCanvasPanel();
		
		removeActionListener(canvasPanel);	// 取消註冊 (reset previous action)
		removeMultActionListener(new ArrayList<JComponent>(canvasPanel.getShapes()));
		
		switch(btn) {
		case "select":
			List<BaseShape> shapes = new ArrayList<BaseShape>(canvasPanel.getShapes());
			List<BaseLine> lines = new ArrayList<BaseLine>(canvasPanel.getLines());
			addMultActionListener(new ArrayList<JComponent>(canvasPanel.getShapes()), new DragAndDropListener(canvasPanel));	// 註冊
			addActionListener(canvasPanel, new DragAndGroupListener(canvasPanel, shapes, lines));
			break;
		case "association":
			addMultActionListener(new ArrayList<JComponent>(canvasPanel.getShapes()), new LineCreateListener(canvasPanel, ButtonType.Association));
			break;
		case "generalization":
			addMultActionListener(new ArrayList<JComponent>(canvasPanel.getShapes()), new LineCreateListener(canvasPanel, ButtonType.Generalization));
			break;
		case "composition":
			addMultActionListener(new ArrayList<JComponent>(canvasPanel.getShapes()), new LineCreateListener(canvasPanel, ButtonType.Composition));
			break;
		case "class":
			addActionListener(canvasPanel, new ShapeCreateListener(canvasPanel, ButtonType.Class));			// 左要屬於右，才能觸發mousePressed
			break;
		case "use case":
			addActionListener(canvasPanel, new ShapeCreateListener(canvasPanel, ButtonType.UseCase));
			break;
			
		default:
			System.out.println("no event");
			break;
		}
	}
	

	
	public static void addActionListener(JComponent j, MouseAdapter m) {
		j.addMouseListener(m);
		j.addMouseMotionListener(m);
		j.addMouseWheelListener(m);
	}
	
	public static void addMultActionListener(List<JComponent> j, MouseAdapter m) {
		for (JComponent k:j) {
			addActionListener(k, m);
		}
		
	}
	
	public static void removeActionListener(JComponent j) {
		List<EventListener> mouseListener = new ArrayList<EventListener>();
		mouseListener.addAll(Arrays.asList(j.getMouseListeners()));
		mouseListener.addAll(Arrays.asList(j.getMouseMotionListeners()));
		mouseListener.addAll(Arrays.asList(j.getMouseWheelListeners()));
		
		for(EventListener m:mouseListener) {
			j.removeMouseListener((MouseListener)m);
			j.removeMouseMotionListener((MouseMotionListener)m);
			j.removeMouseWheelListener((MouseWheelListener)m);
		}
	}
	
	public static void removeMultActionListener(List<JComponent> j) {
		for (JComponent k:j) {
			removeActionListener(k);
		}
	}
}
