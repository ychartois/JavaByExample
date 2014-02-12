/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.language.conversion;

/**
 *
 * @author yannig
 */
public class Test {
    
    // concat is evil in a loop !
    public static String testConcat() {
       String test = "";
        for (int i = 0; i < 10000; i++) {
            test += i; // or test.concat( Interger.toString(i) )
        } 
        
        return test;
    }
    
    public static String testBuffer() {
       StringBuilder test = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            test.append(i);
        } 
        
        return test.toString();
    }
    
    public static String testOldBuffer() {
       StringBuffer test = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            test.append(i);
        } 
        
        return test.toString();
    }
    
    public static void convertionExample() {
        int i = 10;
        
        // Bad
        String convert1 = "" + i;
        
        // Too long
        Integer j = new Integer(i); // Wrapper of int
        String convert2 = j.toString();
        
        // Use the Wrapper methods
        String convert3 = Integer.toString(i); // exists for Long, Float, Double, Character, ...
    }
    
    public static void booleanWrapper() {
        // Ugly
        Boolean test = null;
        
        // 3 states for a boolean oO be carefull with Boolean
        if ( test == null ) {
            
        }
        else if ( test ) {
        
        }
        else {
        
        }
    }
    
    public static void main(String[] args) {
        testConcat(); // Profiler said 341ms
        testOldBuffer(); // Profiler said 1.71ms
        testBuffer(); // Profiler said 0.56ms !!!!
        
        convertionExample();
    }
    
}
