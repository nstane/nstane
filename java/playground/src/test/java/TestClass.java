import java.util.Objects;

interface Department {
    void setName(String employeeName);

    void display();
}

public class TestClass {
    static final String MESSAGE = "Name : %s";
    private static final String DEVELOPER = "Developer";
    private static final String SALES = "Sales";
    private static final String PROBLEM_SETTER = "ProblemSetter";

    public static void main(String[] args) {
        database_clean(new String[]{
                "Sales saurabh&",
                "ProblemSetter #ravi",
                "Developer vi#ve$k"
        });
    }

    static void database_clean(String[] data) {
        for (String d : data) {
            final String[] values = d.trim().split(" ");
            Department department = getReference(values[0]);

            if (!Objects.isNull(department)) {
                department.setName(removeSpecialChar(values[1]));
                department.display();
            }
        }
    }

    static Department getReference(String name) {
        switch (name) {
            case SALES:
                return new Sales(SALES);
            case DEVELOPER:
                return new Developer(DEVELOPER);
            case PROBLEM_SETTER:
                return new ProblemSetter(PROBLEM_SETTER);
            default:
                return null;
        }
    }

    static String removeSpecialChar(String inp) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < inp.length(); i++) {
            char c = inp.charAt(i);
            if (c >= 'a' && c <= 'z') {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}

class ProblemSetter implements Department {
    private final String name;
    private String employeeName;

    public ProblemSetter(String name) {
        this.name = name;
    }

    @Override
    public void setName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public void display() {
        System.out.println(name);
        System.out.println(String.format(TestClass.MESSAGE, employeeName));
    }
}

class Developer implements Department {
    private final String name;
    private String employeeName;

    public Developer(String name) {
        this.name = name;
    }

    @Override
    public void setName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public void display() {
        System.out.println(name);
        System.out.println(String.format(TestClass.MESSAGE, employeeName));
    }
}

class Sales implements Department {
    private final String name;
    private String employeeName;

    public Sales(String name) {
        this.name = name;
    }

    @Override
    public void setName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public void display() {
        System.out.println(name);
        System.out.println(String.format(TestClass.MESSAGE, employeeName));
    }
}