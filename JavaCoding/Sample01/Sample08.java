public class Sample08 implements Cloneable{

    private String name;
    private int age;
    protected String sample;

    public Sample08() {
    }

    public Sample08(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    protected String getSample() {
        return sample;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Object o1 = new Object();
        Object o2 = new Object();
        Sample08 sample08 = new Sample08();
        System.out.println(o1.getClass());  // java.lang.Object
        System.out.println(o1.equals(o2));  // false
        System.out.println(o1.hashCode());  // 1809787067
        System.out.println(o1.toString());  // java.lang.Object@6bdf28bb

        sample08.setName("樂");
        sample08.setAge(30);
        Sample08 sample08_ = (Sample08) sample08.clone();
        System.out.println(sample08.getClass());  // Sample08
        System.out.println(sample08.equals(sample08_));  // false
        System.out.println(sample08.hashCode());  // 1802598046
        System.out.println(sample08.toString());  // Sample08@6b71769e
    }
}
