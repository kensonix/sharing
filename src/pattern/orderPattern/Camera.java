package pattern.orderPattern;

import java.util.ArrayList;
import java.util.List;

public class Camera {
	private List<Action> actions;
	
	public Camera(){
		actions = new ArrayList<>();
	}
	
	public void record(Action action){
		actions.add(action);
	}
	
	public void reCur(){
		actions.forEach(Action::perform);
	}
}
