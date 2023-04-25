package Line;

import Shape.BaseShape;
import Shape.Port;

import Button.ButtonType;

public class LineFactory {
	
	public BaseShape shape1;
	public BaseShape shape2;
	public Port start;
	public Port end;
	
	public LineFactory(BaseShape shape1, BaseShape shape2, Port start, Port end) {
		this.shape1 = shape1;
		this.shape2 = shape2;
		this.start = start;
		this.end = end;
	}
	
	public BaseLine createLine(ButtonType btn) {
		BaseLine result = null;
		switch(btn) {
		case Association:
			result = new AssociationLine(shape1, shape2, start ,end);
			break;
		
		case Generalization:
			result = new GeneralizationLine(shape1, shape2, start ,end);
			break;
		
		case Composition:
			result = new CompositionLine(shape1, shape2, start ,end);
			break;
		
		default:
			break;
	
		}
		return result;
	}
}
