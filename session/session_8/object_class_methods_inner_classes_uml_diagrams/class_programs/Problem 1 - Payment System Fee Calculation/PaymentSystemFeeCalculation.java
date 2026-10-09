abstract class Payment {
    double amount;
    public Payment(double amount) { this.amount = amount; }
    abstract double getAdjustedAmount();
    abstract String getType();
}
class CardPayment extends Payment {
    public CardPayment(double amount) { super(amount); }
    double getAdjustedAmount() { return amount + amount * 0.02; }
    String getType() { return "CARD"; }
}
class WalletPayment extends Payment {
    public WalletPayment(double amount) { super(amount); }
    double getAdjustedAmount() { return amount + amount * 0.01; }
    String getType() { return "WALLET"; }
}
class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) { super(amount); }
    double getAdjustedAmount() { return amount; }
    String getType() { return "BANKTRANSFER"; }
}
public class PaymentSystemFeeCalculation {
    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(1000),
            new WalletPayment(500),
            new BankTransferPayment(2000)
        };
        double total = 0;
        for (Payment p : payments) {
            double adjusted = p.getAdjustedAmount();
            total += adjusted;
            System.out.printf("%s: %.2f\n", p.getType(), adjusted);
        }
        System.out.printf("Total: %.2f\n", total);
    }
}
