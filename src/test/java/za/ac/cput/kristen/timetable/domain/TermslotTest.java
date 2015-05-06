package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.kristen.timetable.conf.factory.TermslotFactory;

import java.util.Date;

/**
 * Created by kris on 4/15/15.
 */
public class TermslotTest
{
    private Termslot termslot;
    private Date start, end;

    @Before
    public void setUp() throws Exception
    {
        start = new Date(2015, 05, 25);
        end = new Date(2015, 06, 12);
        termslot = TermslotFactory.createTermslot(2, start, end);
    }


    @Test
    public void testCreateTermslot() throws Exception
    {
        Assert.assertEquals(2, termslot.getTerm());
    }

    @Test
    public void testUpdateTermslot() throws Exception
    {
        Termslot newTermslot = new Termslot
                .Builder(termslot.getStartDate(), termslot.getEndDate())
                .term(4)
                .build();
        Assert.assertEquals(4, newTermslot.getTerm());
    }
}
