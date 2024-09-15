
public class Trio<T> {

    private T item1, item2, item3;

    public Trio(T item1, T item2, T item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;

    }

    public Trio(T item) {
        this(item, item, item);
    }

    public T getItem1() {
        return item1;
    }

    public T getItem2() {
        return item2;
    }

    public T getItem3() {
        return item3;
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public void setItem2(T item2) {
        this.item2 = item2;
    }

    public void setItem3(T item3) {
        this.item3 = item3;
    }

    public void replaceAll(T item) {
        this.item1 = item;
        this.item2 = item;
        this.item3 = item;
    }

    @Override
    public String toString() {
        return String.format(
                "Trio:\n" +
                        "  Item 1: %s\n" +
                        "  Item 2: %s\n" +
                        "  Item 3: %s",
                item1, item2, item3);
    }

}
