/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.language.constructoroverride2;

/**
 *
 * @author yannig
 */
public class ConstructorExample {
    
    protected static int b = 50;
    
    protected int a;
    
    public ConstructorExample() {
        super();
        print();
    }
    
    void print(){
        System.out.println(a + " " + b);
    }
}
