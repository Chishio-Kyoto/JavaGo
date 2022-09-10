public class Sample03 {

    public static void main(String[] args) throws Exception {
        String s1 = null;
        // java.lang.NullPointerException
        // process2(s1);
        // java.lang.IllegalArgumentException
        // process1(s1);

        /**
        try {
            process1(s1);
        } catch (Exception e) {
            e.printStackTrace();
        }
         */

        Exception origin = null;
        try {
            process1(s1);
        } catch (Exception e) {
            origin = e;
            throw e;
        } finally {
            Exception e = new IllegalAccessException();
            if (origin != null) {
                e.addSuppressed(origin);
            }
            throw e;
        }
    }

    static void process1(String s) {
        // 异常类型"转换"，抛出java.lang.IllegalArgumentException
        try {
            process2(s);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static void process2(String s) {
        if (s==null) {
            throw new NullPointerException();
        }
    }
}
