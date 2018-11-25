package lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

import org.junit.Test;

public class LambdaExpr {
	
//	@Test
	public void test1(){
		String[] fruits  = { "apple","banana","orange"};
		List<String> fruitsList = Arrays.asList(fruits);
		
		// 以前的循环方式  
		for (String fruit : fruitsList) {  
		     System.out.print(fruit + "; ");  
		}  
		
		System.out.println();
		System.out.println("---------------------");
		// 使用 lambda 表达式以及函数操作  
		fruitsList.forEach((fruit) -> System.out.print(fruit + "; "));  
		   
		System.out.println();
		System.out.println("---------------------");
		// 在 Java 8 中使用双冒号操作符
		fruitsList.forEach(System.out::print);  
	}
	
	//匿名内部类 
	public  void test2(){
		//添加事件监听
		JButton btn1 = new JButton("btn1");
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn1 clicked");
			}
		});
		
		//使用 lambda 表达式
		JButton btn2 = new JButton("btn2");
		btn2.addActionListener( event -> System.out.println("btn1 clicked") );
	}
	
	//多线程
	public void test3(){
		Thread thread1 = new Thread(new Runnable(){
			public void run() {
				System.out.println("thread1 created");
			}
		});
		Thread thread2  = new Thread( () -> System.out.println("thread2 created") );
	}
	
	@Test
	public void test4(){
		 final long count = 10000000;
	        List<Long> list = new ArrayList<>();
	        for (long i = 0; i < count; i++) {
	            list.add(i);
	        }

	        //=========传统方式进行外部迭代=========
	        Instant begin = Instant.now();
	        for (Long i : list) {
	            System.out.print("");
	        }
	        System.out.println("--------------------------");
	        Instant end = Instant.now();
	        System.out.println("传统方式进行外部迭代" + count + "次,耗时(ms)：" + Duration.between(begin, end).toMillis());


	        //=========java8内部迭代，用lambda处理=========
	        begin = Instant.now();
	        list.stream().forEach(i -> System.out.print(""));
	        System.out.println("--------------------------");
	        end = Instant.now();
	        System.out.println("内部迭代forEach" + count + "次,耗时(ms)：" + Duration.between(begin, end).toMillis());

	        //=========java8进行并行流处理后迭代（备注：并行流输出是没有顺序的 比如不再是1234顺序了）=========
	        begin = Instant.now();
	        list.parallelStream().forEach(i -> System.out.print(""));
	        System.out.println("--------------------------");
	        end = Instant.now();
	        System.out.println("内部迭代parallelStream" + count + "次,耗时(ms)：" + Duration.between(begin, end).toMillis());
	    }
	
}
