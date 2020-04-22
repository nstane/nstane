import static java.lang.System.out;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Reflection ref = new Reflection();
        out.println(ref);
        out.println(ref.getClass());
        out.println(Reflection.class);
        out.println(Class.forName("Reflection"));
    }
}
