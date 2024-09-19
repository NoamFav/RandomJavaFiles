import java.time.Year;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.ArrayList;

public class Game {

    private static final String[] storyArray = {
        "You are standing in an abandoned university office. There are neither students nor teachers around you. There’s a table in front of you with various papers, pens, a small puzzle toy, and a calculator. A large window shows an empty office building; there are no Zombies in the empty building (as far as you can tell). Behind you is a dark and mysterious door that leads to a well-lit corridor with a fireproof ceiling and floor. You feel a sense of Wi-Fi around you, the grinding of an LCD operated coffee machine can be heard in the distance. You are not thirsty, but you rather have a craving for justice.",
        "You are in a long hallway. There’s a man wearing glasses at the end of it, he looks harmless. West is a wall, east is the man, to the north is nothing but empty offices, a desperate sight. The carpeting in the hallway feels soft, you hear the clicking of a mouse in the distance. Your office is south (behind you).",
        "You take the calculator from your desk. It’s a Casio FX-85gt Plus. The display shows the number 0.1134. You turn it upside down; now the Casio greets you with a friendly “hello”, nice. You hold the calculator in your hand.",
        "The man greets you and starts endlessly talking to you about his children and his holiday to Benidorm. You die of boredom.",
        "You enter the hallway with the Casio FX-85gt stand-by. Having this small device greet you puts you in a good mood, somehow the building feels less lonely than before. West is a wall, looking east you stare into the darkness, the corridor is too long to see the end. To the north you see an office with what looks like a small creature in a corner. The carpeting in the hallway feels soft, you hear someone explaining algorithms to your north.",
        "You enter the office. To your surprise a small dog is sitting in the corner. Surely this breaks any number of university regulations! In a high-pitched voice the dog tells you how to write even more cool words on your Casio FX-85gt, good boi! To the north you see an open window, a ladder hangs down from it, it looks so dangerous! An LCD display shows a youtube video about developing algorithms.",
        "Exit"};

    private static ArrayList <String> actionList = new ArrayList<>(Arrays.asList("open the door", "go north", "go east", "go south", "go west", "take item", "drop item", "exit"));

    private static final String[][] transitionMatrix = {
        {"", "open the door", "take item", "", "", ""},
        {"go south", "", "", "go east", "", ""},
        {"", "", "", "", "open the door", ""},
        {"", "", "", "", "", ""},
        {"", "drop item", "", "", "", "go north"},
        {"", "go south", "", "", "", ""}
    };

    public static int takeAction(String action, int currentState) {
        for(int i = 0; i < transitionMatrix[currentState].length; i++) {
            if (transitionMatrix[currentState][i].equals(action)) {
                return i;
            }
        }
        return currentState;
    }

    public static String getStory(int currentState) {
        return storyArray[currentState];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("     ____.                                        .___                    __                        ");
        System.out.println("    |    | __________________ ___.__. _____     __| _/__  __ ____   _____/  |_ __ _________   ____  ");
        System.out.println("    |    |/ __ \\_  __ \\_  __ <   |  | \\__  \\   / __ |\\  \\/ // __ \\ /    \\   __\\  |  \\_  __ \\_/ __ \\ ");
        System.out.println("/\\__|    \\  ___/|  | \\/|  | \\/\\___  |  / __ \\_/ /_/ | \\   /\\  ___/|   |  \\  | |  |  /|  | \\/\\  ___/ ");
        System.out.println("\\________|\\___  >__|   |__|   / ____| (____  /\\____ |  \\_/  \\___  >___|  /__| |____/ |__|    \\___  >");
        System.out.println("              \\/              \\/           \\/      \\/           \\/     \\/                        \\/ ");
        System.out.println("By noam favier");

        System.out.print("What is your name?: ");
        String name = scanner.nextLine();
        System.out.println("Hi " + name + "  !");

        System.out.print("\nWhen were you born?: ");
        int ageYear = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Oh so you're " + Age(ageYear) + " years old!\n");

        int currentState = 0;
        int previousState = -1;
        System.out.println("You are standing in an abandoned university office. There are neither students nor teachers around you. There’s a table in front of you with various papers, pens, a small puzzle toy, and a calculator. A large window shows an empty office building; there are no Zombies in the empty building (as far as you can tell). Behind you is a dark and mysterious door that leads to a well-lit corridor with a fireproof ceiling and floor. You feel a sense of Wi-Fi around you, the grinding of an LCD operated coffee machine can be heard in the distance. You are not thirsty, but you rather have a craving for justice.");

        while (true) {
        System.out.print("What would you like to do?: ");
        String action = scanner.nextLine().toLowerCase();

        if ("exit".equals(action)) {
            System.out.println("Exiting the game...");
            break;
        }

        if (!actionList.contains(action)) {
            System.out.println("Invalid Input");
            continue;
        }

        previousState = currentState;
        currentState = takeAction(action, currentState);

        if (currentState == previousState) {
            System.out.println("Nothing happened");
            continue;
        }

        System.out.println("\n" + getStory(currentState) + "\n");
    }

        scanner.close();
    }

    public static int Age(int year) {
        return Year.now().getValue() - year;
    }
}
