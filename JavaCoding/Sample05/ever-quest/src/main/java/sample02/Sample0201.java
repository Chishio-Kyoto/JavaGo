package sample02;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Sample0201 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        // 编译期间直接添加会报错
        // list.add("a");
        Class <? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        // 运行期间通过反射添加，是可以的
        add.invoke(list, "a");
        System.out.println(list);
    }
}
