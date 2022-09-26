public class Student<T> {
    private T first;
    private T last;
    public Student(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        first = clazz.newInstance();
        last = clazz.newInstance();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Student<String> student = new Student<>(String.class);
        System.out.println("@@@@@");
        System.out.println(student.first);
    }
}
