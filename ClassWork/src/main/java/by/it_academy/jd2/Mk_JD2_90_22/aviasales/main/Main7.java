package by.it_academy.jd2.Mk_JD2_90_22.aviasales.main;


import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

public class Main7 {
    public static void main(String[] args) {
        Date d = new Date();

        System.out.println(d);

        TimeZone aDefault = TimeZone.getDefault();

        System.out.println(aDefault);

        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Tokyo"));

        System.out.println(d);
    }
}
