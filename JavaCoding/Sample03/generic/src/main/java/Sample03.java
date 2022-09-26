import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Sample03 {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(3);
        int r1 = sumOfList(l1);
        System.out.println(r1);
        int r2 = sumOfList2(l1);
        System.out.println(r2);
    }

    static int sumOfList(List<? extends Integer> list) {
        int sum = 0;
        // list.add(12);  // 编译错误
        for (Integer n : list) {
            sum = sum + n;
        }
        return sum;
    }

    static int sumOfList2(List<Integer> list) {
        int sum = 0;
        list.add(12);
        for (Integer n : list) {
            sum = sum + n;
        }
        return sum;
    }

    static int sumOfList3(List<? super Integer> list) {
        int sum = 0;
        /**
         * 编译错误: Integer i = list.get(0);
        for (Integer n : list) {
            sum = sum + n;
        }
        */
        return sum;
    }
}
