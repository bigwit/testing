package itmo.cs.testing.lab1.task3;

public class Man {

	private static final String DEFAULT_BIRTHPLACE = "Earth";
	
	protected Action action;
	
	protected Desire desire;
	
	protected String birthplace;

	protected Hand[] hands;
	protected Eye[] eyes;
	
	{
		hands = new Hand[2];
		hands[0] = new Hand();
		hands[1] = new Hand();
		eyes = new Eye[2];
		eyes[0] = new Eye();
		eyes[1] = new Eye();
	}

	public Man() {
		action = Action.NOTHING;
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
	
	public void setBirthplace(String bp) {
		this.birthplace = bp;
	}
	
	public String getBirthplace() {
		return this.birthplace;
	}
	
	public void putToHand(Object obj) {
		this.hands[0].put(obj);
	}
	
	public Class<?> getTypeItemInHand() {
		Object item = this.hands[0].getItem();
		return (item != null) ? item.getClass() : null;
	}
	
	public Eye[] getEyes() {
		return this.eyes;
	}

}
