// This program will be able to determine if inputted payment is valid or not with the help of multiple methods. (Jade Park - 7/11/2021)

import java.util.Scanner;

public class PaymentProcessing { 
   
   // Declaring variables (values will be changed accordingly to what the user inputs)
   public static int selection1 = 0;
   public static int selection2 = 0;
   public static String cardNumber = " ";
   public static String paymentMethod = " ";
   public static char firstCardDigit;
   public static int cardNumberLength = 0;
   public static String stringCardNumberLength = " ";
   public static String cardType = " ";
   public static boolean flag = true;
   
   // Main method
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      // A do-while loop that loops if an input is invalid
      do {
         System.out.println("\nWelcome to Starr! Here are the payment options we accept.");
         System.out.println("1 - Credit");
         System.out.println("2 - Cash/Check");
         System.out.println("3 - Purchase Requisition");
         System.out.print("Please enter the number that corresponds to the payment method you'll use today: ");
         // Using .parseInt to convert the user input to an integer & assigning that to selection1
         selection1 = Integer.parseInt(input.nextLine());
         
         // Redirecting the user to where they need to go in the program based on their selection
         if (selection1 == 2) {
            flag = false;
            paymentMethod = "Cash/Check";
            showSummary();
         } else if (selection1 == 3) {
            flag = false;
            paymentMethod = "Purchase Requisition";
            showSummary();
         } else if (selection1 == 1) {
            flag = false;
            paymentMethod = "Credit";
            System.out.print("Please enter your credit card number: ");
            cardNumber = input.nextLine(); 
            findCardType();
         } else {
            // If the selection was not valid, it loops (hence the flag becomes true)
            System.out.println("INVALID INPUT: Please try again.");
            selection1 = 0;
            flag = true;
         }
      } while (flag == true); // end of the do-while loop
      
 } // end of the main method
   
   
   
   // if payment is verified as valid, this confirmation method is executed
   public static void showSummary() {
      Scanner input = new Scanner(System.in);
   
      System.out.print("You selected the payment method of " + paymentMethod + ". Press 1 to confirm or 2 to restart: ");
      selection2 = input.nextInt();
      if (selection2 == 1) {
         System.out.println("Thank you for your purchase!");
      } else {
         flag = true;
      }
   }
   
   // A method that runs if the user wants to pay with credit card
   public static void findCardType() {
      Scanner input = new Scanner(System.in);
     // Extracts the first character of the inputted card number
      char firstCardDigit = cardNumber.charAt(0);
      
      // Determines what the card type is along with whether the user input is valid or not
      if (firstCardDigit == '3') {
         cardType = "American Express";
         validTest(firstCardDigit);
      } else if (firstCardDigit == '4') {
         cardType = "Visa";
         validTest(firstCardDigit);
      } else if (firstCardDigit == '5') {
         cardType = "Mastercard";
         validTest(firstCardDigit);
      } else if (firstCardDigit == '6') {
         cardType = "Discover";
         validTest(firstCardDigit);
      } else {
         invalid();
         
      } 
   }
   
         
   // A final test whether the card is valid or not   
   public static void validTest(char firstCardDigit) {

      cardNumberLength = cardNumber.length();
      
      if (firstCardDigit == '3') {
         if (cardNumberLength == 15) {
            System.out.println("You input your " + cardType + " credit card number as " + cardNumber + ".");
            showSummary();
         } else {
            invalid();
         }
      } else if (firstCardDigit == '4' || firstCardDigit == '5' || firstCardDigit == '6') {
      
         if (cardNumberLength == 16) {
            
            System.out.println("You input your " + cardType + " credit card number as " + cardNumber + ".");
            showSummary();
            
         } else {
            invalid(); 
         }
         
      } else {
         invalid();
      }

   }
   
   // A method that executes if any of the user inputs were invalid, giving the user a chance to re-start the program if they wish         
   public static void invalid() {
      Scanner input = new Scanner(System.in);
      System.out.print("Your inputs were invalid. Press 1 to restart or 2 to exit: ");
      selection2 = input.nextInt();
      if (selection2 == 1) {
         flag = true;
      } else {
         System.out.println("You have successfully exited the program.");
      }
   }
}
   
   
   
