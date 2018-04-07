public class Customer {

    private String name;
    private boolean hasLoyaltyCard;
    private double walletValue;

    public Customer(String name, boolean hasLoyaltyCard, double walletValue) {
        this.name = name;
        this.hasLoyaltyCard = hasLoyaltyCard;
        this.walletValue = walletValue;
    }

    public String getName() {
        return name;
    }

    public boolean hasLoyaltyCard() {
        return hasLoyaltyCard;
    }

    public double getWalletValue() {
        return walletValue;
    }

    public void reduceWalletValue(double itemPrice) {
        this.walletValue -= itemPrice;
    }
}
