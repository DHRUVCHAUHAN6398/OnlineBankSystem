package Task2;

import java.util.*;

class Account {
    String CustomerName;
    String AccountNumber;
    String username;
    String password;
    String TransactionHistory = "";
    int transaction = 0;
    float Balance = 1000000f;

    public void registration() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter Your Name: ");
        this.CustomerName = sc.nextLine();
        System.out.print("Please Enter Your Account Number: ");
        this.AccountNumber = sc.nextLine();
        System.out.print("Please Enter Your UserName: ");
        this.username = sc.nextLine();
        System.out.print("Please Enter Your Password: ");
        this.password = sc.nextLine();

        System.out.println("\nYour Registration is Completed!!!! \n");
        System.out.println("Please Login to your Account \n");
    }

    public boolean login() {
        boolean newlogin = false;
        Scanner sc = new Scanner(System.in);
        while (!newlogin) {
            System.out.print("Please Enter your UserName: ");
            String UserName = sc.nextLine();
            if (UserName.equals(username)) {
                while (!newlogin) {
                    System.out.print("Please Enter your Password: ");
                    String PassWord = sc.nextLine();
                    if (PassWord.equals(password)) {
                        System.out.println("\nLogin Successful!!!!\n");
                        newlogin = true;
                    } else {
                        System.out.println("\nIncorrect Password\n");
                    }
                }
            } else {
                System.out.println("\nUsername not found\n");
                System.out.println("\nKindly Register First\n");
            }
        }
        return newlogin;
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Amount to WithDraw: ");
        float amount = sc.nextFloat();
        try {
            if (Balance >= amount) {
                transaction++;
                Balance -= amount;
                System.out.println("\nWithDraw Successfully!!!! ");
                String str = amount + " Rs WithDrawn by You\n";
                TransactionHistory = TransactionHistory.concat(str);
            } else {
                System.out.println("\nInsufficient Balance for Withdrawnment\n");
            }
        } catch (Exception e) {
        }
    }

    public void Deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the Amount you want to Deposit: ");
        float Amount = sc.nextFloat();
        try {
            if (Amount <= 1000000f) {
                transaction++;
                Balance += Amount;
                System.out.println("\nYour Amount is Successfully Deposited\n");
                String str = Amount + " Rs Deposited By You \n";
                TransactionHistory = TransactionHistory.concat(str);
            } else {
                System.out.println("\nSorry, The Limit is 100000000.00");
            }
        } catch (Exception e) {
        }
    }

    public void Transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nPlease Enter the Name of the Receipent: ");
        String receipent = sc.nextLine();
        System.out.print("Please Enter the Amount to Transfer: ");
        float Amount = sc.nextFloat();
        try {
            if (Balance >= Amount) {
                if (Amount <= 500000f) {
                    transaction++;
                    Balance -= Amount;
                    System.out.println("\nAmount is Successfully Transferred to " + receipent + " Account");
                    String str = Amount + " Rs Transferred to " + receipent + "\n";
                    TransactionHistory = TransactionHistory.concat(str);
                } else {
                    System.out.println("\nSorry... Limit is 500000.00");
                }
            } else {
                System.out.println("\nBalance is Insufficent");
            }
        } catch (Exception e) {
        }
    }

    public void checkBalance() {
        System.out.println("\nAvailable Balance "  + Balance + " Rs.  \n");
    }

    public void TransHistory() {
        if (transaction == 0) {
            System.out.println("\nYour Transaction History is Empty");
        } else {
            System.out.println(TransactionHistory + "\n");
        }
    }
}

public class OnlineBankSystem {
    public static int Input(int limit) {
        int input = 0;
        boolean key = false;
        while (!key) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                key = true;
                if ((key && input > limit) || (input < 1)) {
                    System.out.println("\nChoose the Number between 1 to " + limit);
                    key = false;
                }
            } catch (Exception e) {
                System.out.println("\nEnter Only Integer Value");
                key = false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("\n******Welcome to BOI BANK******\n");
        System.out.println("1.Create Account");
        System.out.println("2.Exit \n");
        System.out.print("Please Enter your Choice: ");
        int choiceuser = Input(2);
        if (choiceuser == 1) {
            Account user = new Account();
            user.registration();
            while (true) {
                System.out.println("\n1.Login");
                System.out.println("2.Exit");
                System.out.print("\nPlease Enter your Choice: ");
                int ch = Input(2);
                if (ch == 1) {
                    if (user.login()) {
                        System.out.println("\nWelcome!!!  " + user.CustomerName );
                        boolean iscompleted = false;
                        while (!iscompleted) {
                            System.out.println("\n1.Transaction History");
                            System.out.println("2.Withdraw");
                            System.out.println("3.Deposit");
                            System.out.println("4.Transfer");
                            System.out.println("5.Check Bank Balance");
                            System.out.println("6.Exit");
                            System.out.print("\nPlease Enter your Choice: ");
                            int c = Input(6);
                            switch (c) {
                                case 1:
                                    user.TransHistory();
                                    break;
                                case 2:
                                    user.withdraw();
                                    break;
                                case 3:
                                    user.Deposit();
                                    break;
                                case 4:
                                    user.Transfer();
                                    break;
                                case 5:
                                    user.checkBalance();
                                    break;
                                case 6:
                                    iscompleted = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}