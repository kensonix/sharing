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
		
		// ��ǰ��ѭ����ʽ  
		for (String fruit : fruitsList) {  
		     System.out.print(fruit + "; ");  
		}  
		
		System.out.println();
		System.out.println("---------------------");
		// ʹ�� lambda ���ʽ�Լ���������  
		fruitsList.forEach((fruit) -> System.out.print(fruit + "; "));  
		   
		System.out.println();
		System.out.println("---------------------");
		// �� Java 8 ��ʹ��˫ð�Ų�����
		fruitsList.forEach(System.out::print);  
	}
	
	//�����ڲ��� 
	public  void test2(){
		//����¼�����
		JButton btn1 = new JButton("btn1");
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn1 clicked");
			}
		});
		
		//ʹ�� lambda ���ʽ
		JButton btn2 = new JButton("btn2");
		btn2.addActionListener( event -> System.out.println("btn1 clicked") );
	}
	
	//���߳�
	public void test3(){
		Thread thread1 = new Thread(new Runnable(){
			public void run() {
				System.out.println("thread1 created");
			}
		});
		Thread thread2  = new Thread( () -> System.out.println("thread2 created") );
	}
	
}