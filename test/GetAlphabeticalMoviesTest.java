/**
 * Created by bruno on 04-10-17.
 */
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetAlphabeticalMoviesTest
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
    }

    @Test
    public void testNull()
    {
        try
        {
            List localList = MovieRatingsProcessor.getAlphabeticalMovies(null);
            if (localList == null) {
                Assert.fail("getAlphabeticalMovies should return empty List when input is null");
            }
            Assert.assertTrue("getAlphabeticalMovies should return empty List when input is null", localList.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("getAlphabeticalMovies throws " + localException + " when input is null");
        }
    }

    @Test
    public void testEmpty()
    {
        try
        {
            List localList = MovieRatingsProcessor.getAlphabeticalMovies(new TreeMap());
            if (localList == null) {
                Assert.fail("getAlphabeticalMovies should return empty List when input is empty");
            }
            Assert.assertTrue("getAlphabeticalMovies should return empty List when input is empty", localList.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("getAlphabeticalMovies throws " + localException + " when input is empty");
        }
    }

    @Test
    public void testValidInput()
    {
        try
        {
            List localList = MovieRatingsProcessor.getAlphabeticalMovies(this.map);
            if (localList == null) {
                Assert.fail("getAlphabeticalMovies returns null for valid input");
            }
            Assert.assertEquals("getAlphabeticalMovies returns List with incorrect number of entries for valid input", 3L, localList.size());

            Assert.assertTrue("getAlphabeticalMovies returns List with incorrect elements for valid input", localList.contains("sabrina"));
            Assert.assertTrue("getAlphabeticalMovies returns List with incorrect elements for valid input", localList.contains("inception"));
            Assert.assertTrue("getAlphabeticalMovies returns List with incorrect elements for valid input", localList.contains("ratatouille"));

            Assert.assertTrue("getAlphabeticalMovies returns List with elements not in sorted order for valid input", ((String)localList.get(0)).equals("inception"));
            Assert.assertTrue("getAlphabeticalMovies returns List with elements not in sorted order for valid input", ((String)localList.get(1)).equals("ratatouille"));
            Assert.assertTrue("getAlphabeticalMovies returns List with elements not in sorted order for valid input", ((String)localList.get(2)).equals("sabrina"));
        }
        catch (Exception localException)
        {
            Assert.fail("getAlphabeticalMovies throws " + localException + " for valid input");
        }
    }
}

