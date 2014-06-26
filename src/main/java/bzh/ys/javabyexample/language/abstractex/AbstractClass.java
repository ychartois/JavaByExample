package bzh.ys.javabyexample.language.abstractex;

/**
 * Description: TODO
 * <p/>
 * Date: 2014-06-26 11:27 PM
 *
 * @author yannig
 */
public abstract class AbstractClass {

    public abstract void stuff( String test );

    public void bar() {
        System.out.println("I'm bar");
    }

    class Implements extends AbstractClass {

        @Override
        public void stuff(String test) {
            System.out.println( test + " Youhou");
        }
    }

    public static void main(String[] args) {
        AbstractClass test = new AbstractClass() {
            @Override
            public void stuff(String test) {
                System.out.println(test);
            }
        };
    }
}
