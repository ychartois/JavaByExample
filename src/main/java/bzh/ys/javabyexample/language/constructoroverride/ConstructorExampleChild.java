/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.language.constructoroverride;

/**
 *
 * @author yannig
 */
public class ConstructorExampleChild extends ConstructorExample {
    
    public ConstructorExampleChild() {
        super();
    }
    
    void print(){
        System.out.println("Hello World, I'm the Child");
    }
    
    public static void main(String[] args) {
        ConstructorExampleChild example = new ConstructorExampleChild();
        example.print();
        // Hello World, I'm the Child
        // Hello World, I'm the Child
        
        ConstructorExample example2 = new ConstructorExampleChild();
        example2.print();
        // Hello World, I'm the Child
        // Hello World, I'm the Child        
        
        ConstructorExample example3 = new ConstructorExample();
        example3.print();
        // Hello World, I'm your Mother
        // Hello World, I'm your Mother
    }
}
