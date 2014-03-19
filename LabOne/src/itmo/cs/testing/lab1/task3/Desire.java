package itmo.cs.testing.lab1.task3;

import java.util.ArrayList;

public class Desire {
	
	private ArrayList<Options> options = new ArrayList<>();
	private ArrayList<Action> actions = new ArrayList<>();
	private Place place;
	
	public Desire() {
		place = new Place();
	}
	
	public void setOptions(Options ...options) {
		for(Options opt : options) {
			if(opt == null)
				continue;
			this.options.add(opt);
		}
	}
	
	public void setActions(Action ...actions) {
		for(Action opt : actions) {
			if(opt == null)
				continue;
			this.actions.add(opt);
		}
	}
	
	public void setPlace(Place place) {
		this.place = place;
	}
	
	@Override
	public boolean equals(Object other) {
		Desire notThis = (Desire)other;
		return notThis.actions.size() == this.actions.size() &&
				notThis.options.size() == this.options.size() &&
				notThis.place.equals(this.place);
	}
	
}
