package RPGgame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//import functions
public class Memory{
//declares the class

    public static void main(String[] args){
        //Declares the main function

         Scanner input = new Scanner(System.in);
         Random obj = new Random();
         //Starts scanner

        String[] Items = {"dog", "bucket", "window", "cup", "table",
         "cat", "frog", "bench", "track", "pencil", "fire", "water", 
         "house"};
        
         //String of Items to be randomly chossen from

        
        String answerOne = Items[obj.nextInt(13)];
        String answerTwo = Items[obj.nextInt(13)];
        String answerThree = Items[obj.nextInt(13)];
        String answerFour = Items[obj.nextInt(13)];
        String answerFive = Items[obj.nextInt(13)];
        //Stores the 5 words for the user to remember in variables

        System.out.println("Remember thiese words:");
        //Tells the user what they are supposed to do

        System.out.println(answerOne);
        System.out.println(answerTwo);
        System.out.println(answerThree);
        System.out.println(answerFour);
        System.out.println(answerFive);
        
        //Prints out 5 different words for the user to remember


        //Add in something that clears whats been put on the screen


        //Thread.sleep(5000);

        
        //Gets the User data about the words
        System.out.println("Type the first word");
        String wordOne = input.nextLine();
        System.out.println("Type the second word");
        String wordTwo = input.nextLine();
        System.out.println("Type the third word");
        String wordThree = input.nextLine();
        System.out.println("Type the fourth word");
        String wordFour = input.nextLine();
        System.out.println("Type the final word");
        String wordFive = input.nextLine();


        Boolean  checkOne = answerOne.equals(wordOne);
        Boolean checkTwo = answerTwo.equals(wordTwo);
        Boolean checkThree = answerThree.equals(wordThree);
        Boolean checkFour = answerFour.equals(wordFour);
        Boolean checkFive = answerFive.equals(wordFive);
       
        if (checkOne && checkTwo && checkThree && checkFour && checkFive) { 
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect!");
        }
    }
}