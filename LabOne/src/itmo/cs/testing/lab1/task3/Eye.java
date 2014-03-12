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
	
	/**
	 * Моргает ли глаз
	 */
	public boolean isWink() {
		return Options.WINK.equals(getAction().getActionEffect());
	}
	
	/**
	 * Установить фокус на указанный объект
	 */
	public void setFocus(Object object) {
		// если man = null значит глаз не смотрит 
		// на человека. это норм.
		this.focus = object;
	}
	
	public Object getFocus() {
		return this.focus;
	}
	
}
