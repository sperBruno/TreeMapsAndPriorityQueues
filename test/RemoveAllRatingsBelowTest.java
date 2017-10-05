/**
 * Created by bruno on 04-10-17.
 */
import java.util.PriorityQueue;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RemoveAllRatingsBelowTest
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
        localPriorityQueue3.add(Integer.valueOf(1));
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
            TreeMap localTreeMap = MovieRatingsProcessor.removeAllRatingsBelow(null, 2);
            if (localTreeMap == null) {
                Assert.fail("removeAllRatingsBelow should return empty List when input is null");
            }
            Assert.assertTrue("removeAllRatingsBelow should return empty List when input is null", localTreeMap.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("removeAllRatingsBelow throws " + localException + " when input is null");
        }
    }

    @Test
    public void testEmpty()
    {
        try
        {
            TreeMap localTreeMap = MovieRatingsProcessor.removeAllRatingsBelow(new TreeMap(), 2);
            if (localTreeMap == null) {
                Assert.fail("removeAllRatingsBelow should return empty List when input is empty");
            }
            Assert.assertTrue("removeAllRatingsBelow should return empty List when input is empty", localTreeMap.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("removeAllRatingsBelow throws " + localException + " when input is empty");
        }
    }

    @Test
    public void testModifySomeMovies()
    {
        try
        {
            TreeMap localTreeMap = MovieRatingsProcessor.removeAllRatingsBelow(this.map, 2);
            if (localTreeMap == null) {
                Assert.fail("removeAllRatingsBelow returns null when some movies have ratings to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect number of entries when some movies have ratings to be removed", 2L, localTreeMap.size());
            if (!localTreeMap.containsKey("inception")) {
                Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when some movies have ratings to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when some movies have ratings to be removed", 1L, ((Integer)localTreeMap.get("inception")).intValue());
            if (!localTreeMap.containsKey("ratatouille")) {
                Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when some movies have ratings to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when some movies have ratings to be removed", 2L, ((Integer)localTreeMap.get("ratatouille")).intValue());

            Assert.assertEquals("removeAllRatingsBelow removes some entries from input TreeMap when some movies have ratings to be removed", 4L, this.map.size());

            PriorityQueue localPriorityQueue = (PriorityQueue)this.map.get("inception");
            if (localPriorityQueue == null) {
                Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when some movies have ratings to be removed");
            }
            if (localPriorityQueue.size() != 1) {
                Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when some movies have ratings to be removed");
            }
            if (((Integer)localPriorityQueue.peek()).intValue() < 2) {
                Assert.fail("removeAllRatingsBelow does not remove ratings below threshold in input TreeMap when some movies have ratings to be removed");
            }
            localPriorityQueue = (PriorityQueue)this.map.get("ratatouille");
            if (localPriorityQueue == null) {
                Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when some movies have ratings to be removed");
            }
            if (localPriorityQueue.size() != 3) {
                Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when some movies have ratings to be removed");
            }
            if (((Integer)localPriorityQueue.remove()).intValue() < 2) {
                Assert.fail("removeAllRatingsBelow does not remove ratings below threshold in input TreeMap when some movies have ratings to be removed");
            }
            if (((Integer)localPriorityQueue.remove()).intValue() < 2) {
                Assert.fail("removeAllRatingsBelow does not remove ratings below threshold in input TreeMap when some movies have ratings to be removed");
            }
        }
        catch (Exception localException)
        {
            Assert.fail("removeAllRatingsBelow throws " + localException + " when some movies have ratings to be removed");
        }
    }

    @Test
    public void testModifyNoMovies()
    {
        try
        {
            TreeMap localTreeMap = MovieRatingsProcessor.removeAllRatingsBelow(this.map, 0);
            if (localTreeMap == null) {
                Assert.fail("removeAllRatingsBelow returns null when no movies have ratings to be removed");
            }
            Assert.assertTrue("removeAllRatingsBelow should return empty TreeMap when no movies have ratings to be removed", localTreeMap.isEmpty());

            PriorityQueue localPriorityQueue = (PriorityQueue)this.map.get("sabrina");
            if (localPriorityQueue == null) {
                Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when no movies have ratings to be removed");
            }
            if (localPriorityQueue.size() != 2) {
                Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when no movies have ratings to be removed");
            }
            localPriorityQueue = (PriorityQueue)this.map.get("inception");
            if (localPriorityQueue == null) {
                Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when no movies have ratings to be removed");
            }
            if (localPriorityQueue.size() != 2) {
                Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when no movies have ratings to be removed");
            }
            localPriorityQueue = (PriorityQueue)this.map.get("ratatouille");
            if (localPriorityQueue == null) {
                Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when no movies have ratings to be removed");
            }
            if (localPriorityQueue.size() != 5) {
                Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when no movies have ratings to be removed");
            }
            localPriorityQueue = (PriorityQueue)this.map.get("grease");
            if (localPriorityQueue == null) {
                Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when no movies have ratings to be removed");
            }
            if (localPriorityQueue.size() != 2) {
                Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when no movies have ratings to be removed");
            }
        }
        catch (Exception localException)
        {
            Assert.fail("removeAllRatingsBelow throws " + localException + " when no movies have ratings to be removed");
        }
    }

    @Test
    public void testRemoveAllRatings()
    {
        try
        {
            TreeMap localTreeMap = MovieRatingsProcessor.removeAllRatingsBelow(this.map, 10);
            if (localTreeMap == null) {
                Assert.fail("removeAllRatingsBelow returns null when all ratings for all movies are to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect number of entries when all ratings for all movies are to be removed", 4L, localTreeMap.size());
            if (!localTreeMap.containsKey("sabrina")) {
                Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when all ratings for all movies are to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when all ratings for all movies are to be removed", 2L, ((Integer)localTreeMap.get("sabrina")).intValue());
            if (!localTreeMap.containsKey("inception")) {
                Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when all ratings for all movies are to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when all ratings for all movies are to be removed", 2L, ((Integer)localTreeMap.get("inception")).intValue());
            if (!localTreeMap.containsKey("ratatouille")) {
                Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when all ratings for all movies are to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when all ratings for all movies are to be removed", 5L, ((Integer)localTreeMap.get("ratatouille")).intValue());
            if (!localTreeMap.containsKey("grease")) {
                Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when all ratings for all movies are to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when all ratings for all movies are to be removed", 2L, ((Integer)localTreeMap.get("grease")).intValue());

            Assert.assertTrue("removeAllRatingsBelow should return remove all elements from input TreeMap when all ratings for all movies are to be removed", this.map.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("removeAllRatingsBelow throws " + localException + " when all ratings for all movies are to be removed");
        }
    }

    @Test
    public void testRemoveBelowButNotEqual()
    {
        this.map.remove("sabrina");
        this.map.remove("grease");
        this.map.remove("inception");
        try
        {
            TreeMap localTreeMap = MovieRatingsProcessor.removeAllRatingsBelow(this.map, 4);
            if (localTreeMap == null) {
                Assert.fail("removeAllRatingsBelow returns null when some movies have ratings to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect number of entries when some movies have ratings to be removed", 1L, localTreeMap.size());
            if (!localTreeMap.containsKey("ratatouille")) {
                Assert.fail("removeAllRatingsBelow returns TreeMap with incorrect entry when some movies have ratings to be removed");
            }
            Assert.assertEquals("removeAllRatingsBelow returns TreeMap with incorrect value of ratings removed when some movies have ratings that are equal to threshold", 2L, ((Integer)localTreeMap.get("ratatouille")).intValue());

            PriorityQueue localPriorityQueue = (PriorityQueue)this.map.get("ratatouille");
            if (localPriorityQueue == null) {
                Assert.fail("removeAllRatingsBelow removes some entries from input TreeMap when some movies have ratings equal to threshold");
            }
            if (localPriorityQueue.size() != 3) {
                Assert.fail("removeAllRatingsBelow does not correctly remove ratings from input TreeMap when some movies have ratings equal to threshold");
            }
        }
        catch (Exception localException)
        {
            Assert.fail("removeAllRatingsBelow throws " + localException + " when some movies have ratings to be removed");
        }
    }
}

