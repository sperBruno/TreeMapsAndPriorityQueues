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
        return listOfMovie; // this line is here only so this code will compile if you don't modify it
    }

    public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        System.out.println(rating);
        TreeMap<String, PriorityQueue<Integer>> auxRatingInput = movieRatings;
        TreeMap<String, Integer> deletedMovies = new TreeMap<>();
        ArrayList<String> listToremove = new ArrayList<>();
        if (movieRatings != null) {
            for (Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
                int count = 0;
                System.out.println(entry.getValue());
                for (Integer item : entry.getValue()) {
                    if (item < rating) {
                        ///auxRatingInput.get(entry.getKey()).remove(item);
                        count++;
                    }
                }
                if (entry.getValue().size() == count) {
                    //auxRatingInput.remove(entry.getKey());
                    listToremove.add(entry.getKey());
                } else if (count > 0) {

                    deletedMovies.put(entry.getKey(), count);
                    System.out.println(deletedMovies);
                }
            }
        }
        for (String item: listToremove) {
            deletedMovies.remove(item);
        }
        System.out.println(deletedMovies);
        return deletedMovies;
    }
}
