
public class Account
{
    private final String accountHolderName;
    private final int accountNumber;
    private double balance;
    public Account(String accountHolderName, int accountNumber  ) {

        this.accountNumber=accountNumber;
        this.accountHolderName=accountHolderName;
        System.out.println("Account opened successfully! Account number: " + accountNumber);
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountHolderName;
    }

    public void deposit(double addedBalance) {

        if (addedBalance<=0) {
            System.out.println("Sorry, the amount needs to be larger than zero.");
        }

        else {
            balance += addedBalance;
            System.out.println("The amount has been deposited successfully.");
            System.out.println("The new balance : " + balance);
        }
    }

    public void withdraw(double withdrawnBalance) {

        if (balance<=0) {
            System.out.println("The account has a zero balance, so no withdrawal can be applied.");
        }

        else if (withdrawnBalance<=0) {
            System.out.println("Sorry, the amount needs to be larger than zero.");
        }

        else if (withdrawnBalance> balance) {
            System.out.println("Sorry, your account does not have enough money to withdraw this amount.");
        }

        else {
            balance -= withdrawnBalance;
            System.out.println("The amount has been withdrawn successfully.");
            System.out.println("The new balance : "+ balance);
        }
    }


}
