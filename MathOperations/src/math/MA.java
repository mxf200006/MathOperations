package math;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * MA - May Algorithms
 * 
 * @author 87fah 01/05/2020
 */
public class MA {

	/**
	 * This method calcuate the gcd of two huge numbers using Euclidian Algorithm
	 * @param num1 number one
	 * @param num2 number two
	 * @return command denominator of number one and number two
	 */
	public static String gcdEuclideanAlgirthm(String num1, String num2) {
		BigInteger p = new BigInteger(num1);
		BigInteger q = new BigInteger(num2);

		while (!q.equals(BigInteger.ZERO)) {
			BigInteger temp = q;
			q = p.mod(q);
			p = temp;
		}

		return p.toString();
	}

	/**
	 * This method calcuate the gcd of two huge numbers using Euclidian Algorithm
	 * @param p number one
	 * @param q number two
	 * @return command denominator of number one and number two
	 */	public static int gcd(int p, int q) {
		String temp = MA.gcdEuclideanAlgirthm(Integer.toString(p), Integer.toString(q));
		return Integer.parseInt(temp);
	}

	/**
	 * Converts a hexadecimal number to decimal number
	 * @param hex hexadecimal number
	 * @return decimal number equavalnet to the input
	 */
	public static String hexToDecimal(String hex) {
		hex = hex.toUpperCase();
		BigInteger result = BigInteger.ZERO;
		String temp = "0123456789ABCDEF";
		for (int i = 0; i < hex.length(); i++) {
			int multiplier = temp.indexOf(hex.charAt(i));
			BigInteger base = BigInteger.valueOf(16);
			base = base.pow(hex.length() - (i + 1));
			base = base.multiply(BigInteger.valueOf(multiplier));
			result = result.add(base);
		}
		return result.toString();
	}

	/**
	 * Converts a hexadecimal number to decimal number
	 * @param hex hexadecimal number
	 * @return decimal number equavalnet to the input
	 */
	public static long hexToDecimal(long hex) {
		return Long.parseLong(MA.hexToDecimal(String.valueOf(hex)));
	}

	/**
	 * Converts a hexadecimal number to decimal number
	 * @param hex hexadecimal number
	 * @return decimal number equavalnet to the input
	 */
	public static int hexToDecimal(int hex) {
		return Integer.parseInt(MA.hexToDecimal(String.valueOf(hex)));
	}

	/**
	 * Convert a decimal number to faction
	 * @param d is decimal number
	 * @return fraction approximaitely equal to input
	 */
	public static String decimalToFraction(double d) {

		if (d % 1 == 0)
			return Double.toString(d);

		String num = Double.toString(d);
		// System.out.println("Double" + num);
		if (num.contains("e") || num.contains("E"))
			throw new RuntimeException("Scientific notation not supported.");

		String b = num.substring(0, num.indexOf("."));
		String a = num.substring(num.indexOf(".") + 1, num.length());

		num = b + a;

		long base = (long) Math.pow(10, a.length());
		String gcd = MA.gcdEuclideanAlgirthm(num, Long.toString(base));

		// System.out.printf("b: %s\na : %s\nnum: %s\ngcd: %s\n", b, a, num, base);

		return new BigInteger(num).divide(new BigInteger(gcd)) + "/"
				+ new BigInteger(Long.toString(base)).divide(new BigInteger(gcd));
	}

	/**
	 * Calculate the value of n chooses r. This method use the regular formula n! / (r! * (n-r)!)
	 * @param n	n!
	 * @param r r!
	 * @return n chooses r 
	 */
	public static double nChooseR(long n, long r) {
		return MA.factorial(n) / (MA.factorial(r) * MA.factorial(n - r));
	}

	/**
	 * Calculate n factorial using naivise (recursive) algorithm
	 * @param num number whose factorial is need
	 * @return value of n factorial
	 */
	public static double factorial(double num) {
		if (num == 0)
			return 1;
		return num * MA.factorial(num - 1);
	}

	
	private static int counter = 2;

	public static Map<Integer, Integer> primeFactors(int num) {
		Map<Integer, Integer> fac = new HashMap<>();

		while (counter <= num) {
			if (num % counter == 0) {
				fac.computeIfPresent(counter, (k, v) -> fac.get(counter) + 1);
				fac.putIfAbsent(counter, 1);
				num = num / counter;
			} else {
				counter++;
			}
		}
		return fac;
	}
	
	/**
	 * This method calculate n-th Fibonacci number using naive recursive method. The complexity time of this method is exponential. 
	 * @param n n-th Fibonacci number
	 * @return the value of n-th Fibonacci number
	 */
	public static long fibNaiveAlgorithm(long n) {
		
		//Based case
		if(n <=1)
			return n;
		
		return  fibNaiveAlgorithm(n-1) + fibNaiveAlgorithm(n-2);

	}
	
	/**
	 * This method calculate n-th Fibonacci number using iterative algorithm. The running time for this algorithm is O(n)
	 * This method requires less memory the fibMemoizedAlgorithm.
	 * @param n n-th Fibonacci number
	 * @return the value of n-th Fibonacci number
	 */
	public static long fibIterativeAlgorithm(long n) {
		//This is the base case, the first fibonacci number is 0,  
		if(n < 1)
			return 0;
		
		long prevNext = 0;
		long next = 1;
		long result = next; 
		for(int i  = 1; i < n; i++) {
			result = next + prevNext;
			prevNext = next;
			next = result;
		}
		return result;
	}
	
	/**
	 * The dictionary is used to store the calculated value of n-th Fibonacci number in the first call during the memoizedFib method execution.
	 * These value will be used in second recursive called and reduces the time to O(1)
	 */
	private static Map<Long, Long> fibMap = new HashMap<Long, Long>();
	/**
	 * This method calculate n-th Fibonacci number using recursive method. It uses a dictionary to store the value of first recursive
	 * calls and use them in second recursive calls. This way the method reduce the exponential time of recursive - O(n^p) to linear time - O(n). 
	 * @param n n-th Fibonacci number
	 * @return the value of n-th Fibonacci number
	 */
	public static long fibMmemoizedAlgorithm(long n) {
		//Check if n Fibonacci number is already calculated 
		if(fibMap.get(n) != null) 
			return fibMap.get(n);
		
		//Based case
		if(n <=1)
			return n;
		
		//Calculated n-th Fibonacci number 
		long result = fibMmemoizedAlgorithm(n-1) + fibMmemoizedAlgorithm(n-2);
		
		//add the n-the Fibonacci number to the dictionary
		fibMap.put((long)n, result);
		return result;
	}
	
	

	public double slope(double x1, double y1, double x2, double y2) {
		double dx = x2 - x1;
		double dy = y2 - y1;
		return dy / dx;
	}

	public double lineDistance(double x1, double y1, double x2, double y2) {
		double dx = x2 - x1;
		double dy = y2 - y1;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public static int binarySearch(int[] array, int key, int low, int high) {

		int count = 0;
		int mid = (low + high) / 2;
		while (key != array[mid] && high != low) {
			count++;
			System.out.println("Loop: " + count);
			if (key < array[mid])
				high = mid - 1;
			else
				low = mid + 1;
			mid = (high + low) / 2;
		}

		return mid;
	}
}
