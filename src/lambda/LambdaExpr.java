package lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

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
	
}