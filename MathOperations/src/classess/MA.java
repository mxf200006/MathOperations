package classess;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * MA - May Algorithms
 * 
 * @author 87fah 01/05/2020
 */
public class MA {
	final static String HEX_REGEX ="^[0-9A-Fa-f]+$";
	final static String HEX = "0123456789ABCDEF";
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

	// non-recursive implementation
	public static int gcd(int p, int q) {
		String temp = MA.gcdEuclideanAlgirthm(Integer.toString(p), Integer.toString(q));
		return Integer.parseInt(temp);
	}

	/*
	 * Convert a hex value to decimal. The hex value can be as large it is possible.
	 */
	public static String hexToDecimal(String hex) {
		if(!hex.matches(HEX_REGEX))
			throw new IllegalArgumentException("Input is not hex number.");
		
		hex = hex.toUpperCase();
		BigInteger result = BigInteger.ZERO;
		
		for (int i = 0; i < hex.length(); i++) {
			int multiplier = HEX.indexOf(hex.charAt(i));
			BigInteger base = BigInteger.valueOf(16);
			base = base.pow(hex.length() - (i + 1));
			base = base.multiply(BigInteger.valueOf(multiplier));
			result = result.add(base);
		}
		return result.toString();
	}

	public static long hexToDecimal(long hex) {
		return Long.parseLong(MA.hexToDecimal(String.valueOf(hex)));
	}

	public static int hexToDecimal(int hex) {
		return Integer.parseInt(MA.hexToDecimal(String.valueOf(hex)));
	}

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

	public static double nChooseR(long n, long r) {
		return MA.factorial(n) / (MA.factorial(r) * MA.factorial(n - r));
	}

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
