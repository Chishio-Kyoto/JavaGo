public class Sample09 extends Sample08{
    private int height;

    public Sample09(String name, int age, int height) {
        super(name, age);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String getSample() {
        System.out.println(super.getSample());
        return sample + " hello";
    }

    public static void main(String[] args) {
        Sample09 sample09 = new Sample09("樂",30,172);
        System.out.println(sample09.getHeight());
        System.out.println(sample09.getName());
        sample09.setSample("Sample");
        System.out.println(sample09.getSample());
    }
}
