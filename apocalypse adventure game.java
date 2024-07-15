import java.util.Scanner;

public class ApocalypseAdventure {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        System.out.println("Welcome to the Apocalypse Adventure!");
        System.out.println("You wake up in a desolate world, ravaged by a mysterious virus.");
        System.out.println("Where would you like to start? (1) City (2) Rural Area");
        
        int location = getUserChoice(2);
        
        if (location == 1) {
            cityAdventure();
        } else {
            ruralAdventure();
        }
    }

    private static void cityAdventure() {
        System.out.println("You find yourself in the abandoned city streets.");
        System.out.println("Suddenly, you encounter a group of survivors.");
        System.out.println("Do you want to (1) Approach them cautiously (2) Hide and observe");

        int choice = getUserChoice(2);

        if (choice == 1) {
            System.out.println("You approach the survivors. They seem friendly and invite you to join them.");
            gatherResources();
        } else {
            System.out.println("You hide and observe. Unfortunately, they notice you and become hostile.");
            endGame("You have been attacked by the survivors. Game Over.");
        }
    }

    private static void ruralAdventure() {
        System.out.println("You are in a quiet rural area, with fields and sparse houses.");
        System.out.println("Do you want to (1) Search a house (2) Explore the fields");

        int choice = getUserChoice(2);

        if (choice == 1) {
            System.out.println("You find supplies in the house but also encounter a dangerous animal.");
            endGame("The animal attacks you. Game Over.");
        } else {
            System.out.println("You find a hidden stash of food and a map!");
            gatherResources();
        }
    }

    private static void gatherResources() {
        System.out.println("You now have resources! Do you want to (1) Escape the area or (2) Confront an enemy?");
        
        int choice = getUserChoice(2);

        if (choice == 1) {
            System.out.println("You successfully escape the area and find safety!");
            endGame("Congratulations, you've survived the apocalypse!");
        } else {
            System.out.println("You confront a band of raiders.");
            endGame("Despite your bravery, you are outnumbered. Game Over.");
        }
    }

    private static int getUserChoice(int numberOfChoices) {
        int choice = -1;
        while (choice < 1 || choice > numberOfChoices) {
            System.out.print("Enter your choice (1-" + numberOfChoices + "): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > numberOfChoices) {
                    System.out.println("Invalid choice, please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid number. Please enter a number.");
            }
        }
        return choice;
    }

    private static void endGame(String message) {
        System.out.println(message);
        System.exit(0);
    }
}
