package lambda;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TestParrel {
	public static void main(String[] args) {
		 final long count = 10000000;
		 ArrayList list = new ArrayList();
		 ArrayList newList = new ArrayList();
	        //=========��ͳ��ʽ�����ⲿ����=========
	        Instant begin = Instant.now();
	        Instant end = Instant.now();
	        for (long i = 0; i < count; i++) {
	           list.add(i);
	        }
	        System.out.println("--------------------------");
	         end = Instant.now();
	        System.out.println("��ͳ��ʽ�����ⲿ����" + count + "��,��ʱ(ms)��" + Duration.between(begin, end).toMillis());
	        //=========java8�ڲ���������lambda����=========
	        begin = Instant.now();
	       list.forEach(obj -> newList.add(obj));
	        System.out.println("--------------------------");
	        end = Instant.now();
	        System.out.println("�ڲ�����forEach" + count + "��,��ʱ(ms)��" + Duration.between(begin, end).toMillis());
	        //=========java8���в�����������������ע�������������û��˳��� ���粻����1234˳���ˣ�=========
	        begin = Instant.now();
	        list.parallelStream().map(obj -> newList.add(obj));
	        System.out.println("--------------------------");
	        end = Instant.now();
	        System.out.println("�ڲ�����parallelStream" + count + "��,��ʱ(ms)��" + Duration.between(begin, end).toMillis());
	        
	}
}