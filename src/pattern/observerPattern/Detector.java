package pattern.observerPattern;

import pattern.orderPattern.Person;

public class Detector implements Observer{

	@Override
	public void Observing(Person person) {
		if(person.getClass().getName().contains("Smoking")){
			System.out.println("bi bo bi bo");
		}else if(person.getClass().getName().contains("Sick")){
			System.out.println("emm.......");
		}
	}
	
}
