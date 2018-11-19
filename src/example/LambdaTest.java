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
		JFrame frame = new JFrame("����");
		JButton btn = new JButton("���");
		
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
			  
			// ��ǰ��ѭ����ʽ  
			for (String fruit : fruitList) {  
			     System.out.println(fruit + "; ");  
			}  
			  
			// ʹ�� lambda ���ʽ�Լ���������
			fruitList.forEach((fruit) -> System.out.println(fruit + "; "));  
			   
			// �� Java 8 ��ʹ��˫ð�Ų����� 
			fruitList.forEach(System.out::println);
	}
	
	
}
