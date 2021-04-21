# SimpleBankingSystem
 This project implements a very simple version of the banking system.    
 
 The program allows customers to create a new account in our banking system. 
Once the program starts, you should print the menu:
```
1. Create an account
2. Log into account
0. Exit
```
If the customer chooses `Create an account`, the program generates a new card number which satisfies all the conditions described above. Then it generates a PIN code that belongs to the generated card number. A PIN code is a sequence of any 4 digits. PIN generates in a range from 0000 to 9999.    
If the customer chooses `Log into account`, the program asks them to enter their card information.    
After logging in the program allows customers actions:
```
1. Balance
2. Add income
3. Do transfer
4. Close account
5. Log out
0. Exit
```
If the user asks for `Balance`, the program output it into the console.    
`Add income` item allows us to deposit money to the account.    
`Do transfer` item allows transferring money to another account. The following errors are handled:    
- If the user tries to transfer more money than he/she has, output: `Not enough money!`
- If the user tries to transfer money to the same account, output the following message: `You can't transfer money to the same account!`
- If the receiver's card number doesn’t pass the Luhn algorithm, output: `Probably you made a mistake in the card number. Please try again!`
- If the receiver's card number doesn’t exist, output: `Such a card does not exist`   
 
If there is no error, ask the user how much money they want to transfer and make the transaction.    
If the user chooses the `Close an account` item, the program deletes that account from the database.

## Example 1:
```
1. Create an account
2. Log into account
0. Exit
>1

Your card has been created
Your card number:
4000009455296122
Your card PIN:
1961

1. Create an account
2. Log into account
0. Exit
>1

Your card has been created
Your card number:
4000003305160034
Your card PIN:
5639

1. Create an account
2. Log into account
0. Exit
>2

Enter your card number:
>4000009455296122
Enter your PIN:
>1961

You have successfully logged in!

1. Balance
2. Add income
3. Do transfer
4. Close account
5. Log out
0. Exit
>2

Enter income:
>10000
Income was added!

1. Balance
2. Add income
3. Do transfer
4. Close account
5. Log out
0. Exit
>1

Balance: 10000

1. Balance
2. Add income
3. Do transfer
4. Close account
5. Log out
0. Exit
>3

Transfer
Enter card number:
>4000003305160035
Probably you made a mistake in the card number. Please try again!

1. Balance
2. Add income
3. Do transfer
4. Close account
5. Log out
0. Exit
>3

Transfer
Enter card number:
>4000003305061034
Such a card does not exist.

1. Balance
2. Add income
3. Do transfer
4. Close account
5. Log out
0. Exit
>3

Transfer
Enter card number:
>4000003305160034
Enter how much money you want to transfer:
>15000
Not enough money!

1. Balance
2. Add income
3. Do transfer
4. Close account
5. Log out
0. Exit
>3

Transfer
Enter card number:
>4000003305160034
Enter how much money you want to transfer:
>5000
Success!

1. Balance
2. Add income
3. Do transfer
4. Close account
5. Log out
0. Exit
>1

Balance: 5000

1. Balance
2. Add income
3. Do transfer
4. Close account
5. Log out
0. Exit

>0
Bye!
```
## Example 2:
```
1. Create an account
2. Log into account
0. Exit
>1

Your card has been created
Your card number:
4000007916053702
Your card PIN:
6263

1. Create an account
2. Log into account
0. Exit
>2

Enter your card number:
>4000007916053702
Enter your PIN:
>6263

You have successfully logged in!

1. Balance
2. Add income
3. Do transfer
4. Close account
5. Log out
0. Exit
>4

The account has been closed!

1. Create an account
2. Log into account
0. Exit
>2

Enter your card number:
>4000007916053702
Enter your PIN:
>6263

Wrong card number or PIN!

1. Create an account
2. Log into account
0. Exit
>0

Bye!
```
