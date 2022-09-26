import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestMain {
    public static void main(String[] args) {
        IntPair intPair = new IntPair(1, 2);
        System.out.println(intPair.getFirst());
        System.out.println(intPair.getLast());

        Class<IntPair> clazz = IntPair.class;
        Type t = clazz.getGenericSuperclass();
        if ( t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            Type[] types = pt.getActualTypeArguments();
            for (Type type: types
                 ) {
                Class<?> typeClass = (Class<?>) type;
                System.out.println(typeClass);
            }
        }
    }
}
