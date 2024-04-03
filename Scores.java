import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StudentScores {
    String name;
    int score;

    StudentScores(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class ScoreAnalyzer {
    public static void main(String[] args) {
        List<StudentScores> studentScoresList = new ArrayList<>();
        studentScoresList.add(new StudentScores("John", 85));
        studentScoresList.add(new StudentScores("Alice", 72));
        studentScoresList.add(new StudentScores("Bob", 90));
        studentScoresList.add(new StudentScores("Emily", 68));
        studentScoresList.add(new StudentScores("David", 78));

        int totalScore = 0;
        for (StudentScores student : studentScoresList) {
            totalScore += student.score;
        }
        double averageScore = (double) totalScore / studentScoresList.size();

        List<Integer> scores = new ArrayList<>();
        for (StudentScores student : studentScoresList) {
            scores.add(student.score);
        }
        Collections.sort(scores);

        double medianScore;
        if (scores.size() % 2 == 0) {
            medianScore = (double) (scores.get(scores.size() / 2 - 1) + scores.get(scores.size() / 2)) / 2;
        } else {
            medianScore = scores.get(scores.size() / 2);
        }

        int aboveAverage = 0, atAverage = 0, belowAverage = 0;
        for (StudentScores student : studentScoresList) {
            if (student.score > averageScore) {
                aboveAverage++;
            } else if (student.score == averageScore) {
                atAverage++;
            } else {
                belowAverage++;
            }
        }

        System.out.println("Number of students who scored:");
        System.out.println("Above average: " + aboveAverage + ", Median Score: " + medianScore);
        System.out.println("At average: " + atAverage + ", Median Score: " + medianScore);
        System.out.println("Below average: " + belowAverage + ", Median Score: " + medianScore);
    }
}