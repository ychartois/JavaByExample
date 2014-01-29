/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.passbyvalue;

/**
 *
 * @author yannig
 */
public class A {

    int a = 1;
    int b = 2;
    
    void swapValue( int a, int b ){
        int x = a;
        a = b;
        b = x;
    }
    
    void swapValue( B swap ){
        int x = swap.a;
        swap.a = swap.b;
        swap.b = x;
    }
    
    void swapValueAndErase( B swap ){
        // swap
        swapValue(swap);
        
        // and erase
        swap = new B(); // <-- create a new ref, but the object is already modified !
    }
    
    B swapValueAndEraseForReal( B swap ){
        // swap
        swapValue(swap);
        
        // and erase
        swap = new B(); // <-- create a new ref, but the object is already modified !
        
        return swap;
    }
    
    public static void main(String[] args) {
        // swap primitive
        A test = new A();
        test.swapValue( test.a, test.b);
        System.out.println("a: " + test.a + ", b: " + test.b);
        
        // swap object
        B test2 = new B();
        test.swapValue( test2 );
        System.out.println( test2 );
        
        // swap and erase Object
        B test3 = new B();
        test.swapValueAndErase( test3 );
        System.out.println( test3 );
        
        // swap and erase Object for real
        B test4 = new B();
        test4 = test.swapValueAndEraseForReal( test4 );
        System.out.println( test4 );
        
        System.gc();
        
    }
}
