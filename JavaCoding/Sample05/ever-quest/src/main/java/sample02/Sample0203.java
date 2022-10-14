package sample02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Sample0203 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // Class clazz = String.class;
        // String str = (String) clazz.newInstance();

        Class<String> clazz = String.class;
        String str = clazz.newInstance();

        Class<? super String> sup = String.class.getSuperclass();

        Class<Integer> clazz1 = Integer.class;
        Constructor<Integer> cons = clazz1.getConstructor(int.class);
        Integer i = cons.newInstance(123);

        Pair<String>[] ps = null;
        // compile error!
        // Pair<String>[] ps2 = new Pair<String>[2];
        @SuppressWarnings("unchecked")
        Pair<String>[] ps2 = (Pair<String>[]) new Pair[2];
    }
}
