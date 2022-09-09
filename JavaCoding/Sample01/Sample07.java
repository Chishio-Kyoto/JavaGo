import java.util.HashMap;

public class Sample07 {

    public static void main(String[] args) {
        OuterClass outer = new OuterClass("Nested");
        outer.asyncHello();

        // 对象创建
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("hole", "good");
        // 匿名类实例，只是该匿名类继承自HashMap
        HashMap<String, String> map2 = new HashMap<>() {};
        // 匿名类实例，并且添加了static代码块来初始化数据
        HashMap<String, String> map3 = new HashMap<>() {
            {
                put("A", "1");
                put("B", "2");
            }
        };
        System.out.println(map1.size());
        System.out.println(map2.size());
        System.out.println(map3.get("A"));

        StaticOuterClass.StaticNested sn = new StaticOuterClass.StaticNested();
        sn.hello();
    }
}

class OuterClass {
    private String name;

    OuterClass(String name) {
        this.name = name;
    }

    void asyncHello() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, " + OuterClass.this.name);
            }
        };
        new Thread(r).start();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class StaticOuterClass {
    private static final String NAME = "OUTER";

    private String name;

    StaticOuterClass(String name) {
        this.name = name;
    }

    static class StaticNested {
        void hello() {
            System.out.println("Hello, " + StaticOuterClass.NAME);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
