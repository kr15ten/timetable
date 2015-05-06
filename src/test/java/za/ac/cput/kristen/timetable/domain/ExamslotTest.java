package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.kristen.timetable.conf.factory.ExamslotFactory;

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
        examslot = ExamslotFactory.createExamslot(2, start, end);
    }


    @Test
    public void testCreateExamslot() throws Exception
    {
        Assert.assertEquals(2, examslot.getTerm());
    }

    @Test
    public void testUpdateExamslot() throws Exception
    {
        Examslot newExamslot = new Examslot
                .Builder(examslot.getStartDate(), examslot.getEndDate())
                .copy(examslot)
                .term(3)
                .build();

        Assert.assertEquals(3, newExamslot.getTerm());
    }
}
