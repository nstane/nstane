package javaconcepts;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        anyThingExtendsNumberOrSame();
        anyThingSuperOfIntegerOrSame();
    }

    private static void anyThingSuperOfIntegerOrSame() {
        List<? super Integer> l1 = new ArrayList<Integer>();
        List<? super Integer> l2 = new ArrayList<Number>();
        List<? super Integer> l3 = new ArrayList<Object>();
    }

    private static void anyThingExtendsNumberOrSame() {
        List<? extends Number> l1 = new ArrayList<Number>();
        List<? extends Number> l2 = new ArrayList<Integer>();
        List<? extends Number> l3 = new ArrayList<Double>();
    }


}
