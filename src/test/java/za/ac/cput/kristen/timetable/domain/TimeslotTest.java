package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.kristen.timetable.conf.factory.TimeslotFactory;

import java.sql.Time;

/**
 * Created by kris on 4/15/15.
 */
public class TimeslotTest
{
    private Timeslot timeslot;
    private Time tStart, tEnd;

    @Before
    public void setUp() throws Exception
    {
        timeslot = TimeslotFactory.createTimeslot("Wednesday", tStart, tEnd, 0);
        tStart = new Time(8, 30, 00);
        tEnd = new Time(9, 55, 00);
    }


    @Test
    public void testCreateTimeslot() throws Exception
    {
        Assert.assertEquals(0 , timeslot.getRotationalWeek());
    }

    @Test
    public void testUpdateTimeslot() throws Exception
    {
        Timeslot newTimeslot = new Timeslot
                .Builder("Thursday", timeslot.getStart(), timeslot.getEnd())
                .copy(timeslot)
                .rotationalWeek(2)
                .build();
        Assert.assertEquals(2, newTimeslot.getRotationalWeek());
    }
}
