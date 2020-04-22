package ds.interviewQuestions;

import java.io.IOException;
import java.util.*;

public class AmazonInterview {
    static class Pair {
        final int x;
        final int y;
        final int dist;
        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String args[]) throws IOException {
        AmazonInterview ai = new AmazonInterview();
        ai.m();
    }

    private void m(){
        List<String> list = null;

        if(list == null || list.size() == 0)
            System.out.println("true");

        anagram();
    }

    public static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {

        if (area == null || area.size() == 0 || numColumns == 0 || numRows == 0)
            return -1;

        boolean[][] visited = new boolean[numRows][numColumns];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (area.get(i).get(j) == 0) {
                    visited[i][j] = true; // 0 means restricted area means visited
                }
            }
        }

        Queue<Pair> queue = new LinkedList<>();

        visited[0][0] = true;
        queue.add(new Pair(0, 0, 0));

        while (!queue.isEmpty()) {

            Pair pair = queue.remove();

            //Reached destination
            if (area.get(pair.x).get(pair.y) == 9) {
                return pair.dist;
            }

            //Moving back horizontal
            if (pair.x - 1 >= 0 && !visited[pair.x - 1][pair.y]) {
                queue.add(new Pair(pair.x - 1, pair.y, pair.dist + 1));
                visited[pair.x - 1][pair.y] = true;
            }

            //Move forward horizontal
            if (pair.x + 1 < numRows && !visited[pair.x + 1][pair.y]) {
                queue.add(new Pair(pair.x + 1, pair.y, pair.dist + 1));
                visited[pair.x + 1][pair.y] = true;
            }

            //Moving back vertical
            if (pair.y - 1 >= 0 && !visited[pair.x][pair.y - 1]) {
                queue.add(new Pair(pair.x, pair.y - 1, pair.dist + 1));
                visited[pair.x][pair.y - 1] = true;
            }

            //Moving forward vertical
            if (pair.y + 1 < numColumns && !visited[pair.x][pair.y + 1]) {
                queue.add(new Pair(pair.x, pair.y + 1, pair.dist + 1));
                visited[pair.x][pair.y + 1] = true;
            }
        }

        return -1;
    }


    public List<String> orderedJunctionBoxes(int numberOfBoxes, List<String> boxList) {
        // WRITE YOUR CODE HERE

        if (numberOfBoxes == 0 || boxList == null || boxList.size() == 0)
            return Collections.EMPTY_LIST;

        //only numeric
        List<String> newL = new ArrayList<>();

        //alpha numeric
        List<String> oldL = new ArrayList<>();

        for (String box : boxList) {
            String[] b = box.split(" ");

            String s = b[1];

            try {
                Integer.parseInt(s);
                newL.add(box);
            } catch (Exception e) {
                oldL.add(box);
            }
        }

        Collections.sort(oldL, (o1, o2) -> {
                int index1 = o1.indexOf(" ");
                String o1n = o1.substring(index1 + 1);

                int index2 = o2.indexOf(" ");
                String o2n = o2.substring(index2 + 1);

                int c = o1n.compareTo(o2n);

                if (c == 0) {
                    return o1.substring(0, index1).compareTo(o2.substring(0, index2));
                }
                return c;
        });

        List<String> result = new ArrayList<>();
        /*for (String newBox : oldL) {
            result.add(newBox);
        }

        for (String newBox : newL) {
            result.add(newBox);
        }*/
        result.addAll(oldL);
        result.addAll(newL);
        return result;
    }

    void anagram() {
        String str1 = "stackoverflow";
        String str2 = "flowerovstack";

        if(str1.length() == str2.length()){
            if(Arrays.equals(toSortedArray(str1), toSortedArray(str2))) {
                System.out.println("Strings are anagram");
            }
        } else {
            System.out.println("Not anagram");
        }
    }

    private char [] toSortedArray(String str) {
        char [] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return charArray;
    }
}
