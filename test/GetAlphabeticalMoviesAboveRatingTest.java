/**
 * Created by bruno on 04-10-17.
 */
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetAlphabeticalMoviesAboveRatingTest
{
    TreeMap<String, PriorityQueue<Integer>> map;

    @Before
    public void setUp()
    {
        this.map = new TreeMap();

        PriorityQueue localPriorityQueue1 = new PriorityQueue();
        localPriorityQueue1.add(Integer.valueOf(3));
        localPriorityQueue1.add(Integer.valueOf(5));
        this.map.put("sabrina", localPriorityQueue1);

        PriorityQueue localPriorityQueue2 = new PriorityQueue();
        localPriorityQueue2.add(Integer.valueOf(4));
        localPriorityQueue2.add(Integer.valueOf(1));
        this.map.put("inception", localPriorityQueue2);

        PriorityQueue localPriorityQueue3 = new PriorityQueue();
        localPriorityQueue3.add(Integer.valueOf(4));
        localPriorityQueue3.add(Integer.valueOf(5));
        localPriorityQueue3.add(Integer.valueOf(1));
        localPriorityQueue3.add(Integer.valueOf(3));
        localPriorityQueue3.add(Integer.valueOf(5));
        this.map.put("ratatouille", localPriorityQueue3);

        PriorityQueue localPriorityQueue4 = new PriorityQueue();
        localPriorityQueue4.add(Integer.valueOf(4));
        localPriorityQueue4.add(Integer.valueOf(3));
        this.map.put("grease", localPriorityQueue4);
    }

    @Test
    public void testNull()
    {
        try
        {
            List localList = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating(null, 2);
            if (localList == null) {
                Assert.fail("getAlphabeticalMoviesAboveRating should return empty List when input is null");
            }
            Assert.assertTrue("getAlphabeticalMoviesAboveRating should return empty List when input is null", localList.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("getAlphabeticalMoviesAboveRating throws " + localException + " when input is null");
        }
    }

    @Test
    public void testEmpty()
    {
        try
        {
            List localList = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating(new TreeMap(), 2);
            if (localList == null) {
                Assert.fail("getAlphabeticalMoviesAboveRating should return empty List when input is empty");
            }
            Assert.assertTrue("getAlphabeticalMoviesAboveRating should return empty List when input is empty", localList.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("getAlphabeticalMoviesAboveRating throws " + localException + " when input is empty");
        }
    }

    @Test
    public void testReturnMoviesAbove()
    {
        try
        {
            List localList = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating(this.map, 2);
            if (localList == null) {
                Assert.fail("getAlphabeticalMoviesAboveRating returns null for valid input");
            }
            Assert.assertEquals("getAlphabeticalMoviesAboveRating returns List with incorrect number of entries when some movies are above threshold", 2L, localList.size());

            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when some movies are above threshold", localList.contains("sabrina"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when some movies are above threshold", localList.contains("grease"));

            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when some movies are above threshold", ((String)localList.get(0)).equals("grease"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when some movies are above threshold", ((String)localList.get(1)).equals("sabrina"));
        }
        catch (Exception localException)
        {
            Assert.fail("getAlphabeticalMoviesAboveRating throws " + localException + " for valid input");
        }
    }

    @Test
    public void testReturnMoviesAboveNotEqual()
    {
        try
        {
            List localList = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating(this.map, 1);
            if (localList == null) {
                Assert.fail("getAlphabeticalMoviesAboveRating returns null for valid input");
            }
            Assert.assertEquals("getAlphabeticalMoviesAboveRating returns List with incorrect number of entries when some movies' minimum rating equals threshold", 2L, localList.size());

            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when some movies' minimum rating equals threshold", localList.contains("sabrina"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when some movies' minimum rating equals threshold", localList.contains("grease"));

            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when some movies' minimum rating equals threshold", ((String)localList.get(0)).equals("grease"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when some movies' minimum rating equals threshold", ((String)localList.get(1)).equals("sabrina"));
        }
        catch (Exception localException)
        {
            Assert.fail("getAlphabeticalMoviesAboveRating throws " + localException + " for valid input");
        }
    }

    @Test
    public void testAllMoviesBelowThreshold()
    {
        try
        {
            List localList = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating(this.map, 8);
            if (localList == null) {
                Assert.fail("getAlphabeticalMoviesAboveRating returns null when all movies' minimum rating is below threshold");
            }
            Assert.assertTrue("getAlphabeticalMoviesAboveRating should return empty List when all movies' minimum rating is below threshold", localList.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("getAlphabeticalMoviesAboveRating throws " + localException + " when all movies' minimum rating is below threshold");
        }
    }

    @Test
    public void testAllMoviesAbove()
    {
        try
        {
            List localList = MovieRatingsProcessor.getAlphabeticalMoviesAboveRating(this.map, 0);
            if (localList == null) {
                Assert.fail("getAlphabeticalMoviesAboveRating returns null when all movies are above threshold");
            }
            Assert.assertEquals("getAlphabeticalMoviesAboveRating returns List with incorrect number of entries when all movies are above threshold", 4L, localList.size());

            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when all movies are above threshold", localList.contains("sabrina"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when all movies are above threshold", localList.contains("grease"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when all movies are above threshold", localList.contains("inception"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with incorrect elements when all movies are above threshold", localList.contains("ratatouille"));

            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when all movies are above threshold", ((String)localList.get(0)).equals("grease"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when all movies are above threshold", ((String)localList.get(1)).equals("inception"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when all movies are above threshold", ((String)localList.get(2)).equals("ratatouille"));
            Assert.assertTrue("getAlphabeticalMoviesAboveRating returns List with elements not in sorted order when all movies are above threshold", ((String)localList.get(3)).equals("sabrina"));
        }
        catch (Exception localException)
        {
            Assert.fail("getAlphabeticalMoviesAboveRating throws " + localException + " when all movies are above threshold");
        }
    }
}
