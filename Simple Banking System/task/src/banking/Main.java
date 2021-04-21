package banking;

import static banking.BankingSystem.*;

public class Main {

    public static void main(String[] args) {

        myJDBC = new MyJDBC("jdbc:sqlite:" + args[1]);

        cardDB = myJDBC.readDB();
        while (!status.equals("0")) {
            printMenu();
            menuAction(sc.nextInt());
        }

    }

    static void printMenu() {
        if (status.equals("")) {
            System.out.println("1. Create an account\n" +
                    "2. Log into account\n" +
                    "0. Exit");
        } else if (status.equals("Logged in")) {
            System.out.println("1. Balance\n" +
                    "2. Add income\n" +
                    "3. Do transfer\n" +
                    "4. Close account\n" +
                    "5. Log out\n" +
                    "0. Exit");
        }
    }

    static void menuAction(int choice) {
        sc.nextLine();
        switch (choice) {
            case 1:
                if (status.equals("")) createAccount();
                else System.out.printf("%nBalance: %d%n%n", currentCard.getBalance());
                break;
            case 2:
                if (status.equals("")) currentCard = loggingIn();
                else addIncome();
                break;
            case 3:
                doTransfer();
                break;
            case 4:
                closeAccount();
                break;
            case 5:
                loggingOut();
                break;
            case 0:
                status = "0";
                System.out.println("\nBye!");
                break;
            default:
                break;
        }
    }
}
