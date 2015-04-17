package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by kris on 4/15/15.
 */
public class ExamslotTest
{
    private Examslot examslot;
    private Date start, end;

    @Before
    public void setUp() throws Exception
    {
        start = new Date(2015, 05, 25);
        end = new Date(2015, 06, 12);
        examslot = new Examslot.Builder(start, end).term(2).build();
    }


    @Test
    public void testExamslot() throws Exception
    {
        Assert.assertEquals(05, examslot.getStartDate().getMonth());
    }
}
