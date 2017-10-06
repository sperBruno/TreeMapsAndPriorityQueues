/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.*;


public class MovieRatingsProcessor {

    public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
        List<String> listOfMovie = new ArrayList<>();
        if (movieRatings != null) {
            for (Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
                listOfMovie.add(entry.getKey());
            }
            listOfMovie.sort(String::compareToIgnoreCase);
        }
        return listOfMovie;
    }

    public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        List<String> listOfMovie = new ArrayList<>();
        if (movieRatings != null) {
            for (Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
                if (entry.getValue().contains(rating)) {
                    continue;
                }
                for (int rate : entry.getValue()) {
                    if (rate > rating) {
                        listOfMovie.add(entry.getKey());
                        break;
                    } else {
                        break;
                    }
                }
            }
            listOfMovie.sort(String::compareToIgnoreCase);
        }
        return listOfMovie;
    }

    public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        TreeMap<String, PriorityQueue<Integer>> auxRatingInput = new TreeMap<>();
        TreeMap<String, Integer> deletedMovies = new TreeMap<>();
        if (movieRatings != null) {
            addValueToAuxMap(movieRatings, auxRatingInput);

            for (Map.Entry<String, PriorityQueue<Integer>> entry : auxRatingInput.entrySet()) {
                int count = 0;
                int index = count;
                int numberOfRating = entry.getValue().size();
                int sizeOfRating = numberOfRating;
                Object[] it = entry.getValue().toArray();
                while (numberOfRating > 0) {
                    int item = (int) it[index];
                    if (item < rating) {
                        count++;
                        movieRatings.get(entry.getKey()).remove(item);
                    }
                    index++;
                    numberOfRating--;
                }
                if (sizeOfRating == count) {
                    movieRatings.remove(entry.getKey());
                    deletedMovies.put(entry.getKey(), count);
                } else if (count > 0) {

                    deletedMovies.put(entry.getKey(), count);
                }
            }
        }
        return deletedMovies;
    }

    private static void addValueToAuxMap(TreeMap<String, PriorityQueue<Integer>> movieRatings, TreeMap<String, PriorityQueue<Integer>> auxRatingInput) {
        for (Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
            auxRatingInput.put(entry.getKey(), entry.getValue());
        }
    }
}
