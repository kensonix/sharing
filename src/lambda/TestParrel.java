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
	        //=========传统方式进行外部迭代=========
	        Instant begin = Instant.now();
	        Instant end = Instant.now();
	        for (long i = 0; i < count; i++) {
	           list.add(i);
	        }
	        System.out.println("--------------------------");
	         end = Instant.now();
	        System.out.println("传统方式进行外部迭代" + count + "次,耗时(ms)：" + Duration.between(begin, end).toMillis());
	        //=========java8内部迭代，用lambda处理=========
	        begin = Instant.now();
	       list.forEach(obj -> newList.add(obj));
	        System.out.println("--------------------------");
	        end = Instant.now();
	        System.out.println("内部迭代forEach" + count + "次,耗时(ms)：" + Duration.between(begin, end).toMillis());
	        //=========java8进行并行流处理后迭代（备注：并行流输出是没有顺序的 比如不再是1234顺序了）=========
	        begin = Instant.now();
	        list.parallelStream().map(obj -> newList.add(obj));
	        System.out.println("--------------------------");
	        end = Instant.now();
	        System.out.println("内部迭代parallelStream" + count + "次,耗时(ms)：" + Duration.between(begin, end).toMillis());
	        
	}
}