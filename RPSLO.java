import java.util.Scanner;
import java.util.Random;

public class RPSLO {

    public static void main(String[] args) {
        System.out.println("Enter your play: R, P, S, L, O");
        Scanner scanner = new Scanner(System.in);
        // Write your code below
        char choiceUser = Character.toUpperCase(scanner.nextLine().charAt(0));
        
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        
        char[] choice = {'R','P','S','L','O'};
        char choiceComp = choice[randomNumber];
        System.out.println("Computer play is " + choiceComp);

        if (choiceComp == choiceUser) {
            System.out.println("It is a tie!");
        } else if ((choiceUser == 'R' && (choiceComp == 'P' || choiceComp == 'O')) ||
                   (choiceUser == 'P' && (choiceComp == 'S' || choiceComp == 'L')) ||
                   (choiceUser == 'S' && (choiceComp == 'R' || choiceComp == 'O')) ||
                   (choiceUser == 'O' && (choiceComp == 'P' || choiceComp == 'L')) ||
                   (choiceUser == 'L' && (choiceComp == 'R' || choiceComp == 'S'))) {
            System.out.println("Computer wins!");
        } else if (choiceUser == 'R' || choiceUser == 'P' || choiceUser == 'S' || choiceUser == 'L' || choiceUser == 'O') {
            System.out.println("You win!");
        } else {
            System.out.println("Invalid input (valid inputs: R, P, S, L, O)");
        }
        scanner.close();
        // Write your code above
    }
}