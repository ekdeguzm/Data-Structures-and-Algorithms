
public class Receipt {

    private Store store;
    private int numberOfItems;
    private double total;
    private String receiptID;

    public Receipt(Store store, int numberOfItems, double total, String receiptID) {
        this.store = store;
        this.numberOfItems = numberOfItems;
        this.total = total;
        this.receiptID = receiptID;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    @Override
    public String toString() {
        return "Receipt ID: " + receiptID + "\nStore: " + store + "\nNumber of Items: " + numberOfItems + 
               "\nTotal: $" + total;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Receipt) {
            Receipt other = (Receipt) obj;
            return this.store.equals(other.store) &&
                   this.numberOfItems == other.numberOfItems &&
                   Double.compare(this.total, other.total) == 0 &&
                   this.receiptID.equals(other.receiptID);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(store, numberOfItems, total, receiptID);
    }
}