package ds.interviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class Hashing {

    public static void main(String[] args) {
        Map<Key, String> map = new HashMap<Key, String>();
        map.put(new Key("1", "One"), "1");
        map.put(new Key("2", "two"), "2");
        map.put(new Key("3", "three"), "3");
        map.put(new Key("4", "four"), "4");
        map.put(new Key("5", "five"), "5");
        map.put(new Key("6", "six"), "6");

        System.out.println(map);
    }
}

class Key {
    String id;
    String name;
    public Key(String id, String name) {
        this.id= id;
        this.name=name;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        Key other = (Key) obj;
        return this.id.equals(other.id) && this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return new StringBuilder(this.name).append(" ").append(this.id).append(" ").toString();
    }
}
