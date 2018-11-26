package pattern.orderPattern;

public class OpenDoor implements Action{
	private final Person person;
	public OpenDoor(Person person){
		this.person = person;
	}
	public void perform(){
		person.openDoor();
	}
}
