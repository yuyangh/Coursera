package Chap8_MultiThread.parallelStream;
import java.util.*;
class UseParallelStream 
{
	public static void main(String[] args) 
	{
		List<Integer> a = Arrays.asList(1,2,5,7,3);
		System.out.println(
		a.parallelStream()
			// parallel stream is to compute parallel
			.mapToInt(i->(int)i)
			.filter( i -> i>2 )
			.map( i -> i*i )
			.sorted()
			.distinct()
			.limit(2)// only use the first 2 num
			.max()
		);
	}
}

