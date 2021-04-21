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

/*    static void createAccount() {
        CreditCard cc;
        Random rnd;
        StringBuilder account_identifier;
        StringBuilder pin;
        String checksum;

        do {
            rnd = new Random(System.nanoTime());
            account_identifier = new StringBuilder();
            pin = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                account_identifier.append(rnd.nextInt(10));
            }

            for (int i = 0; i < 4; i++) {
                pin.append(rnd.nextInt(10));
            }

            checksum = luhnAlg(new StringBuilder("400000" + account_identifier));

            String number = "400000" + account_identifier + checksum;

            if (!cardDB.containsKey(number)) {
                cc = new CreditCard(account_identifier.toString(), checksum, pin.toString());
                cardDB.put(cc.getNumber(), cc);
                myJDBC.addToDB(cardDB.size(), number, pin.toString(), 0);
                break;
            }
        } while (true);

        System.out.printf("%nYour card has been created%n" +
                "Your card number:%n" +
                "%s%n" +
                "Your card PIN:%n" +
                "%s%n%n", cc.getNumber(), pin);
    }

    static CreditCard loggingIn() {
        CreditCard card;
        System.out.println("\nEnter your card number:");
        String cardNumber = sc.nextLine();
        System.out.println("Enter your card PIN:");
        String pin = sc.nextLine();
        card = cardDB.getOrDefault(cardNumber, null);
        if (card != null && card.checkPIN(pin)) {
            System.out.println("\nYou have successfully logged in!\n");
            status = "Logged in";
            return card;
        }
        System.out.println("\nWrong card number or PIN!\n");
        return null;
    }

    static void loggingOut() {
        currentCard = null;
        status = "";
        System.out.println("\nYou have successfully logged out!\n");
    }

    static String luhnAlg(StringBuilder str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int digit = Integer.parseInt(str.substring(i, i + 1));
            digit = digit + digit * ((i + 1) % 2);
            if (digit > 9) digit -= 9;
            sum += digit;
        }
        return Integer.toString(sum % 10 == 0 ? 0 : 10 - sum % 10);
    }

    static void addIncome() {
        System.out.println("\nEnter income:");
        int income = Integer.parseInt(sc.nextLine());
        if (income < 0) System.out.println("ERROR! Incorrect income!");
        else {
            currentCard.setBalance(income);
            myJDBC.updateBalanceInDB(currentCard.getNumber(), currentCard.getBalance());
            System.out.println("Income was added!\n");
        }
    }

    static void doTransfer() {
        System.out.println("\nTransfer\nEnter card number:");
        String recipientCardNumber = sc.nextLine();
        if (!recipientCardNumber.substring(15).equals(luhnAlg(new StringBuilder(recipientCardNumber.substring(0, 15))))) {
            System.out.println("Probably you made a mistake in the card number. Please try again!\n");
        } else if (!cardDB.containsKey(recipientCardNumber)) {
            System.out.println("Such a card does not exist.\n");
        } else if (currentCard.getNumber().equals(recipientCardNumber)) {
            System.out.println("You can't transfer money to the same account!\n");
        } else {
            System.out.println("\nEnter how much money you want to transfer:");
            int income = Integer.parseInt(sc.nextLine());
            if (income < 0) System.out.println("ERROR! Incorrect income!\n");
            else if (income > currentCard.getBalance()) System.out.println("Not enough money!\n");
            else {
                currentCard.setBalance(-1 * income);
                myJDBC.updateBalanceInDB(currentCard.getNumber(), currentCard.getBalance());

                CreditCard recipientCard = cardDB.get(recipientCardNumber);
                recipientCard.setBalance(income);
                myJDBC.updateBalanceInDB(recipientCardNumber, recipientCard.getBalance());
                System.out.println("Success!");
            }
        }


    }

    static void closeAccount() {
        myJDBC.deleteAccountFromDB(currentCard.getNumber());
        cardDB.remove(currentCard.getNumber());
        currentCard = null;
        status = "";
        System.out.println("The account has been closed!\n");
    }*/
}