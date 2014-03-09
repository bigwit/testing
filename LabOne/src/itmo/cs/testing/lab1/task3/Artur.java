package itmo.cs.testing.lab1.task3;

public class Artur extends Man {
	
	ActionDescription actionDescription;
	
	public void setActionDescription(Object desc) {
		if(actionDescription == null)
			actionDescription = new ActionDescription();
		actionDescription.setDescriptionForAction(desc, action);		
	}
	
	public Object getActionDescription() {
		return actionDescription.getDescription(action);
	}
	
}
