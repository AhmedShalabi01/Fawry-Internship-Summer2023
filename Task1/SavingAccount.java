public class SavingAccount extends Account{
    private final float interestRate;

    public SavingAccount(String accountName, int accountNumber,float interestRate) {

        super(accountName, accountNumber);
        this.interestRate = interestRate;
    }

    public double interest() {

        return  getBalance() * interestRate;
    }

}
