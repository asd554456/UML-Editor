package Button;

import UMLManager.ActionManager;
import UMLManager.FrameManager;

public class SelectButton extends BaseButton{

	public SelectButton(String iconPath) {
		super("select", iconPath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClicked() {
		// TODO Auto-generated method stub
		ActionManager.setAction("select");
		
	}
}
