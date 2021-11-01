import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private int score;
    Student (String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }
    public int getScore() {
        return this.score;
    }

    @Override
    public int compareTo(Student other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int score = in.nextInt();
            students.add(new Student(name, score));
        }

        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getName() + " ");
        }
    }
}
