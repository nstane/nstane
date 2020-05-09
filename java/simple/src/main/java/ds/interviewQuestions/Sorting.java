package ds.interviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    public static void main(String...a) {
        //TODO : Add code here

        //Merge Sort n log n performance in all cases
        //Heapsort
        //Insert Sort O(n) to O(nxn)
        //Quick sort

        System.out.println("!#@!#%^$^&%&*^((*&()*)()(_(_)JHGHJBHJB_:<>?~~".replaceAll("/[^a-zA-Z0-9\\' ]/g", ""));

        List list = Arrays.asList(
                new Activity(1, 3, "Activity 1"),
                new Activity(16, 8, "Activity 16"),
                new Activity(4, 5,"Activity 4"),
                new Activity(7, 18, "SActivity 7"),
                new Activity(5, 13, "Activity 5"),
                new Activity(6, 18, "Activity 6"),
                new Activity(9, 13, "Activity 9"),
                new Activity(7, 12, "Activity 7"),
                new Activity(12, 13, "Activity 12"),
                new Activity(10, 12, "Activity 10")
        );

        System.out.println(list);

        //Sort by reverse() order
        //list.sort((a1, a2) -> ((Activity)a2).getStartTime()-((Activity)a1).getStartTime());
        // Sort by inorder
        list.sort((a1, a2) -> {
            Activity one = ((Activity) a1);
            Activity two = ((Activity) a2);
            if(one.getStartTime() == two.getStartTime()) {
                return two.getName().compareTo(one.getName());
            } else {
                return one.getStartTime() - two.getStartTime();
            }

        });

        System.out.println(list);

    }

    private static class Activity{
        int startTime;
        int endTime;
        String name;
        Activity(int startTime, int endTime, String name) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.name = name;
        }

        public int getEndTime() {
            return endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "{sTime=" + startTime + " name = " + name + '}';
        }
    }
}
