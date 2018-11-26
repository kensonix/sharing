package pattern.orderPattern;

public class DoSomething implements Action{
	private final Person person;
	public DoSomething(Person person){
		this.person = person;
	}
	public void perform(){
		person.doSomething();
	}
}
