/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.constructoroverride;

import bzh.ys.javabyexample.constructor.*;

/**
 *
 * @author yannig
 */
public class ConstructorExample {
    
    public ConstructorExample() {
        super();
        print();
    }
    
    void print(){
        System.out.println("Hello World, I'm your Mother");
    }
}
