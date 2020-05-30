import java.lang.annotation.*;

/**
 * This is very first annotation learning program
 * @author natanwar
 * @since 2019-12-01
 * @version 1.0
 */

@Description(
        value = "This is very first annotation learning program",
        authors = @Authors(name = "Narender"),
        since = "2019-12-01",
        version = @Version(1.0)
)
public class Annotations {

    /**
     * @serialData 1231
     * @param args
     */
    public static void main(String[] args) {

        String name = null;
        System.out.println(State.STATIC.ordinal());
        callWithArgs(null);
    }

    static void callWithArgs(String arg) {
        System.out.println(arg);
    }
}

/**
 * @author natanwar
 * @see java.lang.annotation.Annotation
 */
@interface Version {
    double value() default 0.0;
}

@interface Enabled {
    boolean state() default true;
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@interface Description {
    String value() default "";
    Authors[] authors();
    String since();
    Version version();
}

@interface Authors {
    String name() default "";
}


/**
 * @deprecated sun.* classes
 */
enum State {
    RUNNING(1), STOPPED(0), STATIC(-1);

    private int state;

    State(int i) {
        state = i;
    }

    public int getState() {
        return state;
    }
}
