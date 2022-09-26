public class Person implements Comparable<Person>{
    String name;
    int score;

    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

    public String toString() {
        return this.name + "," + this.score;
    }
}
