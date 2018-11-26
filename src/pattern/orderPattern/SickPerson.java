package pattern.orderPattern;

public class SickPerson implements Person{

	@Override
	public void openDoor() {
		System.out.println("Open Door");
	}

	@Override
	public void closeDoor() {
		System.out.println("Close Door");
	}

	@Override
	public void doSomething() {
		System.out.println("Giving out Gas");
	}

}
