package bzh.ys.javabyexample.pattern.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description: TODO
 * <p/>
 * Date: 2014-07-23 9:39 PM
 *
 * @author yannig
 */
public class FilterExample {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        List<Date> elements = Arrays.asList( new Date[]{format.parse("10-02-1952"),format.parse("5-06-1987"),format.parse("8-07-1983")} );
        Date date = format.parse("10-3-1978");

        System.out.println( elements );

        elements = elements.stream().filter( e -> e.after(date)).collect(Collectors.toList());

        System.out.println( elements );
    }

}
