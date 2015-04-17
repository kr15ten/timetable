package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kris on 4/15/15.
 */
public class SubjectTest
{
    private Subject sub;

    @Before
    public void setUp() throws Exception
    {
        sub = new Subject.Builder("TPG300S").credits(40).name("Technical Programming").build();
    }


    @Test
    public void test() throws Exception
    {
        Assert.assertEquals(40, sub.getCredits());
    }
}
