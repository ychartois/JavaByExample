/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.language.generic;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author yannig
 */
public class Generic {

    public <E> String reduce( List<E> list ) {
        String result = "";
        for ( E element : list) {
            result += element.toString();
        }
        return result;
    }

    public String reduce2( List<? extends Integer> list ) {
        String result = "";
        for ( Number element : list) {
            result += element.toString();
        }
        return result;
    }

    public <E1,E2> int total( List<E1> list1, List<E2> list2 ) {
        return list1.size() + list2.size();
    }


    public static void main(String[] args) {
        List<String> list = Arrays.asList( new String[] {"a", "b", "c"});
        System.out.println( new Generic().reduce(list));

        List<Integer> list2 = Arrays.asList( new Integer[] {1, 2, 3});
        System.out.println( new Generic().reduce(list2));

        System.out.println( new Generic().total(list, list));
        System.out.println( new Generic().total(list, list2));

        Number[] array = new Integer[] {1, 2, 3};
    }
}
