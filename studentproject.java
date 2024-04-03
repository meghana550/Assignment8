import java.util.ArrayList;
import java.util.List;

class Project {
    int days;
    boolean onTime;

    Project(int days, boolean onTime) {
        this.days = days;
        this.onTime = onTime;
    }
}

class Student {
    String name;
    List<Project> projects = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void addProject(Project project) {
        projects.add(project);
    }

    int onTimeCount() {
        int count = 0;
        for (Project project : projects) {
            if (project.onTime) count++;
        }
        return count;
    }

    double avgCompletionTime() {
        double sum = 0;
        for (Project project : projects) {
            sum += project.days;
        }
        return sum / projects.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Student john = new Student("John");
        john.addProject(new Project(5, true));
        john.addProject(new Project(7, false));

        Student alice = new Student("Alice");
        alice.addProject(new Project(4, true));
        alice.addProject(new Project(8, false));

        System.out.println("John completed " + john.onTimeCount() + " projects on time, with an average completion time of " + john.avgCompletionTime() + " days.");
        System.out.println("Alice completed " + alice.onTimeCount() + " projects on time, with an average completion time of " + alice.avgCompletionTime() + " days.");
    }
}