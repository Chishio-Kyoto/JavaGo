package interfaces;

public interface Common {
    void reading();
    void running();
    boolean eating(String foodType);

    default void fucking() {
        System.out.println("I want to fucking");
    }
}
