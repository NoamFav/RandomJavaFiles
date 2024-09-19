import java.util.Scanner;

public class CoolNumbers {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Value of n: ");
        int n = scanner.nextInt();

        System.out.print("Value of x: ");
        int x = scanner.nextInt();

        System.out.print("Value of a: ");
        int a = scanner.nextInt();

        System.out.print("Value of b: ");
        int b = scanner.nextInt();
        scanner.close();
        
        //This is just to test your method
        System.out.println(isCool(x,n));
        System.out.println(countCools(n,a,b));
    }

    public static boolean isCool(int x, int n) {

        if (x == 0) {
            return false;
        }

        int temp = x;

        while (temp != 0) {
            int digit = temp % 10;

            if (digit == 0 || n % digit != 0) {
                return false;
            }

            temp /= 10;
        }

        return true;
    }



    public static int countCools(int n, int a, int b) {
        int count = 0;

        for (int i = a; i <= b; i++) {
            if (isCool(i, n)) {
                count++;
            }
        }

        return count;
    }
}