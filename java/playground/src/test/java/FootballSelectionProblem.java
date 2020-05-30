import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FootballSelectionProblem {
    public static Predicate<Applicant> fitnessPredicate = a ->
            a.height >= 5.8 && a.bmi <= 23;

    public static void main(String[] args) {
        List list = getSelectionStatus(Arrays.asList(
                Arrays.asList("Boateng", "6.1", "22", "1000", "1000"),
                Arrays.asList("Kaka", "6", "22", "1", "1"),
                Arrays.asList("Ronaldo", "5.8", "21", "120", "0"),
                Arrays.asList("Suarez", "5.9", "20", "100", "1")
        ));
        list.forEach(System.out::println);
    }

    public static List<List<String>> getSelectionStatus(List<List<String>> applications) {
        List<Applicant> players = applications.stream().map(l -> new Applicant(
                l.get(0),
                Double.valueOf(l.get(1)),
                Integer.valueOf(l.get(2)),

                Integer.valueOf(l.get(3)),
                Integer.valueOf(l.get(4)))
        ).collect(Collectors.toList());

        List<Applicant> eligibleApplicants = players.stream().filter(fitnessPredicate).collect(Collectors.toList());

        Optional<Applicant> strikerOptional = eligibleApplicants.stream().filter(a -> a.score >= 50).max((o1, o2) -> {
            if (o1.score == o2.score) {
                return compareFitness(o1, o2);
            } else {
                return o1.score - o2.score;
            }
        });

        strikerOptional.ifPresent(e-> eligibleApplicants.remove(e));

        Optional<Applicant> defenderOptional = eligibleApplicants.stream().filter(a -> a.defends >= 30).max((o1, o2) -> {
            if (o1.defends == o2.defends) {
                return compareFitness(o1, o2);
            } else {
                return o1.defends - o2.defends;
            }
        });

        Applicant striker = null;
        Applicant defender = null;

        List<Applicant> response = new ArrayList();

        if (strikerOptional.isPresent() && defenderOptional.isPresent()) {
            defender = defenderOptional.get();
            players.remove(defender);
            response.add(defender);

            striker = strikerOptional.get();
            players.remove(striker);
            response.add(striker);
        }

        response.addAll(players);

        Collections.sort(response, Comparator.comparing(o -> o.name));

        Applicant finalStriker = striker;
        Applicant finalDefender = defender;
        return response.stream().map(a ->
                Arrays.asList(
                        a.name,
                        (Objects.equals(a, finalStriker) || Objects.equals(a, finalDefender)) ? "SELECT" : "REJECT",
                        Objects.equals(a, finalStriker) ? "STRIKER" : (Objects.equals(a, finalDefender) ? "DEFENDER" : "NA")
                )
        ).collect(Collectors.toList());
    }

    private static int compareFitness(Applicant o1, Applicant o2) {
        if (o2.bmi == o1.bmi) {
            return o1.height.compareTo(o2.height);
        } else {
            return o1.bmi - o2.bmi;
        }
    }

    private static class Applicant {
        String name;
        Double height;
        int bmi;
        int score;
        int defends;

        Applicant(String name, Double height, int bmi, int score, int defends) {
            this.name = name;
            this.height = height;
            this.bmi = bmi;
            this.score = score;
            this.defends = defends;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Applicant applicant = (Applicant) o;
            return bmi == applicant.bmi &&
                    score == applicant.score &&
                    defends == applicant.defends &&
                    Objects.equals(name, applicant.name) &&
                    Objects.equals(height, applicant.height);
        }

        @Override
        public String toString() {
            return "Applicant{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    ", bmi=" + bmi +
                    ", score=" + score +
                    ", defends=" + defends +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, height, bmi, score, defends);
        }
    }
}
