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
	
	@Test
	public void test4(){
		 final long count = 10000000;
	        List<Long> list = new ArrayList<>();
	        for (long i = 0; i < count; i++) {
	            list.add(i);
	        }

	        //=========��ͳ��ʽ�����ⲿ����=========
	        Instant begin = Instant.now();
	        for (Long i : list) {
	            System.out.print("");
	        }
	        System.out.println("--------------------------");
	        Instant end = Instant.now();
	        System.out.println("��ͳ��ʽ�����ⲿ����" + count + "��,��ʱ(ms)��" + Duration.between(begin, end).toMillis());


	        //=========java8�ڲ���������lambda����=========
	        begin = Instant.now();
	        list.stream().forEach(i -> System.out.print(""));
	        System.out.println("--------------------------");
	        end = Instant.now();
	        System.out.println("�ڲ�����forEach" + count + "��,��ʱ(ms)��" + Duration.between(begin, end).toMillis());

	        //=========java8���в�����������������ע�������������û��˳��� ���粻����1234˳���ˣ�=========
	        begin = Instant.now();
	        list.parallelStream().forEach(i -> System.out.print(""));
	        System.out.println("--------------------------");
	        end = Instant.now();
	        System.out.println("�ڲ�����parallelStream" + count + "��,��ʱ(ms)��" + Duration.between(begin, end).toMillis());
	    }
	
}
