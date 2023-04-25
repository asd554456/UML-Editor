package Button;

import UMLManager.ActionManager;

public class CompositionButton extends BaseButton{

	public CompositionButton(String iconPath) {
		super("composition", iconPath);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onClicked() {
		// TODO Auto-generated method stub
		ActionManager.setAction("composition");
	}
}
