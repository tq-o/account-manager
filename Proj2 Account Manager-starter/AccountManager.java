import java.util.Scanner;
/* This class runs a console interface between a user and 
 * an the user's account. It allows the user to make purchases and 
 * add to their balance.
*/
public class AccountManager {
       
   public static void main(String[] args){
       
      System.out.println("My User Account");
      Scanner scan = new Scanner(System.in);
         
      UserAccount acct=null;
      boolean keepGoing = true;
      String inputStr = "";
      double dblAmt = 0.00;
         
      while(keepGoing) {
         System.out.println("Main Menu:");
         System.out.println("Enter N to create a new account.");
         System.out.println("Enter A to add to your balance.");   
         System.out.println("Enter O to make a purchase."); 
         System.out.println("Enter S to print an account summary.");  
         System.out.println("Enter X to quit.");
         System.out.println("");
         inputStr = scan.nextLine();
              
         if (inputStr.equalsIgnoreCase("N")){
            System.out.println("Enter your user name: ");
            inputStr = scan.nextLine();           
            System.out.println("Enter a starting balance: ");
            dblAmt = Double.parseDouble(scan.nextLine());
            acct = new UserAccount(inputStr, dblAmt);
         }
         else if (inputStr.equalsIgnoreCase("A")){
            if(acct == null)
               System.out.println("Enter N to create an account.");
            else{
               System.out.println("Enter the amount to add: ");
               dblAmt = Double.parseDouble(scan.nextLine());
               acct.addToBalance(dblAmt);
            }
         }              
         else if (inputStr.equalsIgnoreCase("O")){
            if(acct == null)
               System.out.println("Enter N to create an account.");
            else{              
               System.out.println("Enter the amount of the purchase: ");
               inputStr = scan.nextLine();
               dblAmt = Double.parseDouble(inputStr);
               boolean ok = acct.makePurchase(dblAmt);  
               if(!ok) 
                  System.out.println("Insufficient funds for purchase.");
               else              
                  System.out.println("Your order has been placed.");
            }
         }
         else if (inputStr.equalsIgnoreCase("S")){
            if(acct == null)
               System.out.println("Enter N to create an account.");
            else{
               String acctName = acct.getUserName();
               double balance = acct.getBalance();
               int totalOrdered = acct.getNumPurchases();
               double totalAmount = acct.getTotalPurchaseAmount();
               System.out.println("Account summary for "+acctName+":");
               System.out.println("Current balance: "+balance);
               System.out.println("Total number of items purchased: "+totalOrdered);
               System.out.println("Total amount purchased to date: "+totalAmount);
            }
         }              
         else if(inputStr.equalsIgnoreCase("X")){
            keepGoing = false;
         }
         else
            System.out.println("Unrecognized input.");
         System.out.println("");               
      }
      System.out.println("Bye for now.");
      scan.close();
   } 
}