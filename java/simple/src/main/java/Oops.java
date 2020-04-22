
import javax.naming.MalformedLinkException;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import static java.lang.System.out;

public class Oops {
    public static void main(String[] args) throws Throwable {
        Base child = new Other("Others");
        String aa = child.callWithUncheckedException((a) -> a);

        child.callWithCheckedException((a) -> a);

        Base base = new Base();
        String bb = base.callWithUncheckedException((a) -> a);

        out.println(aa);
        out.println(bb);
    }
}


interface One {
    void a();
    default void call() {
        out.println("calling One");
    }
}

interface Two {
    void a();

    default void call() {
        out.println("calling Two");
    }
}

interface Three {
    void a();

    default void call() {
        out.println("calling Three");
    }
}

class Base implements One, Two{

    public Base() {
        // Note :  when we create Base c = new Other() this will call doSomething() of other and that is bad because it wil possible we can pass
        // this some where from here before object complete initialize
        doSomething();
    }
    protected String callWithUncheckedException (Function function) throws NullPointerException {
        return (String) function.apply("a");
    }

    public String callWithCheckedException(Function function) throws MalformedLinkException {
        return (String) function.apply("a");
    }

    @Override
    public void a() {
        out.println("calling a of Base");
    }

    @Override
    public void call() {
        One.super.call();
    }

    public void doSomething() {
        System.out.println("do something from base");
    }
}
class Other extends Base{
    public Other(String name) {

    }

    /**
     * Note:  Either use child or same exception or parent exception in case of unchecked exception
     * @param function
     * @return
     * @throws Throwable
     */
    public String call(BinaryOperator function) {
        return (String) function.apply("b", "c");
    }

    @Override
    protected String callWithUncheckedException(Function function) throws ArrayIndexOutOfBoundsException {
        return (String) function.apply("a");
    }

    /**
     * Note:  Either use child or same exception in case of checked exception or no exception
     * @param function
     * @return
     * @throws Exception
     */
    @Override
    public String callWithCheckedException(Function function) throws MalformedLinkException {
        return (String) function.apply("a");
    }

    public void doSomething() {
        System.out.println("do something from others");
    }
}


/*
1. Use immutable object or implement hashcode and equals method when we use hash based collection
otherwise we can end up in memory leaks.

2. One may call System.gc() when profiling an application to search for possible memory leaks.
All the profilers call this method just before taking a memory snapshot.

3. Integer)128 == (Integer)128 is `false`
JVM keeps a cache of the object wrappers in some range (for Integer the default range is [-127, 127])

 */
