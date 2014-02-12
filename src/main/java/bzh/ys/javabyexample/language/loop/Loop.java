/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.language.loop;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author yannig
 */
public class Loop {
    
    static final List<String> test;
    
    static {
        test = new ArrayList();
        test.add("foo");
        test.add("bar");
    }
    
    public static void whileLoop() {
        // Old style
        Iterator<String> it = test.iterator();
        while (it.hasNext()) {
            String val = it.next();
            System.out.println(val);
        }
    }
    
    public static void foriLoop() {
        // For i loop
        for (int i = 0; i < test.size(); i++) {
            String val = test.get(i);
            System.out.println(val);
        }
    }
    
    public static void forEachLoop() {
        for (String val : test) {
            System.out.println(val);
        }
    }
    
    public static void forContinue() {
        
        for (String val : test) {
            if ( "foo".equals(val) ) {
                continue;
            }
            System.out.println("Continue value: " + val);
        }
        
    }
    
    public static void forBreak() {
        
        for (String val : test) {
            if ( "foo".equals(val) )
                break;
            System.out.println("Break value: " + val);
        }
        
    }
    
    public static void testEmpty() {
        
        // before java6
        if( test != null && test.size() == 0 ) {
            
        }
        
        // with java 6
        if ( test.isEmpty() ) {
            
        }
        
    }
   
    
    public static void main(String[] args) {
        whileLoop();
        foriLoop();
        forEachLoop();
        forContinue();
    }
    
    
    
}
