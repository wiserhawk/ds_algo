package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaSteamExample {
	
	/**
	 * Find sum of all positive even unique number using Java 8 steam.
	 */
	public void filterPositiveEvenUniqueNumberSum(List<Integer> numberCollection) {
		
		if (numberCollection == null || numberCollection.size() == 0) {
			throw new RuntimeException("Number collection is either empty or null.");
		}
		
		/*Set<Integer> filterCollection = numberCollection.stream().filter(i -> (i > 0 && i % 2 == 0)).collect(Collectors.toSet());
		int sum = filterCollection.stream().mapToInt(i -> i).sum();*/
		
		
		
		
		Long s = System.currentTimeMillis();
		Set<Integer> set = new HashSet<>();
		for (int i : numberCollection) {
			if (i > 0 && i % 2 == 0) {
				set.add(i);
			}
		}
		
		int total = 0;
		for (int i : set) {
			total += i;
		}
		Long e = System.currentTimeMillis();
			
		System.out.println("Total = " + total);
		System.out.println("Time Taken in standard: " + (e - s));
		
		
		Long start = System.currentTimeMillis();
		int sum  = numberCollection.stream().filter(i -> (i > 0 && i % 2 == 0)).distinct().mapToInt(i -> i).sum();
		Long end = System.currentTimeMillis();
		System.out.println("Sum = " + sum);
		System.out.println("Time Taken in steam: " + (end - start));
	}
	
	
	
	
	/*public void aggregateObjects() {
		Position p1 = new Position(200, 100);
		Position p2 = new Position(150, 300);
		
		List<Position> positions = new ArrayList<JavaSteamExample.Position>();
		positions.add(p1);
		positions.add(p2);
		
		
		// Logic
		positions.stream().collect(Collectors.)
		
		
		
	}*/
	
	public class Position {
		
		int price;
		
		int accrud;

		public Position(int price, int accrud) {
			super();
			this.price = price;
			this.accrud = accrud;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public int getAccrud() {
			return accrud;
		}

		public void setAccrud(int accrud) {
			this.accrud = accrud;
		}
		
		
		
	}
	
		
	
	
	public static void main(String[] args) {
		JavaSteamExample streamExample = new JavaSteamExample();
		
		// Find sum of all positive even unique number using Java 8 steam.
		List<Integer> numberCollection = Arrays.asList(-2, 1, 3, 4, 3, 3, 4, 2, 5,-9);
		streamExample.filterPositiveEvenUniqueNumberSum(numberCollection);
		
		
	}

}
