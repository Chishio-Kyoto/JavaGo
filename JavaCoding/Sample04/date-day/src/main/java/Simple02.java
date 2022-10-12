import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Simple02 {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();  // 当前日期
        LocalTime t = LocalTime.now();  // 当前时间
        LocalDateTime dt = LocalDateTime.now();  // 当前日期和时间
        // 严格按照ISO 8601格式打印
        System.out.println(d);
        System.out.println(t);
        System.out.println(dt);

        LocalDateTime dt1 = LocalDateTime.now(); // 当前日期和时间
        LocalDate d1 = dt1.toLocalDate(); // 转换到当前日期
        LocalTime t1 = dt1.toLocalTime(); // 转换到当前时间

        // 指定日期和时间:
        LocalDate d2 = LocalDate.of(2019, 11, 30); // 2019-11-30, 注意11=11月
        LocalTime t2 = LocalTime.of(15, 16, 17); // 15:16:17
        LocalDateTime dt2 = LocalDateTime.of(2019, 11, 30, 15, 16, 17);
        LocalDateTime dt3 = LocalDateTime.of(d2, t2);

        LocalDateTime dt4 = LocalDateTime.parse("2019-11-19T15:16:17");
        LocalDate d3 = LocalDate.parse("2019-11-19");
        LocalTime t4 = LocalTime.parse("15:16:17");
    }
}
