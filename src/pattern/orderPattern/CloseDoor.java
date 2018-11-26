package pattern.orderPattern;

public class CloseDoor implements Action{
	private final Person person;
	public CloseDoor(Person person){
		this.person = person;
	}
	
	public void perform(){
		person.closeDoor();
	}
}
