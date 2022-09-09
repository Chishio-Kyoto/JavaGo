public class Outer {
    public static void main(String[] args) {
        OuterTest outerTest = new OuterTest("Nested");
        OuterTest.Inner inner = outerTest.new Inner();
        inner.hello();
    }
}

class OuterTest {
    private String name;
    OuterTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    class Inner {
        void hello() {
            System.out.println("Hello~");
        }
    }
}

