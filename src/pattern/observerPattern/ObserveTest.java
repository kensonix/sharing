package pattern.observerPattern;

import pattern.orderPattern.SickPerson;

public class ObserveTest {
	public static void main(String[] args) {
		Toilet toilet = new Toilet(new SickPerson());
		Detector detector = new Detector();
		toilet.StartDecting(detector);
//		detector.Observing(person);
	}
}
