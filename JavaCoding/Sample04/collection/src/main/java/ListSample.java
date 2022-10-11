import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListSample {
    public static void main(String[] args) {
        System.out.println("😊");
        List<Double> list0 = List.of(1.0, 2.0, 3.0);
        for (Double d : list0) {
            System.out.println(d);
        }

        Object[] array = list0.toArray();
        System.out.println(Arrays.toString(array));

        Double[] doubles = list0.toArray(Double[]::new);
        System.out.println(Arrays.toString(doubles));

        List<Double> list1 = List.of(doubles);
        List<Double> list2 = Arrays.asList(doubles);

        for (Double d: list1
             ) {
            System.out.println(d);
        }

        // UnsupportedOperationException
        // list2.add(4.0);

        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list);
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");

    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        for (Integer i: list
             ) {
            if (i != start) {
                break;
            }
            start++;
        }
        return start;
    }
}
