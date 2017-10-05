/**
 * Created by bruno on 04-10-17.
 */
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParseMovieRatingsTest
{
    List<UserMovieRating> ratings;

    @Before
    public void setUp()
    {
        this.ratings = new LinkedList();

        this.ratings.add(new UserMovieRating("singles", 5));
        this.ratings.add(new UserMovieRating("singles", 4));

        this.ratings.add(new UserMovieRating("zootopia", 4));
        this.ratings.add(new UserMovieRating("zootopia", 2));
    }

    @Test
    public void testNull()
    {
        try
        {
            TreeMap localTreeMap = MovieRatingsParser.parseMovieRatings(null);
            if (localTreeMap == null) {
                Assert.fail("parseMovieRatings should return empty TreeMap when input is null");
            }
            Assert.assertTrue("parseMovieRatings should return empty TreeMap when input is null", localTreeMap.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("parseMovieRatings throws " + localException + " when input is null");
        }
    }

    @Test
    public void testEmpty()
    {
        try
        {
            TreeMap localTreeMap = MovieRatingsParser.parseMovieRatings(new LinkedList());
            if (localTreeMap == null) {
                Assert.fail("parseMovieRatings should return empty TreeMap when input is empty");
            }
            Assert.assertTrue("parseMovieRatings should return empty TreeMap when input is empty", localTreeMap.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("parseMovieRatings throws " + localException + " when input is empty");
        }
    }

    @Test
    public void testNormalInput()
    {
        try
        {
            TreeMap localTreeMap = MovieRatingsParser.parseMovieRatings(this.ratings);
            if (localTreeMap == null) {
                Assert.fail("parseMovieRatings returns null for valid input List");
            }
            Assert.assertEquals("TreeMap returned by parseMovieRatings has incorrect number of entries for valid input List", 2L, localTreeMap.size());

            PriorityQueue localPriorityQueue = (PriorityQueue)localTreeMap.get("singles");
            if (localPriorityQueue == null) {
                Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys for valid input List");
            }
            int i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values for valid input List", 4L, i);
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values for valid input List", 5L, i);
            Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries for valid input List", localPriorityQueue.isEmpty());

            localPriorityQueue = (PriorityQueue)localTreeMap.get("zootopia");
            if (localPriorityQueue == null) {
                Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys for valid input List");
            }
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values for valid input List", 2L, i);
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values for valid input List", 4L, i);
            Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries for valid input List", localPriorityQueue.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("parseMovieRatings throws " + localException + " for valid input List");
        }
    }

    @Test
    public void testIgnoreNullRating()
    {
        this.ratings.add(null);
        try
        {
            TreeMap localTreeMap = MovieRatingsParser.parseMovieRatings(this.ratings);
            if (localTreeMap == null) {
                Assert.fail("parseMovieRatings returns null when input List contains null rating");
            }
            Assert.assertEquals("TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains null rating", 2L, localTreeMap.size());

            PriorityQueue localPriorityQueue = (PriorityQueue)localTreeMap.get("singles");
            if (localPriorityQueue == null) {
                Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains null rating");
            }
            int i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains null rating", 4L, i);
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains null rating", 5L, i);
            Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains null rating", localPriorityQueue.isEmpty());

            localPriorityQueue = (PriorityQueue)localTreeMap.get("zootopia");
            if (localPriorityQueue == null) {
                Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains null rating");
            }
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains null rating", 2L, i);
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains null rating", 4L, i);
            Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains null rating", localPriorityQueue.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("parseMovieRatings throws " + localException + " when input List contains null rating");
        }
    }

    @Test
    public void testIgnoreNullTitle()
    {
        this.ratings.add(new UserMovieRating(null, 5));
        try
        {
            TreeMap localTreeMap = MovieRatingsParser.parseMovieRatings(this.ratings);
            if (localTreeMap == null) {
                Assert.fail("parseMovieRatings returns null when input List contains rating with null title");
            }
            Assert.assertEquals("TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with null title", 2L, localTreeMap.size());

            PriorityQueue localPriorityQueue = (PriorityQueue)localTreeMap.get("singles");
            if (localPriorityQueue == null) {
                Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with null title");
            }
            int i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with null title", 4L, i);
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with null title", 5L, i);
            Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with null title", localPriorityQueue.isEmpty());

            localPriorityQueue = (PriorityQueue)localTreeMap.get("zootopia");
            if (localPriorityQueue == null) {
                Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with null title");
            }
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with null title", 2L, i);
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with null title", 4L, i);
            Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with null title", localPriorityQueue.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("parseMovieRatings throws " + localException + " when input List contains rating with null title");
        }
    }

    @Test
    public void testIgnoreEmptyTitle()
    {
        this.ratings.add(new UserMovieRating("", 5));
        try
        {
            TreeMap localTreeMap = MovieRatingsParser.parseMovieRatings(this.ratings);
            if (localTreeMap == null) {
                Assert.fail("parseMovieRatings returns null when input List contains rating with empty title");
            }
            Assert.assertEquals("TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with empty title", 2L, localTreeMap.size());

            PriorityQueue localPriorityQueue = (PriorityQueue)localTreeMap.get("singles");
            if (localPriorityQueue == null) {
                Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with empty title");
            }
            int i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with empty title", 4L, i);
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with empty title", 5L, i);
            Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with empty title", localPriorityQueue.isEmpty());

            localPriorityQueue = (PriorityQueue)localTreeMap.get("zootopia");
            if (localPriorityQueue == null) {
                Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with empty title");
            }
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with empty title", 2L, i);
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with empty title", 4L, i);
            Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with empty title", localPriorityQueue.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("parseMovieRatings throws " + localException + " when input List contains rating with empty title");
        }
    }

    @Test
    public void testIgnoreNegativeRating()
    {
        this.ratings.add(new UserMovieRating("Singles", -4));
        try
        {
            TreeMap localTreeMap = MovieRatingsParser.parseMovieRatings(this.ratings);
            if (localTreeMap == null) {
                Assert.fail("parseMovieRatings returns null when input List contains rating with negative rating");
            }
            Assert.assertEquals("TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with negative rating", 2L, localTreeMap.size());

            PriorityQueue localPriorityQueue = (PriorityQueue)localTreeMap.get("singles");
            if (localPriorityQueue == null) {
                Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with negative rating");
            }
            int i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with negative rating", 4L, i);
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with negative rating", 5L, i);
            Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with negative rating", localPriorityQueue.isEmpty());

            localPriorityQueue = (PriorityQueue)localTreeMap.get("zootopia");
            if (localPriorityQueue == null) {
                Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains rating with negative rating");
            }
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with negative rating", 2L, i);
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains rating with negative rating", 4L, i);
            Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains rating with negative rating", localPriorityQueue.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("parseMovieRatings throws " + localException + " when input List contains rating with negative rating");
        }
    }

    @Test
    public void testIgnoreCase()
    {
        this.ratings.add(new UserMovieRating("ZOOTOPIA", 3));
        try
        {
            TreeMap localTreeMap = MovieRatingsParser.parseMovieRatings(this.ratings);
            if (localTreeMap == null) {
                Assert.fail("parseMovieRatings returns null when input List contains movies with same case-insensitive titles");
            }
            Assert.assertEquals("TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains movies with same case-insensitive titles", 2L, localTreeMap.size());

            PriorityQueue localPriorityQueue = (PriorityQueue)localTreeMap.get("singles");
            if (localPriorityQueue == null) {
                Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains movies with same case-insensitive titles");
            }
            int i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains movies with same case-insensitive titles", 4L, i);
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains movies with same case-insensitive titles", 5L, i);
            Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains movies with same case-insensitive titles", localPriorityQueue.isEmpty());

            localPriorityQueue = (PriorityQueue)localTreeMap.get("zootopia");
            if (localPriorityQueue == null) {
                Assert.fail("TreeMap returned by parseMovieRatings has incorrect keys when input List contains movies with same case-insensitive titles");
            }
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains movies with same case-insensitive titles", 2L, i);
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains movies with same case-insensitive titles", 3L, i);
            i = ((Integer)localPriorityQueue.remove()).intValue();
            Assert.assertEquals("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect values when input List contains movies with same case-insensitive titles", 4L, i);
            Assert.assertTrue("PriorityQueue in TreeMap returned by parseMovieRatings has incorrect number of entries when input List contains movies with same case-insensitive titles", localPriorityQueue.isEmpty());
        }
        catch (Exception localException)
        {
            Assert.fail("parseMovieRatings throws " + localException + " when input List contains movies with same case-insensitive titles");
        }
    }
}

