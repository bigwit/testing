package itmo.cs.testing.lab1.task3;

public class Eye {
	
	private static final String DEFAULT_ACTION_NAME = "SLEEP";
	
	private Action action;
	
	private Object focus;
	
	public Eye() {
		action = new Action(Options.NOTHING, DEFAULT_ACTION_NAME);
	}
	
	public void setAction(Action actn) {
		if(actn != null) {
			this.action = actn;
		}
	}
	
	public Action getAction() {
		return this.action;
	}
	
	public void setFocus(Man man) {
		// если man = null значит глаз не смотрит 
		// на человека. это норм.
		this.focus = man;
	}
	
	public Object getFocus() {
		return this.focus;
	}
	
}
