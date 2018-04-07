public class Item {

    private String name;
    private double price;
    private boolean onBOGOF;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.onBOGOF = false;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

//    public double getBOGOFPrice()

    public boolean isOnBOGOF() {
        return onBOGOF;
    }

    public void setOnBOGOF(boolean onBOGOF) {
        this.onBOGOF = onBOGOF;
    }
}
