package daysix;

public class ClassChange {
    public static void main(String[] args) {

        // 4、局部内部类
        class PartLike implements ILike {
            @Override
            public void lambda() {
                System.out.println("I like lambda 4 ~~");
            }
        }

        // 5、匿名内部类
        ILike like4 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda 5 ~~");
            }
        };

        // 6.lambda表达式简化
        ILike like5 = () -> System.out.println("I like lambda 6 ~~");

        ILike like1 = new Like();
        like1.lambda();

        ILike like2 = new StaticLike();
        like2.lambda();

        ILike like3 = new PartLike();
        like3.lambda();

        like4.lambda();

        like5.lambda();
    }

    // 3、静态内部类
    static class StaticLike implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like lambda 3 ~~");
        }
    }
}

// 1、定义一个函数式接口
interface ILike {
    void lambda();
}

// 2、实现类
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("I like lambda 2 ~~");
    }
}