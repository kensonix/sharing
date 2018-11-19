package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class MinAndMax {
	
	public void test(){
		List<String> strList = Arrays.asList("hello","ppt","just a test");
		String minStr = strList.stream()
				.min(Comparator.comparing(str ->str.length()))
				.get();
		String maxStr = strList.stream()
				.max(Comparator.comparing(str -> str.length()))
				.get();
		System.out.println(minStr + "------"+ maxStr);
 	}
	//reduce 操作可以实现从一组值中生成一个值
	@Test
	public void test2(){
		int sum = Arrays.asList(1,2,3,4,5,6,7,8)
				.stream()
				.reduce(1, (acc,ele) -> acc +ele);
		System.out.println(sum);
	}
}
