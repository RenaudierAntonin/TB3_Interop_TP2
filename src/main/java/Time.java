import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Time {


    public static Instant parseDatetimestamps(String literal) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
        Date date = formatter.parse(literal);
        Instant instant =date.toInstant();
        return instant;
    };

    public static String serializeDatetimestamps(Instant instant) {
        return(instant.toString());
    };

    public static void main(String args[]) throws ParseException{
        System.out.println(parseDatetimestamps("2018-09-18T23:42:00+0500"));
        System.out.println(serializeDatetimestamps(parseDatetimestamps("2018-07-18T23:42:00-0300")));
    }
}
