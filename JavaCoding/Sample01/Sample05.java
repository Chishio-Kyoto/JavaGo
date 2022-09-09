public class Sample05 {
    public static void main(String[] args) {
        Person p1 = new Person("後樂", 30, new String[]{"Programmer", "Photographer"});
        System.out.println(p1.getName() + " " +p1.getAge());

        Student s = new Student("Hole", 12, 89);
        System.out.println(s.getName());  // Hole
        System.out.println(s.getScore());  // 89

        // 多态
        Income[] incomes = new Income[] {
                new Income(3000),
                new Salary(7500),
                new StateCouncilSpecialAllowance(15000)
        };
        System.out.println(totalTax(incomes));

        System.out.println(test01("I", "Love", "You"));

        // 向上转型、向下转型
        Person person = new Student("A", 20, 99);
        System.out.println(person.getName());

        Student student = new Student("A", 20, 99);
        System.out.println(student.getName());

        Person person1 = new Person();
        // java.lang.ClassCastException
        // Student student1 = (Student) person1;
        if (person1 instanceof Student) {
            Student student1 = (Student) person1;
            System.out.println(student1.getName());
        }

    }

    public static double totalTax(Income... incomes) {
        double total = 0;
        for (Income income : incomes) {
            total = total + income.getTax();
        }
        return total;
    }

    public static String test01(String... str) {
        String result = "";
        for (String s : str
             ) {
            result = result.concat(s);
        }
        return result;
    }
}
