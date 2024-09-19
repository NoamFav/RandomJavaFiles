import java.util.Scanner;

public class NeuroChange {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("amount to change to neuro: ");
        double x = scanner.nextDouble();
        scanner.close();

        int[] result = changeInCoins(x);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    public static int[] changeInCoins(double x) {
        double[] coins = {0.49, 0.09, 0.01};

        int euro = (int) x;
        double cents = x - euro;

        int[] coinCounts = new int[3];
        for (int i = 0; i < coins.length; i++) {
            coinCounts[i] = (int) (cents / coins[i]);
            cents -= coinCounts[i] * coins[i];
            cents = Math.round(cents * 100.0) / 100.0;
        }

        return new int[] {euro, coinCounts[0], coinCounts[1], coinCounts[2]};
    }
}