package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

/**
 * Created by kris on 4/15/15.
 */
public class TimeslotTest
{
    private Timeslot timeslot;
    private Time start, end;

    @Before
    public void setUp() throws Exception
    {
        start = new Time(8, 30, 00);
        end = new Time(9, 55, 00);
        timeslot = new Timeslot.Builder("Wednesday", start, end).build();
    }


    @Test
    public void test() throws Exception
    {
        Assert.assertEquals(55, timeslot.getEnd().getMinutes());
    }
}
