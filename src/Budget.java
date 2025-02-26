import java.util.ArrayList;

public class Budget {
    private ArrayList<Wallet> wallets;
    private double mainBalance = 0;






    public Budget() {
        wallets =new ArrayList<>();
    }

    public void resetBudget() {
        wallets =new ArrayList<>();
    }
    public void addWallet(Wallet wallet) {
        wallets.add(wallet);
    }
    public void removeWallet(Wallet wallet) {
        wallets.remove(wallet);
    }


    public Wallet getWallet(int id) {
        for (Wallet wallet : wallets) {
            if (wallet.getId() == id) {
                return wallet;
            }
        }
        return null;
    }

    public void displayWallets() {
        System.out.println("+------------------------------------------+");
        System.out.printf("| Main Balance: %-26.2f |\n", mainBalance);
        System.out.println("+----+----------------+---------+-----------+");
        System.out.println("| ID | Wallet Name    | Share   | Balance   |");
        System.out.println("+----+----------------+---------+-----------+");

        for (Wallet wallet : wallets) {
            System.out.printf("| %-2d | %-14s | %6.1f%% | %-9.2f |\n",
                    wallet.getId(), wallet.getWalletName(), wallet.getShare(), wallet.getBalance());
        }

        System.out.println("+----+----------------+---------+-----------+");
    }


    public double getMainBalance() {
        return mainBalance;
    }

    public void setMainBalance(double mainBalance) {

        this.mainBalance += mainBalance;
        for (Wallet wallet : wallets) {
            calculateBalanceForWallet(wallet);
        }

    }



    public void calculateBalanceForWallet(Wallet wallet) {
        wallet.setBalance((wallet.getShare()/100) * mainBalance);
    }

    public double shareSum() {
        double sum = 0;
        for (Wallet wallet : wallets) {
            sum += wallet.getShare();
        }
        return sum;
    }

    public void minusShare(double share) {
        share /= wallets.size();
        for (Wallet wallet : wallets) {
            wallet.setShare(wallet.getShare() - share);
        }
    }

    public void handleShares() {
        for (Wallet wallet : wallets) {
            if (wallet.getShare() <0) {
                wallet.setShare(0);
            }
        }
    }
}
