package pattern.observerPattern;

import org.junit.Test;

import pattern.orderPattern.Person;
import pattern.orderPattern.SickPerson;
import pattern.orderPattern.SmokingPerson;

public class ObserveTest {
	
	@Test
	public void test(){
		normal(new Toilet(new SickPerson()));
		anonymous(new Toilet(new SmokingPerson()));
		lambda(new Toilet(new SmokingPerson()));
	}
	
	public void normal(Toilet toilet){
		Detector detector = new Detector();
		toilet.StartDecting(detector);
		toilet.detecting();
	}
	
	public void anonymous(Toilet toilet){
		
		toilet.StartDecting(new Observer(){
			public void Observing(Person person) {
				if(person.getClass().getName().contains("Smoking")){
					System.out.println("bi bo bi bo111");
				}else if(person.getClass().getName().contains("Sick")){
					System.out.println("emm.......111");
				}}
		});
		toilet.detecting();
	}
	
		public void lambda(Toilet toilet){
			
				toilet.StartDecting(person ->{
				if(person.getClass().getName().contains("Smoking")){
					System.out.println("bi bo bi bo...222");
					}
				});
				
				toilet.StartDecting(person ->{
					if(person.getClass().getName().contains("Sick")){
						System.out.println("emm.....222");
						}
					});
				
				toilet.detecting();
		}
	
}
