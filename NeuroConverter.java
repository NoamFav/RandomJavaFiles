import java.util.Scanner;

public class NeuroConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your amount?:");
        double amount = scanner.nextDouble();

        scanner.nextLine();
        converter(amount);
        scanner.close();
    }

    public static void converter(double amount) {
        // -- Write your code below
        int neuro = (int) amount;
        int cents = (int) Math.round((amount - neuro) * 100);

        int coins1 = 0;
        int coins2 = 0;
        int coins3 = 0;

        if (cents >= 49) {
            coins1 = (int)(cents/49);
            cents -= coins1 * 49;
        }
        
        if (cents >= 9) {
            coins2 = (int)(cents/9);
            cents -= coins2 * 9;
        }

        if (cents >= 1) {
            coins3 = (int)(cents);
        }

        System.out.println(neuro);
        System.out.println(coins1);
        System.out.println(coins2);
        System.out.println(coins3);
        // Don't forget to print the output [check the requirements]
        // -- Write your code above
    }
}
