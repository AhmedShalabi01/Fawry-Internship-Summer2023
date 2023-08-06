import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    static int startOfAccountsNumbers = 1000;

    static boolean status = true;

    static String accountHolderName;

    static int accountNumber;

    static String accountNumberMessage = "Please enter the account Number";

    static String accountNameMessage = "Please enter the account holder Name.";

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Bank bank = new Bank();

        while(status)
        {
            out.println("Welcome to the Bank");
            out.println("Please chose one of the options");
            out.println("0: Exit");
            out.println("1: Open New Account");
            out.println("2: Deposit");
            out.println("3: Withdraw");
            out.println("4: Check Balance");
            out.println("5: Open Saving Account");
            out.println("6: Check Interest Balance");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0 -> {
                    out.println("Exiting the Application");
                    status = false;
                    System.exit(choice);
                }
                case 1 -> {
                    accountNumber = generateAccountNumber();
                    accountHolderName = onlyLetters(accountNameMessage);
                    bank.addNewAccount(new Account(accountHolderName, accountNumber));
                }
                case 2 -> {
                    accountNumber = readVal(scanner, accountNumberMessage);
                    double addedBalance = readVal(scanner, "Please enter the amount want to deposit.");
                    bank.deposit(accountNumber, addedBalance);
                }
                case 3 -> {
                    accountNumber = readVal(scanner, accountNumberMessage);
                    double withdrawalBalance = readVal(scanner, "Please enter the amount want to withdraw.");
                    bank.withdraw(accountNumber, withdrawalBalance);
                }
                case 4 -> {
                    accountNumber = readVal(scanner, accountNumberMessage);
                    bank.displayBalance(accountNumber);
                }
                case 5 -> {
                    accountNumber = generateAccountNumber();
                    accountHolderName = onlyLetters(accountNameMessage);
                    float interestRate = readRate(scanner, "Please enter the interest rate.");
                    bank.addSavingAccount(new SavingAccount(accountHolderName, accountNumber, interestRate));
                }
                case 6 -> {
                    accountNumber = readVal(scanner, accountNumberMessage);
                    bank.displayInterest(accountNumber);
                }
                default -> out.println("Error in entering the choice, please try again");
            }
        }
    }

    public static int readVal(Scanner stdin, String prompt){

        int value = -1;

        while(value<0) {
            out.println(prompt);
            String input=stdin.nextLine();

            try {
                value=Integer.parseInt(input);
            }

            catch(NumberFormatException e) {
                out.println("Please enter a valid input.");
                value = -1;
            }
        }

        return value;
    }

    public static float readRate(Scanner stdin, String message){
        float value = -1;

        while(value<0) {
            out.println(message);
            String input = stdin.nextLine();

            try {
                value = Float.parseFloat(input);
            }

            catch(NumberFormatException e) {
                out.println("Please enter a valid input.");
                value = -1;
            }
        }
        return value;
    }

    public static String onlyLetters(String message)
    {
        out.println(message);
        String accountHolderName = scanner.nextLine();
        while(!accountHolderName.matches("[a-zA-Z ]+")) {

            out.println("Invalid account holder name. Please enter only letters.");
            out.print("Enter account holder name: ");
            accountHolderName = scanner.nextLine();
        }
        return accountHolderName;
    }

    static int generateAccountNumber() {
        return startOfAccountsNumbers++;
    }

}
