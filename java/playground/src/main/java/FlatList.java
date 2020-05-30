import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatList<T> {
    List<T> tmp;

    FlatList() {
        tmp = new ArrayList<>();
    }
    public static void main(String[] args) {
        List<Integer> intList = new FlatList().flat(Arrays.asList(1, Arrays.asList(2,3,5, Arrays.asList(6,7,8))));

        System.out.println(intList);

    }

    public List<T> flat(List<T> list) {
        for(T i: list) {
            if(i instanceof  Number) {
                tmp.add(i);
            } else {
                flat((List<T>)i);
            }
        }
        return tmp;
    }
}
