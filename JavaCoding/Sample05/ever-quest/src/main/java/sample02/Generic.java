package sample02;

public class Generic<T> {
    private final T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public static void main(String[] args) {
        Generic<String> generic = new Generic<>("樂");
        System.out.println(generic.getKey());
    }
}
