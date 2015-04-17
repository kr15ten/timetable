package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        start = new Date(2014, 04, 02);
        end = new Date(2014, 06, 15);
        termslot = new Termslot.Builder(start, end).term(2).build();
    }


    @Test
    public void test() throws Exception
    {
        Assert.assertEquals(2, termslot.getTerm());
    }
}
