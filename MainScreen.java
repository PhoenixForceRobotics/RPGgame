package RPGgame;

import java.util.Scanner;
import RPGgame.Battle;

public class MainScreen {
    private static Scanner input = new Scanner(System.in);
    private static int choice = 1;
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Welcome to PFR RPG!");
        System.out.println("What Game would you like to play?");
        System.out.println("0. Quit");
        System.out.println("1. Battle");

        
        while (choice != 0) {
            choice  = input.nextInt();
            System.out.print("You have chosen ");
            if (choice == 0) {
                System.out.print("to quit\n");
            } else if (choice == 1) {
                System.out.print("the game Battle! \n");
                Battle.main(args);
            } else {
                System.out.print("to not follow instructions, because you have chosen a game that does not exist (:");
            }
        }


    }
}
