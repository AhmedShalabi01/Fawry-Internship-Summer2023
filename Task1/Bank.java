import java.util.ArrayList;
public class Bank {

    private final ArrayList<Account> accounts = new ArrayList<>();


    public void addNewAccount(Account account) {

        accounts.add(account);
    }

    public void addSavingAccount(SavingAccount savingaccount) {

        accounts.add(savingaccount);
    }

    public void deposit(int accountNum, double balance) {

        Account account = searchAccount(accountNum);

        if (account != null) {

            account.deposit(balance);
        } else
            System.out.println("Sorry, the Account Number is not found!");

    }

    public void withdraw(int accountNum, double balance) {

        Account account = searchAccount(accountNum);

        if (account != null) {

            account.withdraw(balance);

        } else
            System.out.println("Sorry, the Account Number is not found!");
    }

    public void displayBalance(int accountNum) {

        Account account = searchAccount(accountNum);

        if (account != null) {

            System.out.println("The account number :" + accountNum + " has a balance of : " + account.getBalance());

        } else
            System.out.println("Sorry, the Account Number is not found!");
    }

    public void displayInterest(int accountNum) {

        Account account = searchAccount(accountNum);

        if (account != null) {

            if (account instanceof SavingAccount) {

                double balanceWithInterest = ((SavingAccount) account).interest();
                System.out.println( "The balance with interests would be " + " " + balanceWithInterest);

            } else
                System.out.println("Sorry the account is not a saving account");

        } else
            System.out.println("Sorry, the Account Number is not found!");
    }

    public Account searchAccount(int desiredAccount) {

        for (Account account : accounts) {

            if (account.getAccountNumber() == desiredAccount) {
                return account;
            }
        }

        return null;
    }
}
