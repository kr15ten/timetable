package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.kristen.timetable.conf.factory.SubjectFactory;

/**
 * Created by kris on 4/15/15.
 */
public class SubjectTest
{
    private Subject sub1;

    @Before
    public void setUp() throws Exception
    {
        sub1 = SubjectFactory.createSubject("TP200S", "Technical Programming", 40);    }


    @Test
    public void testCreateSubject() throws Exception
    {
        Assert.assertEquals(40, sub1.getCredits());
    }

    @Test
    public void testUpdateSubject() throws Exception
    {
        Subject newSub = new Subject
                .Builder(sub1.getCode())
                .copy(sub1)
                .credits(20)
                .build();
        Assert.assertEquals(20, newSub.getCredits());
    }
}
