import java.util.Arrays;

public class Sample04 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("千染");
        person.setAge(30);
        System.out.println(person.getName() + " " + person.getAge());

        int n = 15; // n的值为15
        person.setAge(n); // 传入n的值
        System.out.println(person.getAge()); // 15
        n = 20; // n的值改为20
        System.out.println(person.getAge()); // 15

        Person p1 = new Person();
        String[] profession = new String[] { "Programmer", "Photographer" };
        p1.setProfession(profession); // 传入fullName数组
        System.out.println(p1.getProfession()[0]); // "Programmer"
        profession[0] = "Data Analyst"; // profession数组的第一个元素修改为"Data Analyst"
        System.out.println(p1.getProfession()[0]); // "Data Analyst"

        Person p2 = new Person();
        String bob = "bob";
        p2.setName(bob);
        System.out.println(p2.getName());  // bob
        bob = "Alice";
        System.out.println(p2.getName());  // bob
        p2.setName(bob);
        System.out.println(p2.getName());  // Alice
    }
}
