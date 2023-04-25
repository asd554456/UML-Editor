package Button;

import UMLManager.ActionManager;

public class GeneralizationButton extends BaseButton{

	public GeneralizationButton(String iconPath) {
		super("generalization", iconPath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClicked() {
		// TODO Auto-generated method stub
		ActionManager.setAction("generalization");
	}
}
