public class Student extends Person{
    private int score;

    public Student(String name, int age, int score) {
        super(name, age);  // 如果不写，子类对象获取父类字段的值时为null
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
