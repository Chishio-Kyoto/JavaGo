import interfaces.Common;

public class Sample06 implements Common {

    @Override
    public void reading() {
        System.out.println("reading a book");
    }

    @Override
    public void running() {
        System.out.println("i can running");
    }

    @Override
    public boolean eating(String foodType) {
        return true;
    }

    public static void main(String[] args) {
        Common person = new Sample06();
        person.reading();
        person.fucking();
    }
}
