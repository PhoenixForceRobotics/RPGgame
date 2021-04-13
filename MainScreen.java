package RPGgame;

import java.io.FileNotFoundException;
import java.util.Scanner;

import RPGgame.EscapeRoomDrone.escaperoom.EscapeRoom;

public class MainScreen {
    private static Scanner input = new Scanner(System.in);
    private static int choice = 1;
    public static void main(String args[]) throws InterruptedException, FileNotFoundException {
        System.out.println("Welcome to PFR RPG!");
        System.out.println("What Game would you like to play?");
        System.out.println("0. Quit");
        System.out.println("1. Battle");
        System.out.println("2. Escape Room");

        
        while (choice != 0) {
            choice  = input.nextInt();
            System.out.print("You have chosen ");
            if (choice == 0) {
                System.out.print("to quit\n");
            } else if (choice == 1) {
                System.out.print("the game Battle! \n");
                Battle.main(args);
            } else if (choice == 2) {
                System.out.print("the game Escape Room! \n");
                EscapeRoom.main(args);
            } else {
                System.out.print("to not follow instructions, because you have chosen a game that does not exist (:");
            }
        }


    }
}
