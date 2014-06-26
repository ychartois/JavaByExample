/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.language.collection;

import bzh.ys.javabyexample.language.clone.NoneCloneable;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author yannig
 */
public class Collection implements Cloneable {

    List vector = new Vector(); // Java 1.4
    List<String> arrayList = new ArrayList<String>(); // Java 1.5

    Map hashTable = new Hashtable(); // Java 1.4
    Map<String, String> hashMap = new HashMap<String, String>(); // Java 1.5


    public static void main(String[] args) throws CloneNotSupportedException {
        Collection collection = new Collection();

        System.out.println("=============> non generic code loop"); // Java 1.4
        Iterator iterator = collection.vector.iterator();
        while ( iterator.hasNext() ) {
            String next = (String) iterator.next();
            // operation on List
        }

        System.out.println("=============> generic code loop"); // Java 1.5
        for ( String element : collection.arrayList ) {
            // operation on List
        }

        System.out.println("=============> generic code loop"); // Java 1.8
        collection.arrayList.stream().forEach( element -> {
                //operation on List
        });


        // Init of arrayList is 16 elements if not init
        // collection.arrayList has 16 elements !
        // But of course:
        System.out.println("Size is 0:" + collection.arrayList.size()); // Java 1.5

        // You know that you have 20 000 elements to store
        // arraylist will store 16 elements
        // at the 17th element it will create an array of N*2
        // arraylist will have 32 elements
        // 64
        // 128
        // every times, you get a System.arraycopy() !!!

        // to avoid that
        List<String> optimizedList = new ArrayList<>(20000);


        System.out.println("=============> algo map");
        List<String> list = Arrays.asList(new String[]{"a", "b", "c"}) ;

        // Algo in 1.7
        List<String> newList = new ArrayList<>( list.size() );
        for ( String element : list ) {
            newList.add( element.toUpperCase() );
        }
        System.out.println( newList );

        // Same in 1.8
        List<String> newList2 = list.stream()
                .map(element -> element.toUpperCase())
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println( newList2 );


        System.out.println("=============> algo map and filter");
        List<String> listAlgo2 = Arrays.asList(new String[]{"a", "b", "c"}) ;

        // Algo in 1.7
        List<String> newListAlgo2 = new ArrayList<>( list.size() );
        for ( String element : list ) {
            if ( element != "b" ) {
                newListAlgo2.add(element.toUpperCase());
            }
        }
        System.out.println( newListAlgo2 );

        // Same in 1.8
        List<String> newList2Algo2 = list.stream()
                .filter( element -> element != "b")
                .map(element -> element.toUpperCase())
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println( newList2Algo2 );

        System.out.println("=============> List and Set");

        // list element are not unique
        List notUniqueElement = new ArrayList<>();
        notUniqueElement.add("a");
        notUniqueElement.add("a");
        notUniqueElement.add("a");
        System.out.println(notUniqueElement);

        // set element are unique
        Set uniqueElement = new HashSet<>();
        uniqueElement.add("a");
        uniqueElement.add("a");
        uniqueElement.add("a");
        System.out.println(uniqueElement);

        System.out.println("=============> Queue");
        // Make a Queue
        Deque<String> linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        System.out.println("I want the first element: " + linkedList.getFirst());






    }
}
