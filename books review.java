import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BookReview {
    String title;
    int rating;

    BookReview(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }
}

public class BookReviewAnalyzer {
    public static void main(String[] args) {
        List<BookReview> bookReviews = List.of(
            new BookReview("Book1", 4),
            new BookReview("Book2", 8),
            new BookReview("Book3", 2),
            new BookReview("Book4", 6),
            new BookReview("Book5", 10),
            new BookReview("Book6", 3)
        );

        Map<String, Integer> ratingRanges = new HashMap<>();
        Map<String, Integer> sentimentCategories = new HashMap<>();

        for (BookReview review : bookReviews) {
            if (review.rating >= 1 && review.rating <= 5) {
                ratingRanges.put("1-5 stars", ratingRanges.getOrDefault("1-5 stars", 0) + 1);
            } else if (review.rating >= 6 && review.rating <= 10) {
                ratingRanges.put("6-10 stars", ratingRanges.getOrDefault("6-10 stars", 0) + 1);
            }

            if (review.rating >= 8) {
                sentimentCategories.put("positive", sentimentCategories.getOrDefault("positive", 0) + 1);
            } else if (review.rating >= 4 && review.rating <= 7) {
                sentimentCategories.put("neutral", sentimentCategories.getOrDefault("neutral", 0) + 1);
            } else {
                sentimentCategories.put("negative", sentimentCategories.getOrDefault("negative", 0) + 1);
            }
        }

        System.out.println("Books reviewed within specified rating ranges:");
        for (Map.Entry<String, Integer> entry : ratingRanges.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nCount of books with positive, neutral, and negative reviews:");
        for (Map.Entry<String, Integer> entry : sentimentCategories.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}