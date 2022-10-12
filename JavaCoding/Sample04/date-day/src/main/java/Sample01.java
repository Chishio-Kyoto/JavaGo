import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Sample01 {
    public static void main(String[] args) {
        int n = 123400;
        System.out.println(n);
        System.out.println(Integer.toHexString(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.CHINESE).format(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));

        System.out.println(System.currentTimeMillis());

        Date d1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(d1));

        // 当前时间
        Calendar c1 = Calendar.getInstance();
        // Tue Oct 11 09:38:36 CST 2022
        System.out.println(c1.getTime());
        // 清除所有
        c1.clear();
        c1.set(Calendar.YEAR, 1992);
        // 设置1月份
        c1.set(Calendar.MONTH, 0);
        c1.set(Calendar.DATE, 25);
        c1.set(Calendar.HOUR_OF_DAY, 12);
        c1.set(Calendar.MINUTE, 12);
        c1.set(Calendar.SECOND, 12);
        // 1992-01-25 12:12:12
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c1.getTime()));

        TimeZone tzDefault = TimeZone.getDefault(); // 当前时区
        TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00"); // GMT+9:00时区
        TimeZone tzNY = TimeZone.getTimeZone("America/New_York"); // 纽约时区
        System.out.println(tzDefault.getID()); // Asia/Shanghai
        System.out.println(tzGMT9.getID()); // GMT+09:00
        System.out.println(tzNY.getID()); // America/New_York

        Calendar c2 = Calendar.getInstance();
        c2.clear();
        c2.set(2019, Calendar.NOVEMBER, 20, 8, 15, 0);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat1.format(c2.getTime()));
        simpleDateFormat1.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println(simpleDateFormat1.format(c2.getTime()));

        Calendar c3 = Calendar.getInstance();
        c3.clear();
        c3.set(2019, Calendar.NOVEMBER, 20, 8, 15, 0);
        // 加5天并减去2小时:
        c3.add(Calendar.DAY_OF_MONTH, 5);
        c3.add(Calendar.HOUR_OF_DAY, -2);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat2.format(c3.getTime()));

    }
}
