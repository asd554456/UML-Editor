package Button;

import UMLManager.ActionManager;

public class AssociationButton extends BaseButton{

	
	public AssociationButton(String iconPath) {
		super("association", iconPath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClicked() {
		// TODO Auto-generated method stub
		ActionManager.setAction("association");
	}
	

}
