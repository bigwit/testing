package itmo.cs.testing.lab1.task3;

public class Artur extends Man {
	
	private ActionDescription actionDescription;
	
	private State state = State.SIMPLE;
	
	public void setActionDescription(Object desc) {
		if(actionDescription == null)
			actionDescription = new ActionDescription();
		actionDescription.setDescriptionForAction(desc, action);		
	}
	
	public Object getActionDescription() {
		return actionDescription.getDescription(action);
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public State getState() {
		return this.state;
	}
}
