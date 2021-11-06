package lesson09;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class UTCtoCurrent {
    public static void main(String[] args) throws ParseException {
//        DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
//
//        Date date = utcFormat.parse("2021-10-29T10:53:02.038Z");
//
//        DateFormat pstFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
//        pstFormat.setTimeZone(TimeZone.getDefault());
//
//        System.out.println(pstFormat.format(date));

        ZonedDateTime nowDate = ZonedDateTime.now();
        System.out.println(nowDate.getOffset());

        if(nowDate.getOffset().toString().startsWith("+")){
            nowDate.plusHours(Long.valueOf("07"));
        }


//        SimpleDateFormat browserTimezone = new SimpleDateFormat("yyyy-MM-dd");
//        browserTimezone.setTimeZone(TimeZone.getDefault());
//        nowDate = ZonedDateTime.parse(browserTimezone.format(nowDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));


    }
}
