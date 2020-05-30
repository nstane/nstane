import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.System.out;

/**
 * Note: no modified allowed in enum constructor
 */
enum TestEnum {
    TEST_ENUM;

    private static final String hello = "";

    public static void testMe() {
    }
}

public class Utils {
    private static final String TEST_STRING = "Test this please";

    public static void main(String[] args) throws IOException {
       /* out.println("functions");
        functions();
        out.println("base64");
        base64();
        out.println("printMin");
        printMin();
        out.println("printCharArray");
        printCharArray();
        out.println("playWithDoubles");
        playWithDoubles();*/
        out.println("handleFiles");
        handleFiles();
       /* out.println("listImmutability");
        listImmutability();
        out.println("printI");
        printI();
        out.println("permutation");
        permutation("not", "");
        out.println("stackOperation");
        stackOperation();

        out.println("findDuplicateIn2Arrays");
        findDuplicateIn2Arrays();*/

        //out.println(find("nMM"));
        //out.println(6);
        //out.println(getMax(new int[]{3, 2,2,3,4,3}));
    }

    private static void findDuplicateIn2Arrays() {
        int arr1[] = {11, 12, 45, 67, 89}, arr2[] = {12, 34, 56, 78, 11};
        Set set = new HashSet();
        for (int i : arr1) {
            set.add(i);
        }
        for (int i : arr2) {
            if (set.contains(i)) {
                out.println("Found duplicate " + i);
            }
        }
    }

    private static void stackOperation() {
        new ArrayList();
        new LinkedList();
        new ArrayBlockingQueue(1);
        Stack stack = new Stack();
        stack.push("hello");
        stack.push("narender");
        out.println((String) stack.pop() + (String) stack.pop());
    }


    public static void printI() {
        int i = 0;
        for (int j = 1; j <= 10; j++) {
            i = ++i;
        }
        out.println(i);
    }

    static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    public static void listImmutability() {
        List l = Arrays.asList(1, 2);
        List l2 = l;
        // Note: will throw java.lang.UnsupportedOperationException because list is immutable
        //l2.add(1.9);
    }

    private static void testGeneric() {
        Animal<Integer> animal = new Animal<>(123, 123);
    }

    private static void callFromNullRef() {
        // Note: A null reference may be used to access a class (static) variable without causing an exception.
        Utils utils = null;
        utils.tesMe();
    }

    private static void tesMe() {
        out.println("test me");
    }

    /**
     * Note: Always use try with resource like files read otherwise stream will keep open
     */
    private static void handleFiles() {
        try (final Stream<String> stream = Files.lines(Paths.get("/Users/natanwar/Downloads/FL_insurance_sample.csv"));
        ) {
            stream.sequential().limit(20).forEach(
                    e -> {
                        System.out.println(e);
                    });
        } catch (IOException e) {
            out.print(e.getMessage());
        }
    }

    private static void playWithDoubles() {
        out.println("in playWithDoubles ....");
        final double d = 1d / 2d;

        System.out.println(d);

        try {
            out.println("in divideByO ....");
            divideByO();
        } catch (Exception e) {
            out.print(e.getMessage());
        }

        out.println("out playWithDoubles ....");
    }

    private static void wrongCode() {
        final byte[] wrong = TEST_STRING.getBytes();
        // Note: This will give different output for window and unix system so always provide charset
        final byte[] bytes = TEST_STRING.getBytes(StandardCharsets.UTF_8);

    }

    private static void printCharArray() {
        char[] chars = new char[]{'\u0097'};
        String str = new String(chars);
        out.print('\u0097' + " --- " + str);
        byte[] bytes = str.getBytes();
        out.println(Arrays.toString(bytes));
    }

    private static void divideByO() {
        //below statement return Double.INFINITY
        out.println(1.0 / 0.0);
        //below statement throw divide by 0 exception
        out.println(1l / 0l);
    }

    private static void printMin() {
        out.println(Double.MIN_VALUE);
        out.println(Integer.MIN_VALUE);
        out.println(Long.MIN_VALUE);
    }

    public static void functions() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        backToString.apply("123");
        toInteger.apply("123");

        anotherFunction(System.out::println);
    }

    public static void base64() {
        String encodedString = Base64.getEncoder().encodeToString(TEST_STRING.getBytes(StandardCharsets.UTF_8));
        String decodedString = new String(Base64.getDecoder().decode(encodedString), StandardCharsets.UTF_8);

        out.println("encodedString = " + encodedString);
        out.println("decodedString = " + decodedString);
    }

    private static void anotherFunction(Consumer function) {
        function.accept("hello");
    }

    static int find(String pattern) {
        if (pattern == null || pattern.length() == 0)
            return -1;

        Stack<Integer> stack = new Stack<>();

        int result = 0;
        for (int index = 0; index <= pattern.length(); index++) {

            if (index < pattern.length() && !(pattern.charAt(index) == 'N' || pattern.charAt(index) == 'M'))
                return -1;

            stack.add(index + 1);

            if (index == pattern.length() || pattern.charAt(index) == 'N') {
                while (!stack.isEmpty())
                    result = result * 10 + stack.pop();

            }
        }

        return result;
    }

    static int noOfWaysToDrawTheGame(int totalScore) {
        if (totalScore <= 1)
            return 0;

        int[] t = new int[totalScore + 1];

        t[0] = 1;

        for (int i = 2; i <= totalScore; i += 2) {
            for (int j = 2; j <= 6; j += 2) {
                if (i >= j) {
                    t[i] += t[i - j];
                }
            }
        }

        return t[totalScore];
    }

    static int getMax(int[] arr) {
        int max = arr[0], maxCount = 1;
        int[] count = new int[arr.length + 1];
        int i;
        for (i = 0; i < arr.length; i++) {
            count[arr[i]]++;
            if (count[arr[i]] > maxCount) {
                maxCount = count[arr[i]];
                max = arr[i];
            }
        }
        return max;
    }
}

class Animal<T> {
    T animal;
    T age;

    public Animal(T animal, T age) {
        this.animal = animal;
        this.age = age;
    }
}
