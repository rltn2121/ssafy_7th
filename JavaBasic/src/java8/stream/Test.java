package java8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {

		{
			String[] strArray = {"A", "B", "C", "D", "E"};
			
			Stream<String> stream = Arrays.stream(strArray).distinct();
			print(stream);
		}
		
		{
			Integer[] intArray = {4,3,5,1,2,7,13,25,2,9};
			
			Stream<Integer> stream = Arrays.stream(intArray)
					.filter(n -> n>2)
					.sorted((n1, n2) -> n2 - n1);
			print(stream);
		}
	}
	
	static void print(Stream<?> stream) {
		stream.forEach(a -> System.out.print(a + " "));
		System.out.println();
	}

}

