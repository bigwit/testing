package itmo.cs.testing.lab1.task3;

public class Man {

	protected Action action;
	
	protected Desire desire;

	protected Hand[] hands = new Hand[2];
	protected Eye[] eyes = new Eye[2];

	public Man() {
		action = new Action();
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

}
