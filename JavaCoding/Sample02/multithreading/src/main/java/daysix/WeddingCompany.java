package daysix;

public class WeddingCompany implements Marry{

    private final Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("安排婚后洞房");
    }

    private void before() {
        System.out.println("安排婚前体检～");
    }
}
