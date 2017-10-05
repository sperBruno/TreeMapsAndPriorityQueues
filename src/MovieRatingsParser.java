/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

    public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {

        TreeMap<String, PriorityQueue<Integer>> movieRatingsParserMap = new TreeMap<>();
        PriorityQueue<Integer> aux;
        if (allUsersRatings != null && !allUsersRatings.isEmpty()) {
            for (UserMovieRating rating : allUsersRatings) {

                if (rating == null || rating.getMovie() == null || rating.getMovie().isEmpty() ||  rating.getUserRating() < 0) {
                    System.out.println("Skip movie");
                    continue;
                }
                System.out.println("Movie " + rating.getMovie());
                System.out.println("Rating " + rating.getUserRating());
                if (movieRatingsParserMap.containsKey(rating.getMovie().toLowerCase())) {
                    aux = movieRatingsParserMap.get(rating.getMovie().toLowerCase());
                    aux.add(rating.getUserRating());
                    System.out.println(aux);
                    movieRatingsParserMap.put(rating.getMovie().toLowerCase(), aux);
                } else {
                    aux = new PriorityQueue<>();
                    aux.add(rating.getUserRating());
                    movieRatingsParserMap.put(rating.getMovie().toLowerCase(), aux);
                }
            }
        }
        return movieRatingsParserMap;
    }

}
