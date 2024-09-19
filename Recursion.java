import java.util.Scanner;
import java.math.BigInteger;
import java.util.Arrays;

public class Recursion {
    public static BigInteger Expo(int exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("Exponent should be non-negative");
        }
        if (exp == 0) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(exp).multiply(Expo(exp - 1));
    }

    public static BigInteger[] Fibonacci(int mxgen) {
        if (mxgen < 2) {
            throw new IllegalArgumentException("Input number should be higher than 1");
        }

        BigInteger[] list = new BigInteger[mxgen];
        list[0] = BigInteger.ONE;
        list[1] = BigInteger.ONE;
        for (int gen = 2; gen < mxgen; gen++) {
            list[gen] = list[gen - 1].add(list[gen - 2]);
        }
        return list;
    }

    /*
    public static long fibonacci(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n]; // return if value is already calculated
        }
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo); // store value in memo
        return memo[n];
    }
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Exponent: 1 - Fibonacci: 2:  ");
        long st = System.currentTimeMillis();
        int choice = sc.nextInt();
        if (choice == 1){
	        int exp = sc.nextInt();
	        System.out.print("enter positive integer");
	        for (int i = 1; i <= exp; i++) {
	        	System.out.println(Expo(i));
	        }
	    } else if (choice == 2) {
	    	int mxgen = sc.nextInt();
	    	System.out.print("enter positive integer");
	    	System.out.println(Arrays.toString(Fibonacci(mxgen)));
	    }
	    long ft = System.currentTimeMillis();
	    System.out.println ("it tooked: " + (ft - st) + "nanosecond");

    }
}