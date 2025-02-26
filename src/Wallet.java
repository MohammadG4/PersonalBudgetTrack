public class Wallet {
    private int id;
    private String walletName;
    private double share = 0;
    private double balance;

    public Wallet(int id,String walletName, double share) {
        this.id = id;
        this.walletName = walletName;
        this.share = share;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getWalletName() {

        return walletName;
    }

    public void setWalletName(String walletName) {

        this.walletName = walletName;
    }

    public double getShare() {

        return share;
    }

    public void setShare(double share) {

        this.share = share;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
