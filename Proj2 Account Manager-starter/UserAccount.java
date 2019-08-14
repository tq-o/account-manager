/* This class models a user's account.
   The class keeps track of the user's current balance, number of items
   purchased, and the total monetary amount purchased.
   
   TODO: implement all of the methods in this class definition.
 */
 
public class UserAccount {

   String userName;
   double balance;
   int numPurchases;
   double totalPurchaseAmt;
 
    /* Constructor that initializes this account with a user name and
       an initial balance that is passed in. It also initializes the number 
       of purchases made to 0, and the total monetary amount of all purchases to 0.0.
    */
   public UserAccount(String userName, double initBal) {
      this.userName=userName;
      this.balance=initBal;
      this.numPurchases=0;
      this.totalPurchaseAmt=0.00;
   }
    
    /* Returns the user's name.
    */
   public String getUserName() {
      return userName;
   }
 
    /* Returns the user's balance.
    */
   public double getBalance() {
      return balance;
   }
    
     /* Returns the number of purchases made.
     */
   public int getNumPurchases() {
      return numPurchases;
   }
    
   /* Returns the total monetary amount of all purchases.
   */
   public double getTotalPurchaseAmount() {
      return totalPurchaseAmt;
   }
    
    /* This method adds the amount passed in to the current balance.
    */
   public void addToBalance(double amountToAdd) {
      balance+=amountToAdd;

   }
    
    /* This method makes a purchase for this user.
       First, the itemPrice has to be less than or equal to 
       the user's balance. If it is, then the number of purchases is incremented,
       the itemPrice is added to the totalPurchaseAmt and the itemPrice is subtracted 
       from the users balance. The method then returns true. If not, the method returns 
       false and no transaction is made.  
    */
   public boolean makePurchase(double itemPrice) {
      if (itemPrice <= balance) {
         numPurchases+=1;
         totalPurchaseAmt+=itemPrice;
         balance-=itemPrice;
      return true;
      }
      
      else {
      return false;
      }
   }
}