import java.security.PublicKey;

public class Person {
    private static final int CURRENT_YEAR = 2022;
    private String name;
    private int age;
    private int birth;
    private String[] profession;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String[] profession) {
        this(name, age);
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name.strip();  // 去掉首尾空格
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public String[] getProfession() {
        return profession;
    }

    public void setProfession(String[] profession) {
        this.profession = profession;
    }

    private int calcAge(int currentYear) {
        return currentYear - this.birth;
    }

    public int getCalcAge() {
        return calcAge(CURRENT_YEAR);
    }
}
