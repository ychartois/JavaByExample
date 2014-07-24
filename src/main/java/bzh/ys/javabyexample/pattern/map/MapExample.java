package bzh.ys.javabyexample.pattern.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description: TODO
 * <p/>
 * Date: 2014-07-23 9:39 PM
 *
 * @author yannig
 */
public class MapExample {

    private <R,T> List<R> map2( Iterator<T> it, Function<T, R> func ) {

        List<R> ret = new ArrayList<>();
        while ( it.hasNext() ) {
            T node = it.next();
            R transformed = func.apply( node );
            ret.add( transformed );
        }
        return ret;
    }

    private static String oldSchool( List<String> list ) {
        String result= "";

        for( String el : list ) {
            if ( !el.equals("Z") ) {
                result += el.toLowerCase();
            }
        }

        return result;
    }

    private static String newSchool( List<String> list) {
        return list.stream()
                .filter(el -> !el.equals("Z"))
                .map(String::toLowerCase)
                .collect(Collectors.joining(""));
    }
    // Javascript version :
    //        elements
//                .filter(function(el){
//                    return el !== "Z";
//                })
//                .map(function(el){
//                    return el.toLowerCase();
//                })
//                .join('');

    public static void main(String[] args) {
        List<String> elements = Arrays.asList( new String[]{"C","Z","Z","O","U","Z","C", "O", "Z", "U"} );

        System.out.println( oldSchool(elements) );

        System.out.println( newSchool(elements) );
    }

}
