public class Sample02 {
    public static void main(String[] args) {
        String ip1 = "192.122.34.123";
        String ip2 = "168.192.0.66";

        System.out.println(ip1.hashCode() % 10);
        System.out.println(ip2.hashCode() % 10);
    }
}
