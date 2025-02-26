import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the budget tracker!");
        Budget myBudget = new Budget();
        int id=0;
menu1(myBudget,id);
    }
    public static void menu1(Budget myBudget,int id) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your options:");
            System.out.println("1. Create Budget");
            System.out.println("2. Add to Balance");
            System.out.println("3. Display Budget");
            System.out.println("4. Add Wallet");
            System.out.println("5. Edit Wallet");
            System.out.println("6. Delete Wallet");
            System.out.println("7. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1 -> {
                    id=0;
                    myBudget.resetBudget();
                    System.out.println("Enter balance: ");
                    double balance = sc.nextDouble();
                    myBudget.setMainBalance(balance);
                    System.out.println("How many wallets would you like to add? ");
                    int num = sc.nextInt();
                    double sumShare = 0;


                    for (int i = 0; i < num; i++) {
                        id++;
                        sc.nextLine();
                        System.out.println("Enter wallet name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter share: ");
                        double share = sc.nextDouble();

                        Wallet wallet = new Wallet(id,name,share);
                        myBudget.calculateBalanceForWallet(wallet);
                        myBudget.addWallet(wallet);
                        sumShare += share;
                    }
                    if (sumShare > 100) {
                        System.out.println("Your budget is over 100%\nProcess Failed!\n");
                        myBudget.resetBudget();
                    }

                }

                //add to balance
                case 2 -> {
                    while(true) {
                        System.out.println("Enter the balance you would like to add: ");
                        double balance = sc.nextDouble();
                        if (balance > 0.0) {
                        myBudget.setMainBalance(balance);
                            break;
                        }
                        else {
                            System.out.println("Invalid Balance");

                        }

                }

                }


                case 3 -> {
                    myBudget.displayWallets();
                }


                case 4 -> {
                    sc.nextLine();
                    System.out.println("WARNING!! If you added a wallet, all wallets' share could be modified.");
                    System.out.println("Do you want to add another wallet? (y/n).");
                    String add = sc.nextLine();
                    if (add.toLowerCase().equals("y")) {
                        System.out.println("Enter new wallet name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter its share: ");
                        double share = sc.nextDouble();
                        while (share+ myBudget.shareSum() > 100 ) {
                            myBudget.minusShare((myBudget.shareSum()+share)-100);
                            myBudget.handleShares();
                        }
                            System.out.println("Your Wallets' share got Modified");
                        id++;
                        myBudget.addWallet(new Wallet(id,name,share));
                        myBudget.setMainBalance(0);
                    }
                    else {
                        System.out.println("Nothing is modified");
                        break;

                    }

                }
                case 5 -> {
                    sc.nextLine();
                    System.out.println("WARNING!! If you edited a wallet, all wallets' share could be modified.");
                    System.out.println("Do you want to edit a wallet? (y/n).");
                    String edit = sc.nextLine();
                    if (edit.toLowerCase().equals("y")) {
                        System.out.println("Enter new wallet's id: ");
                        int walletId = sc.nextInt();
                        Wallet editWallet =myBudget.getWallet(walletId);
                        String walletName = editWallet.getWalletName();
                        myBudget.removeWallet(editWallet);
                        System.out.println("Enter its share: ");
                        double share = sc.nextDouble();
                        while (share+ myBudget.shareSum() > 100 ) {
                            myBudget.minusShare((myBudget.shareSum()+share)-100);
                        myBudget.handleShares();
                        }
                            System.out.println("Your Wallets' share got Modified");
                        myBudget.addWallet(new Wallet(walletId,walletName,share));
                        myBudget.setMainBalance(0);
                    }
                    else {
                        System.out.println("Nothing is modified");
                    }


                }
                case 6 -> {
                    sc.nextLine();
                    myBudget.displayWallets();
                    System.out.println("Enter the wallet ID you would like to remove: ");
                    int walletId = sc.nextInt();
                    Wallet wallet = myBudget.getWallet(walletId);
                    myBudget.removeWallet(wallet);
                    System.out.println("Wallet "+walletId+" removed");
                }
                case 7 -> {
                    System.exit(0);
                }


            }
        }
    }
}