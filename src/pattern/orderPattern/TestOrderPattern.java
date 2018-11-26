package pattern.orderPattern;

public class TestOrderPattern {
	public static void main(String[] args) {
		Person sickPerson = new SickPerson();
		Person smokingPerson = new SmokingPerson();
		Camera camera = new Camera();
//		camera.record(sickPerson::openDoor);
//		camera.record(sickPerson::closeDoor);
//		camera.record(sickPerson::doSomething);
		
		camera.record(smokingPerson::openDoor);
		camera.record(smokingPerson::closeDoor);
		camera.record(smokingPerson::doSomething);
		
		camera.reCur();
	}
}
