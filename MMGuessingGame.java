//Programmer: Makealah Miller
//Class: CS &145
//Date: 04/10/2023
//Assignment: Lab 1
//Purpose: Plays a random number guessing game based on user input

import java.util.Scanner; //imports scanner class from the library
import java.util.*; //import for random number

public class MMGuessingGame
{  
   public static void main(String[] args)
   {  //Create a scanner to obtain input from the command window
      Scanner input = new Scanner(System.in);
      String playAgain;
      int numGame = 1;
      int numTries = 0;
      int sum = 0;
      int bestScore = 9999;
      int totalTries = 0;
      String answerChar;
      
      intro();
      
      do
      {
         System.out.println("Would you like to play?");
         playAgain = input.next();
         answerChar = playAgain.substring(0,1);
         if(answerChar.equals("Y") || answerChar.equals("y"))
         {
            numTries = game(); 

            if (numTries < bestScore)
            {
               bestScore = numTries;
            }
            else if (numTries == bestScore)
            {
               bestScore = numTries;
            }
            else
            {
            }
               numGame ++;
               totalTries = numTries + totalTries;
         }
         else
         {
           stats(numGame, numTries, bestScore, totalTries);
           break; 
         }         
      } //end of do/while
      while(!answerChar.equals("y") || !answerChar.equals("Y"));
      
   } //end of main method  
   public static void intro() //intro method
   {
      System.out.println("Welcome to the number guessing game!");
      System.out.println("I will think of a number between 1 and 100");
      System.out.println("and will allow you to guess until you get it.");
      System.out.println("For each guess, I will tell you whether");
      System.out.println("the correct answer is higher than or");
      System.out.println("lower than your guess. Have fun!");
   } //end of intro method
   
   public static int game() //game method
   {
      Scanner input = new Scanner(System.in);
      int range = 100;
      int numTries = 0;
      int guess = 0;
      
      Random rand = new Random();
      int randomNumber = rand.nextInt(range) + 1; //randomly selects a number between 1 and 100
      System.out.print("I'm thinking of a number between 1 and ");
      System.out.println(range);
      
      while (guess != randomNumber)
      {  
         System.out.println("Your guess?");
         guess = input.nextInt(); //get a response and save to guess   
         if (guess > randomNumber)
         {
            System.out.println("The number is lower.");
            numTries ++;
         }
         else if (guess < randomNumber) //guess is lower
         {
            System.out.println("The number is higher.");
            numTries ++;
         }
         else
         {
            numTries ++;
         } //end of if/else   
      } //end of while loop
      if(numTries == 1)
      {
         System.out.print("Congratulations! You got it in ");
         System.out.print(numTries);
         System.out.println(" try!");
      }
      else
      {
         System.out.print("Congratulations! You got it in ");
         System.out.print(numTries);
         System.out.println(" tries!");
      }
      return numTries;
      
   } //end of game method
   
   public static void stats(int numGame, int numTries, int bestScore, int totalTries) //start of stats method
   {
      System.out.print("Your total number of games was: ");
      numGame = numGame - 1;
      System.out.println(numGame);
      System.out.print("Your total number of guesses was: ");
      System.out.println(totalTries);
      System.out.print("Your average number of guesses was: ");
      double average =(double) totalTries / numGame;
      System.out.println(average);
      System.out.print("Your best score was: ");
      System.out.println(bestScore);
   
      System.out.println("Thanks for playing! Have an out of this world day!");
   } //end of stats method
} //end of MMGuessingGame class