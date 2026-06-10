public class TestBankAccount {

    public static void main(String[] args) {

    
        CheckingAccount account = new CheckingAccount();

   
        account.setFirstName("John");
        account.setLastName("Doe");
        account.setAccountID(12345);
        account.setInterestRate(2.5);

    
        account.deposit(100.00);

   
        account.processWithdrawal(150.00);

    
        account.displayAccount();
    }
}
