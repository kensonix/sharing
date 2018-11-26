package pattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

import pattern.orderPattern.Person;

public class Toilet {
	private final List<Observer> observers = new ArrayList<>();
	public Person person;
	public Toilet(Person person){
		this.person = person;
	}
	public void detecting(){
		observers.forEach(observer -> observer.Observing(person));
	}
	
	public void StartDecting(Observer observer){
		observers.add(observer);
	}
}
