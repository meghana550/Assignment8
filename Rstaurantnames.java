import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Restaurant {
    String name;
    int rating;

    Restaurant(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }
}

public class RestaurantRatingAnalyzer {
    public static void main(String[] args) {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Restaurant A", 4));
        restaurants.add(new Restaurant("Restaurant B", 7));
        restaurants.add(new Restaurant("Restaurant C", 9));
        restaurants.add(new Restaurant("Restaurant D", 6));
        restaurants.add(new Restaurant("Restaurant E", 3));
        restaurants.add(new Restaurant("Restaurant F", 8));

        Map<String, Integer> ratingRangesCount = new HashMap<>();
        Map<String, Double> ratingRangesAverage = new HashMap<>();

        for (Restaurant restaurant : restaurants) {
            int rating = restaurant.rating;
            String range = getRatingRange(rating);

            ratingRangesCount.put(range, ratingRangesCount.getOrDefault(range, 0) + 1);
            ratingRangesAverage.put(range, ratingRangesAverage.getOrDefault(range, 0.0) + rating);
        }

        for (String range : ratingRangesCount.keySet()) {
            int count = ratingRangesCount.get(range);
            double average = ratingRangesAverage.get(range) / count;
            System.out.println("Rating range: " + range + ", Number of restaurants: " + count + ", Average rating: " + average);
        }
    }

    private static String getRatingRange(int rating) {
        if (rating >= 1 && rating <= 5) {
            return "1-5";
        } else if (rating >= 6 && rating <= 10) {
            return "6-10";
        } else {
            return "Unknown";
        }
    }
}