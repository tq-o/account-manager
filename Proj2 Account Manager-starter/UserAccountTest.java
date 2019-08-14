import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UserAccountTest {
   
   UserAccount acct1;
   String name1= "Horst";
   double bal1 =250.00;
   

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      acct1 = new UserAccount(name1, bal1);
   }

   /** Test the UserAccount constructor. **/
   @Test public void createAccountNameTest() {
      String name = acct1.getUserName(); 
      assertEquals("Test 1: user name set in constructor.", name1, name);
   }
   
   @Test public void createAccountBalanceTest() {
      double bal = acct1.getBalance(); 
      assertEquals("Test 2: initial balance set in constructor.", bal1, bal, 0.001);
   }
   
   @Test public void createAccountNumPurchasesTest() {
      int books = acct1.getNumPurchases(); 
      assertEquals("Test 3: getNumPurchases initialized correctly.", 0, books);
   }
   
   @Test public void createAccountTotalPurchaseAmountTest() {
      double amt = acct1.getTotalPurchaseAmount();
      assertEquals("Test 4: getTotalPurchaseAmount initialized correctly.", 0.0, amt, .001);
   }
   
   /*  Test addToBalance   */
   @Test public void addToBalanceTest() {
      double amountToAdd = 3.45;
      acct1.addToBalance(amountToAdd);
      double bal = acct1.getBalance(); 
      assertEquals("Test 5: test addToBalance method.", (bal1+amountToAdd), bal, 0.001);
   } 
   
   @Test public void makePurchaseOKTest() {
      double orderPrice = 33.98;
      boolean ok = acct1.makePurchase(orderPrice);
      assertEquals("Test 6: makePurchase returns true as price <= balance.", true, ok);
   }
   
   @Test public void makePurchaseNotOKTest() {
      double orderPrice = 1033.98;
      boolean ok = acct1.makePurchase(orderPrice);
      assertEquals("Test 7: makePurchase returns false as price exceeds balance.", false, ok);
   }
   
   @Test public void orderBookBalanceCorrectAfterPurchaseTest() {
      double orderPrice = 33.98;
      boolean ok = acct1.makePurchase(orderPrice);
      double bal = acct1.getBalance();
      assertEquals("Test 8: current balance correctly updated after order.", (bal1-orderPrice), bal, 0.001);
   }
   
   @Test public void orderBookBalanceCorrectAfterNoPurchaseTest() {
      double orderPrice = 1033.98;
      boolean ok = acct1.makePurchase(orderPrice);
      double bal = acct1.getBalance();
      assertEquals("Test 9: current balance correctly updated after order.", bal1, bal, 0.001);
   }
   
  @Test public void numPurchasesCorrectAfterOrderTest() {
      double orderPrice = 33.98;
      acct1.makePurchase(orderPrice);
      int num = acct1.getNumPurchases();
      assertEquals("Test 10: number of purchases correctly updated after order.", 1, num);
   }
 
   @Test public void numPurchasesCorrectAfterNoOrderTest() {
      double orderPrice = 1033.98;
      acct1.makePurchase(orderPrice);
      int num = acct1.getNumPurchases();
      assertEquals("Test 11: number of purchases correctly updated after no order.", 0, num);
   } 
   
  @Test public void totalPurchaseAmtCorrectAfterOrderTest() {
      double orderPrice = 33.98;
      acct1.makePurchase(orderPrice);
      double totalAmt = acct1.getTotalPurchaseAmount();
      assertEquals("Test 12: total purchase amount correctly updated after order.", orderPrice, totalAmt, .001);
   }   
   
  @Test public void totalPurchaseAmtCorrectAfterNoOrderTest() {
      double orderPrice = 1033.98;
      acct1.makePurchase(orderPrice);
      double totalAmt = acct1.getTotalPurchaseAmount();
      assertEquals("Test 13: total purchase amount correctly updated after order.", 0, totalAmt, .001);
   } 
   
   @Test public void balanceTwoPurchaseTest() {
      acct1.makePurchase(33.98);
      acct1.makePurchase(22.68);
      double bal = acct1.getBalance();
      assertEquals("Test 14: current balance correctly updated after two purchases.", (bal1-(33.98+22.68)), bal, 0.001);
   }
   
  @Test public void numPurchasesTwoPurchaseTest() {
      acct1.makePurchase(33.98);
      acct1.makePurchase(22.68);
      int num = acct1.getNumPurchases();
      assertEquals("Test 15: number of purchases ordered correctly updated after two purchases.", 2, num);
   }
   
   @Test public void totalPurchaseAmtTwoPurchaseTest() {
      acct1.makePurchase(33.98);
      acct1.makePurchase(22.68);
      double amt = acct1.getTotalPurchaseAmount();
      assertEquals("Test 16: number of purchases ordered correctly updated after two purchases.", 33.98+22.68, amt, .001);
   }  
}
   
  