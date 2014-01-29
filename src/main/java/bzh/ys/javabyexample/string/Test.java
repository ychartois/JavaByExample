/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.string;

/**
 *
 * @author yannig
 */
public class Test {
            
    static String first_static = "first";
    String first_instance = "first";
    
    public static void main(String[] args) {
        
        System.out.println("->   Immutable:");
        String first = "first";
        first.replace("fi", "FI");
        System.out.println( first ); // <-- Still be "first" ! String is immutable
         
        System.out.println("\n->    == on String");
        String first_2 = "first";
        System.out.println( first == first_2 ); // <-- What? it get the same object from the String pool :)
        System.out.println( first == first_static ); // <-- Same ;) 
        System.out.println( first == new Test().first_instance ); // <-- Still the same ;)
        
        System.out.println("\n->    == on String but with new String constructor");
        String first_3 = new String("first");
        String first_4 = new String("first");
        System.out.println( first == first_3 );
        System.out.println( first_4 == first_3 );
        
        // It's mean: NEVER DO THAT, ALWAYS use equals !!!!
        System.out.println("\n->    == on String with all the definition");
        System.out.println( first.equals(first_2));
        System.out.println( first.equals(first_static));
        System.out.println( first.equals(first_3));
        System.out.println( first_4.equals(first_3));
    }
    
}
