public class SeniorStudent extends Student{

    private String school;
    public String area;

    public SeniorStudent(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    @Override
    public void hello() {
        System.out.println("I am a senior student");
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
