/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.language.equals;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author yannig
 */
public class Test {
    
    public static void main(String[] args) {
        String[] s1 = new String[] {"0", "1", "2"};
        String[] s2 = new String[] {"0", "1", "2"};
        
        System.out.println("With arrays:");
        System.out.println( s1 == s2 );
        System.out.println( s1.equals(s2) ); // <-- bad implementation for Arrays...
        System.out.println( Arrays.equals(s1, s2) ); // <-- but you can use Arrays.equals(..)
        
        System.out.println("With lists:\n");
        List<String> l1 = Arrays.asList( new String[] {"0", "1", "2"} );
        List<String> l2 = Arrays.asList( new String[] {"0", "1", "2"} );
        System.out.println( l1 == l2 );
        System.out.println( l1.equals(l2) ); // <-- works fine for List if the list elements implements equals
    }
    
}
