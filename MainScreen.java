package RPGgame;

import java.util.Scanner;
import RPGgame.Battle;

public class MainScreen {
    private static Scanner input = new Scanner(System.in);
    private static int choice = 0;
    public static void main(String args[]){
        System.out.println("Welcome to PFR RPG!");
        System.out.println("What Game would you like to play?");
        System.out.println("1. Battle");

        choice  = input.nextInt();
        System.out.print("You have chosen the game ");

        if (choice == 1) {
            System.out.print("Battle! \n");
            Battle.main(args);
        } else {
            System.out.print("Breaking the rules, because you have chosen a game that does not exist (:");
        }



    }
}
