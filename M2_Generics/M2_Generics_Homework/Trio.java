
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

    public boolean hasDuplicates() {
        return (item1.equals(item2) || item1.equals(item3) ||
                item2.equals(item3));
    }

    public int count(T item) {
        int count = 0;
        if (item.equals(item1)) {
            count += 1;
        }
        if (item.equals(item2)) {
            count += 1;
        }
        if (item.equals(item3)) {
            count += 1;
        }
        return count;
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

    @Override
    public boolean equals(Object obj) {
        // Check if the object is the same instance
        if (this == obj) {
            return true;
        }

        // Check if the object is of the correct type,
        if (!(obj instanceof Trio<?>)) {
            return false;
        }

        // Cast the object to Trio<T>
        Trio<?> other = (Trio<?>) obj;

        // Check if all items in both Trio instances are equivalent
        return (item1.equals(other.item1) || item1.equals(other.item2) || item1.equals(other.item3)) &&
                (item2.equals(other.item1) || item2.equals(other.item2) || item2.equals(other.item3)) &&
                (item3.equals(other.item1) || item3.equals(other.item2) || item3.equals(other.item3));
    }

}
