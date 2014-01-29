/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.language.constructor;

/**
 *
 * @author yannig
 */
public class ConstructorExampleChild extends ConstructorExample {
    
    public ConstructorExampleChild() {
        // super() <- doesn't works, we have to define the constructor, the default one can't work !
        super("hello");
    }
    
    void print(){
        System.out.println("Hello World");
    }
    
    public static void main(String[] args) {
        ConstructorExampleChild example = new ConstructorExampleChild();
        example.print();
    }
}
