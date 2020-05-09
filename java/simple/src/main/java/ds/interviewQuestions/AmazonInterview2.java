package ds.interviewQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class AmazonInterview2 {
    public static void main(String[] args) {
        List<String> toyNames = Arrays.asList("elso", "elsa", "legos", "dron", "tablet");
        List<String> quotes = Arrays.asList(
                "Elmo is hotest toys Elmo",
                "elmo is some thing",
                "elsa is prrincess",
                "elsa is white queen",
                "parent buing dron for kids",
                "warcraft is dangeroud game for kids"
        );

        //System.out.println(run(6, 2, toyNames, quotes));
        System.out.println(popularNToys(6, 2, 6, toyNames, quotes));
    }

    private static Set<String> run(int numberOfToys, int topToys, List<String> toyNames, List<String> quotes) {

        Map<String, Integer> map = frequency(toyNames, quotes);
        if (topToys > numberOfToys) {
            return map.keySet(); //only toys mentioned in quotes
        }

        //Comparator.comparing((c1, c2)-> c1.).thenComparing(Comparator.comparingInt())
        // if 2 toys has sam frequency in quotes then sort by alphabetic
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Integer::intValue)))
                .sorted((entry, entry2) -> {
                    if (entry.getKey() == entry2.getKey()) {
                        return entry.getKey().compareTo(entry2.getKey());
                    }
                    return 0;
                })
                .limit(topToys).map(entry -> entry.getKey()).collect(Collectors.toSet());// List of string toys name
    }

    private static Map<String, Integer> frequency(List<String> toyNames, List<String> quotes) {

        Map<String, Integer> map = new LinkedHashMap<>();

        for (String toyName : toyNames) {
            for (String quote : quotes) {
                if (quote.toLowerCase().contains(toyName.toLowerCase())) {
                    map.put(toyName, map.getOrDefault(toyName, 1));
                }
            }
        }
        return map;
    }

    public static ArrayList<String> popularNToys(int numToys,
                                                 int topToys,
                                                 int numQuotes,
                                                 List<String> toys,
                                                 List<String> quotes) {
        ArrayList<String> result = new ArrayList<>();

        if (toys == null || quotes == null)
            return result;


        //  topToys = Math.min(topToys,numToys);

        Set<String> set = new HashSet<>();
        for (String toy : toys) {
            set.add(toy.toLowerCase());
        }

        Map<String, Integer> map = new HashMap<>();

        class Pair {

            String toy;
            int count;

            public Pair(String toy, int count) {
                this.toy = toy;
                this.count = count;
            }
        }

        //Min
        Queue<Pair> queue = new PriorityQueue<>(
                (a, b) ->
                {
                    int diff = a.count - b.count;
                    if (diff == 0) {
                        return b.toy.compareTo(a.toy);
                    }
                    return diff;
                }
        );


        for (String quote : quotes) {
            Set<String> quoteSet = new HashSet<>();
            for (String q : quote.split(" ")) {

                String s = q.toLowerCase();
                StringBuilder sb = new StringBuilder();

                for (int index = 0; index < s.length(); index++) {
                    char c = s.charAt(index);
                    if (c >= 'a' && c <= 'z')
                        sb.append(c);
                }
                s = sb.toString();
                if (set.contains(s)) {
                    quoteSet.add(s);
                }
            }

            for (String quoteS : quoteSet) {
                map.put(quoteS, map.getOrDefault(quoteS, 0) + 1);
            }
        }

//        int i=1;
//        for(Map.Entry<String,Integer> entry: map.entrySet()) {
//            Pair pair =new Pair(entry.getKey(),entry.getValue());
//            if(queue.isEmpty() || i<=topToys) {
//                queue.add(pair);
//                i++;
//            }else {
//                Pair peek = queue.peek();
//                if(peek.count < pair.count || (peek.count == pair.count &&
//                    pair.toy.compareTo(peek.toy) ==1
//                )) {
//                    queue.remove();
//                    queue.add(pair);
//                }
//            }
//        }
//
//        while (!queue.isEmpty())
//            result.add(queue.remove().toy);
//
//        Collections.reverse(result);


        List<Pair> pairs = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            pairs.add(pair);
        }

        Collections.sort(pairs, (a, b) ->
        {
            int diff = b.count - a.count;
            if (diff == 0) {
                return a.toy.compareTo(b.toy);
            }
            return diff;
        });


        for (int i = 0; i < pairs.size() && i < topToys; i++)
            result.add(pairs.get(i).toy);


        return result;
    }
}
