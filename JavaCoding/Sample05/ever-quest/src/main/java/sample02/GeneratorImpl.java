package sample02;

public class GeneratorImpl<T> implements Generator<String> {
    @Override
    public String method() {
        return "樂";
    }

    public static <E> void printArray(E[] inputArray) {
        for (E element: inputArray
             ) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Generator<String> generator = new GeneratorImpl<>();
        System.out.println(generator.method());

        Integer[] integers = {1, 2, 3};
        String[] strings = {"樂", "苦"};
        printArray(integers);
        printArray(strings);
    }
}
