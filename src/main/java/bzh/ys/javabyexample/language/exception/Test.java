/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.language.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yannig
 */
public class Test {
    
    
// < ---------------------------------------------- >
//                Definition 
// < ---------------------------------------------- >
    public static void unChecked() {
        canHaveNullPointer();
    }
    
    public static String canHaveNullPointer() {
        String test = null;
        return test.concat(""); // will throws a NullPointer
    }
    
    public static void checkedThrow() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("test"); // Will maybe throw a FileNotFoundException
    }
    
    public void useCheckedThrow() throws FileNotFoundException {
        checkedThrow(); // We have to handle or re-throw the exception !!
    }
    
    
// < ---------------------------------------------- >
//                Try / catch 
// < ---------------------------------------------- >    
    public static void checkedCatch() {
        try { 
            FileInputStream fileInputStream = new FileInputStream("test");
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void checkedCatch2() {
        try { 
            FileInputStream fileInputStream = new FileInputStream("test");
        } 
        catch ( Throwable ex ) { // IS EVIL !!!!!! it can hide a NullPointerException oO !!
                // even worst !!! Nobody can knows what happened !!
        }
    }
    
    public static void checkedCatch3() {
        try { 
            FileInputStream fileInputStream = new FileInputStream("test");
            fileInputStream.close();
            SimpleDateFormat format = new SimpleDateFormat("MM/DD/YY");
            Date date = format.parse("01/01/2020");
        }
        // Old Style 
        catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ParseException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
    
    public static void checkedCatch4() {
        try { 
            FileInputStream fileInputStream = new FileInputStream("test");
            fileInputStream.close();
            SimpleDateFormat format = new SimpleDateFormat("MM/DD/YY");
            Date date = format.parse("01/01/2020");
        } 
        // Java7 style
        catch (ParseException | IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
    
    public static void checkedCatch5() {
        try { 
            FileInputStream fileInputStream = new FileInputStream("test");
            fileInputStream.close();
            SimpleDateFormat format = new SimpleDateFormat("MM/DD/YY");
            Date date = format.parse("01/01/2020");
        } 
        // Java7 style
        catch (ParseException | IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
    
// < ---------------------------------------------- >
//                Try / catch / finally
// < ---------------------------------------------- >
    
    public static void checkedFinally() {
        // /!\ before Java 7
        FileInputStream fileInputStream = null;
        
        try { 
            fileInputStream = new FileInputStream("test");
            fileInputStream.read(); // Hypothesis: read doesn't works and throw an IOExeption => The ressource can't be closed !!
            fileInputStream.close(); // be carefull a ressource must always be terminated
        } 
        catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally {
            if ( fileInputStream != null ) {
                try {
                    fileInputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    
    public static String checkedFinally2() {
        try { 
            SimpleDateFormat format = new SimpleDateFormat("MM/DD/YY");
            Date date = format.parse("toto");
        } 
        catch (ParseException ex) {
            System.out.println( ex.getMessage() );
            return "error";
        } 
        finally {
            System.out.println("I'm a finally");
        }
        
        return "ok";
    }
    
    public static String checkedFinally3() {
        try { 
            SimpleDateFormat format = new SimpleDateFormat("MM/DD/YY");
            Date date = format.parse("toto");
        } 
        catch (ParseException ex) {
            System.out.println( ex.getMessage() );
            return "error";
        } 
        finally {
            System.out.println("I'm a finally");
            return "ok";
        }
    }

    
// < ---------------------------------------------- >
//                  Main
// < ---------------------------------------------- >    
    public static void main(String[] args) {
        System.out.println(checkedFinally2());
        // Unparseable date: "toto"
        // I'm a finally
        // and return "error"
        
        System.out.println(checkedFinally3());
        // Unparseable date: "toto"
        // I'm a finally
        // and return "ok"      /!\ BE CAREFULL
    }
    
}
