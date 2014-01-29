/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.clone;

/**
 *
 * @author yannig
 */
public class Clone implements Cloneable {

    int a = 1;
    int b = 2;
    NoneCloneable noneCloneable;
    
    public Clone() {
        super();
        noneCloneable = new NoneCloneable();
    }

    @Override
    public String toString() {
        return "a: " + a + ", b: " + b + ", " + noneCloneable;
    }

    public Clone deepClone() throws CloneNotSupportedException{
        Clone toReturn = (Clone) super.clone();
        toReturn.noneCloneable = (NoneCloneable) noneCloneable.clone();
        return toReturn;
    }
            
    public static void main(String[] args) throws CloneNotSupportedException {
        
        System.out.println("=============> Init");
        Clone inst1 = new Clone();
        System.out.println( inst1 );
       
        inst1.a = 5;
        
        // Shallow clone
        System.out.println("\n=============> Shallow Clone");
        Clone inst2 = (Clone) inst1.clone(); // <-- Copy the noneCloneable Ref, noneCloneable Ref is share between inst1 and inst2 !!!
        inst2.noneCloneable.alert = "Am I Cloneable?";
        System.out.println( inst1 );
        System.out.println( inst2 );
        
        // Deep Clone
        System.out.println("\n=============> Deep Clone");
        Clone inst3 = (Clone) inst1.deepClone(); // <-- Now the noneCloneable have a new ref, and it state was cloned
        inst3.noneCloneable.alert = "Am I a deep Clone?";
        System.out.println( inst1 );
        System.out.println( inst3 );
        
    }
}
