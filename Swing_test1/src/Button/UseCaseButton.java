package Button;

import UMLManager.ActionManager;
import UMLManager.FrameManager;

public class UseCaseButton extends BaseButton{

	public UseCaseButton(String iconPath) {
		super("use case", iconPath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClicked() {
		// TODO Auto-generated method stub
		ActionManager.setAction("use case");
	}
}
