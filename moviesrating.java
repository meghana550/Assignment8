import java.util.HashMap;
import java.util.Map;

class Movie {
    String title;
    String category;
    double rating;

    Movie(String title, String category, double rating) {
        this.title = title;
        this.category = category;
        this.rating = rating;
    }
}

public class Main {
    public static void main(String[] args) {
        Movie[] movies = {
            new Movie("Inception", "PG-13", 4.5),
            new Movie("The Godfather", "R", 4.8),
            new Movie("Toy Story", "G", 4.2),
            new Movie("The Dark Knight", "PG-13", 4.7),
            new Movie("Titanic", "PG-13", 4.1),
            new Movie("Jaws", "PG", 4.0)
        };

        Map<String, Integer> categoryCounts = new HashMap<>();
        Map<String, Double> categoryAverages = new HashMap<>();

        for (Movie movie : movies) {
            categoryCounts.put(movie.category, categoryCounts.getOrDefault(movie.category, 0) + 1);
            categoryAverages.put(movie.category, categoryAverages.getOrDefault(movie.category, 0.0) + movie.rating);
        }

        System.out.println("Movie ratings summary:");
        for (String category : categoryCounts.keySet()) {
            int count = categoryCounts.get(category);
            double averageRating = categoryAverages.get(category) / count;
            System.out.println("Category: " + category + ", Number of Movies: " + count + ", Average Rating: " + averageRating);
        }
    }
}