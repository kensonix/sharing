package example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.Test;

public class LambdaTest {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("测试");
		JButton btn = new JButton("点击");
		
//		btn.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent event){
//				System.out.println("btn click");
//			}
//		});
		
		btn.addActionListener((event) -> System.out.println("btn click"));
		frame.add(btn);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
	
	@Test
	public void test1(){
		String[] fruits = {"apple","banana","watermelon","peach"};  
			List<String> fruitList =  Arrays.asList(fruits);  
			  
			// 以前的循环方式  
			for (String fruit : fruitList) {  
			     System.out.println(fruit + "; ");  
			}  
			  
			// 使用 lambda 表达式以及函数操作
			fruitList.forEach((fruit) -> System.out.println(fruit + "; "));  
			   
			// 在 Java 8 中使用双冒号操作符 
			fruitList.forEach(System.out::println);
	}
	
	
}
