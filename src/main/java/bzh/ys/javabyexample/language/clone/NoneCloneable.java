/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bzh.ys.javabyexample.language.clone;

/**
 *
 * @author yannig
 */
public class NoneCloneable implements Cloneable {

    String alert = "I'm not cloneable";

    @Override
    public String toString() {
        return alert;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
