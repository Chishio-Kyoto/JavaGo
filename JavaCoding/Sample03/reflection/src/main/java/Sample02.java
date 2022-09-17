import java.lang.reflect.*;

public class Sample02 {
    public static void main(String[] args) throws NoSuchFieldException,
            IllegalAccessException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException {
        Student student = new Student("小强",28);
        SeniorStudent seniorStudent = new SeniorStudent("小强",28, "海池高级中学");
        seniorStudent.area = "天水";
        Class stdClass = student.getClass();
        Class sStdClass = seniorStudent.getClass();

        // private java.lang.String SeniorStudent.school
        System.out.println(sStdClass.getDeclaredField("school"));

        // 访问字段
        Field f = sStdClass.getDeclaredField("school");
        System.out.println(f.getName());  // school
        System.out.println(f.getType());  // class java.lang.String
        // 返回字段的修饰符
        int m = f.getModifiers();
        System.out.println(Modifier.isPrivate(m));  // true
        // 获取字段的值
        Field f1 = sStdClass.getDeclaredField("area");
        // f1.setAccessible(true);
        Object value = f1.get(seniorStudent);
        System.out.println(value);
        f1.set(seniorStudent, "上海");
        Object value1 = f1.get(seniorStudent);
        System.out.println(value1);

        // 调用方法
        System.out.println(sStdClass.getMethod("getSchool"));  // public void SeniorStudent.getSchool()
        Method m1 = sStdClass.getMethod("getSchool");
        String s = (String) m1.invoke(seniorStudent);
        System.out.println(s);  // 海池高级中学

        // 调用构造方法
        // SeniorStudent seniorStudent1 = SeniorStudent.class.newInstance();
        Constructor constructor = SeniorStudent.class.getConstructor(String.class, int.class, String.class);
        SeniorStudent seniorStudent2 = (SeniorStudent) constructor.newInstance("搭强", 30, "德玛西亚中学");
        System.out.println(seniorStudent2.getSchool());  // 德玛西亚中学

        // 获取继承关系
        Class superClass = sStdClass.getSuperclass();
        System.out.println(superClass);  // class Student
        System.out.println(Student.class.isAssignableFrom(SeniorStudent.class));  // true

        // 动态代理：不编写实现类，直接在运行期创建某个interface的实例
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);  // public abstract void Hello.morning(java.lang.String)
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(), // 传入ClassLoader
                new Class[] { Hello.class }, // 传入要实现的接口
                handler); // 传入处理调用方法的InvocationHandler
        hello.morning("Bob");  // Good morning, Bob
    }
}
