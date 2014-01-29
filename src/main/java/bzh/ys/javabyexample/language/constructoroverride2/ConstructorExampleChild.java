/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.language.constructoroverride2;

/**
 *
 * @author yannig
 */
public class ConstructorExampleChild extends ConstructorExample {
    
    public ConstructorExampleChild( int value ) {
        super();
        this.a = value;
        b = 51;
    }
    
    void print(){
        System.out.println(a + " " + b);
    }
    
    public static void main(String[] args) {
        ConstructorExampleChild example = new ConstructorExampleChild( 42 );
        example.print();
        // 0 50
        // 42 51
        
        ConstructorExample example2 = new ConstructorExampleChild( 42 );
        example2.print();
        // 0 51
        // 42 51      
        
        ConstructorExample example3 = new ConstructorExample();
        example3.print();
        // 0 51
        // 0 51
    }
}
