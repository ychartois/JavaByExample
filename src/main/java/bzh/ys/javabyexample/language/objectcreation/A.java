/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.language.objectcreation;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author yannig
 */
public class A {

    // Constante
    static final String CONSTANTE;
    
    // class variables
    static private int as = 1;
    
    // Block static
    static {
        Date now = new Date();
        SimpleDateFormat pattern = new SimpleDateFormat("dd-MM-yyyy");
        CONSTANTE = "constante " + pattern.format(now);
    }
    
    // instance variables
    private int a;
    private B b;
    private String c;
    
    // Constructor
    public A() {
        super();
    }
    
    // tests
    public static void main(String[] args) {
        
        System.out.println( A.as ); // <- Doesn't need an instance ;)
        
        A test = new A();
        System.out.println( test.a );
        System.out.println( test.b );
        System.out.println( test.c );
        
        System.out.println( test.as ); // <-- Never do that !
        System.out.println( A.as ); // <- Better !!
        System.out.println( as ); // <- Works too !!
        
        // Static is share between instance
        A inst1 = new A();
        System.out.println( inst1.as );
        System.out.println( A.as );
        
        A inst2 = new A();
        System.out.println( inst2.as );
        
        inst1.as = 10;
        System.out.println( inst1.as );
        System.out.println( inst2.as );
        
        // initialisation with static block
        System.out.println( CONSTANTE );
        
        
    }
    
    
}
