package itmo.cs.testing.lab1.task3;

public class ActionDescription {
	
	Object description;
	Action action;
	
	public void setDescriptionForAction(Object desc, Action act) {
		if(act != null) {
			this.description = desc;
			this.action = act;
		}
	}
	
	public Object getDescription(Action act) {
		if(act != null && act.equals(action)) {
			return this.description;
		}
		return null;
	}
	
}
