package itmo.cs.testing.lab1.task3;

public class Action {
	
	private static final String DEFAULT_ACTION = "SLEEP";
	private static final Options DEFAULT_ACTION_EFFECT = Options.SIMPLE;
	
	private Options actionEffect;
	private String action;
	
	public Action() {
		actionEffect = DEFAULT_ACTION_EFFECT;
		this.action = DEFAULT_ACTION;
	}
	
	public Action(Options actionEff, String actionName) {
		this.actionEffect = actionEff == null ? DEFAULT_ACTION_EFFECT : actionEff;
		this.action = actionName == null ? DEFAULT_ACTION : actionName;
	}
	
	public String getAction() {
		return this.action;
	}
	
	public Options getActionEffect() {
		return this.actionEffect;
	}
	
}
