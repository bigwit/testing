package itmo.cs.testing.lab1.task3;

public class Man {

	private static final String DEFAULT_BIRTHPLACE = "Earth";
	
	protected Action action;
	
	protected Desire desire;
	
	protected String birthplace;

	protected Hand[] hands = new Hand[2];
	protected Eye[] eyes = new Eye[2];

	public Man() {
		action = new Action();
		birthplace = DEFAULT_BIRTHPLACE;
	}

	public Action getAction() {
		return this.action;
	}

	public void setAction(Action newAction) {
		if(newAction != null)
			this.action = newAction;
	}

	public void setEyesAction(Action eyesAction) {
		if(eyesAction != null) {
			for(Eye eye : this.eyes) {
				eye.setAction(eyesAction);
			}
		}
	}

	public void setFocus(Man man) {
		for(Eye eye : this.eyes) {
			eye.setFocus(man);
		}
	}
	
	public void setDesire(Desire dsr) {
		this.desire = dsr;
	}
	
	public Desire getDesire() {
		return this.desire;
	}
	
	public Man setBirthplace(String bp) {
		this.birthplace = bp;
		return this;
	}
	
	public String getBirthplace() {
		return this.birthplace;
	}
	
	public void putToHand(Object obj) {
		this.hands[0].put(obj, obj.getClass());
	}
	
	public Class<?> getTypeItemInHand() {
		return this.hands[0].getClass();
	}
	
	public Eye[] getEyes() {
		return this.eyes;
	}

}
