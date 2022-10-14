package sample01;

import Sample.Person;

public class Sample0102 {
    public static void main(String[] args) {
        Person person1 = new Person("樂");
        Person person2 = new Person("苦");
        System.out.println("person1 : " + person1.getName());
        System.out.println("person2 : " + person2.getName());
        swap(person1, person2);
        System.out.println("person1 : " + person1.getName());
        System.out.println("person2 : " + person2.getName());
    }

    private static void swap(Person person1, Person person2) {
        Person temp = person1;
        person1 = person2;
        person2 = temp;
        System.out.println("@@@ person1 : " + person1.getName());
        System.out.println("@@@ person2 : " + person2.getName());
    }
}
