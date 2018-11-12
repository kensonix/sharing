package fruits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class FruitTest {
	public List<Fruit> fruitList = new ArrayList<Fruit>();
	//静态代码块做初始化？
		{
			Apple apple = new Apple("Apple",0,false);
			apple.subFruits.add(new Apple("little Apple",10,false));
			apple.subFruits.add(new Apple("small Apple",20,true));
			apple.subFruits.add(new Apple("big Apple",30,true));
			
			Banana banana = new Banana("Banana",0,false);
			banana.subFruits.add(new Apple("little banana",10,false));
			banana.subFruits.add(new Apple("small banana",20,true));
			banana.subFruits.add(new Apple("big banana",30,true));
			
			fruitList.add(apple);
			fruitList.add(banana);
		}
	
		@Test
	public void testFilter(){
		List<Fruit> greenList = fruitList.stream()
				.flatMap(subFruit -> subFruit.subFruits.stream())
				.filter(fruit -> fruit.isGreen())
				//自动类型推断
//				.filter(Fruit::isGreen)
				.collect(Collectors.toList());
		for(Fruit fruit : greenList){
			System.out.println(fruit);
		}
				
						
	}
}
