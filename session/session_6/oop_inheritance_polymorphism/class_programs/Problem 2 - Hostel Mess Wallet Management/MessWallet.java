public class MessWallet {
    private double balance;

    public MessWallet(double balance) {
        if (balance < 0) {
            System.out.println("Warning: Negative opening balance. Setting to 0.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid top-up amount.");
        } else {
            this.balance += amount;
            System.out.println("Balance after top-up: " + this.balance);
        }
    }

    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
