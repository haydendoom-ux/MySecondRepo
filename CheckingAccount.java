public class CheckingAccount extends BankAccount {


    private double interestRate;

 
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    
    public void processWithdrawal(double amount) {

        balance -= amount;


        if (balance < 0) {
            balance -= 30;

            System.out.println("Overdraft occurred.");
            System.out.println("$30 overdraft fee assessed.");
        }

        System.out.println("Current Balance: $" + balance);
    }


    public void displayAccount() {

        accountSummary();

        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
