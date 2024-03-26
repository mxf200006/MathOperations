package classess;


import java.util.Map;

public class Test1 {

	public static int[] gcd(int p, int q) {
		//System.out.println(p +" " + q);
		if (q == 0) {
			int[] array = new int[] { p, 1, 0 };
			return array;
		}

		int[] vals = gcd(q, p % q);
		//System.out.printf("vals[0]: %d vals[2]: %d vals[1]: %d\n", vals[0], vals[2], vals[1]);
		int d = vals[0];
		int a = vals[2];
		int b = vals[1] - (p / q) * vals[2];
		//System.out.printf("d: %d a: %d b: %d\n", d, a, b);
		return new int[] { d, a, b };
	}

	public static int inverse(int k, int n) {
		
		int[] vals = gcd(k, n);

		int d = vals[0];
		int a = vals[1];
		if (d > 1) {
			//System.out.println("Inverse does not exist.");
			return 0;
		}
		if (a > 0)
			return a;
		return n + a;
	}
	
	

	public static void main(String[] args) {

		Map<Integer, Integer>map = MA.primeFactors(100);
		map.forEach((k,v) -> System.out.println(k + "^" + v));
		//System.out.println(Integer.MAX_VALUE-1);
		
	}
}
