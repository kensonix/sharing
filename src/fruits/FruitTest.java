package fruits;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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
	
//		@Test
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
		
//		@Test
		public void testMap(){
			List<Fruit> appleList = fruitList.get(0).subFruits;
			Set<String> appleSet = appleList.stream()
					.map(apple ->  {String name = apple.name;return name;})
					.collect(Collectors.toSet());
			
			appleSet.forEach(System.out::println);
		}
		
//		@Test
		public  void testMax(){
			List<Fruit> appleList = fruitList.get(0).subFruits;
			Fruit fruit = appleList.stream()
					.max(Comparator.comparing(apple ->  ((Fruit)apple).getPrice()))
					.get();
			
			System.out.println( fruit.toString() +"'s price is " + fruit.getPrice());
			
			double avgPrice = appleList.stream().collect(Collectors.averagingInt(apple -> ((Fruit)apple).getPrice() ));
			System.out.println(avgPrice);
		}
		
//		@Test
		public void testCollectors(){
			List<Fruit> appleList = fruitList.get(0).subFruits;
			
			Optional<Fruit> fruit1 =  (Optional<Fruit>) appleList.stream()
					.collect(Collectors.maxBy( Comparator.comparing(apple ->( (Fruit)apple).getPrice() )));
			System.out.println(fruit1.map(Fruit::getName));
			
			double avgPrice = appleList.stream().collect(Collectors.averagingInt(apple -> ((Fruit)apple).getPrice() ));
			System.out.println(avgPrice);
		}
		
//		@Test
		public void testPartion(){
			//这里的Boolean 是装箱类型，因为stream流处理后得到的是装箱类型的key
			Map<Boolean,List<Fruit>> fruitMap = fruitList.stream()
					.flatMap(fruit -> fruit.subFruits.stream())
					.collect(Collectors.partitioningBy(Fruit::isGreen));
			List<Fruit> greenFruit = fruitMap.get(true);
			greenFruit.forEach(fruit -> System.out.print( fruit.getName() +"、"));
			System.out.println("/r/n-----------------");
			List<Fruit> notGreenFruit = fruitMap.get(false);
			notGreenFruit.forEach(fruit -> System.out.print(" " + fruit.getName()));
		}
		
		@Test
		public void testGroup(){
			Map<Integer,List<Fruit>> fruitMap = fruitList.stream()
					.flatMap(fruit -> fruit.subFruits.stream())
					.collect(Collectors.groupingBy(Fruit::getPrice));
			List<Fruit> fruitList = fruitMap.get(10);
			fruitList.forEach( f -> System.out.println(f));
		}
		
}
