package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kris on 4/15/15.
 */
public class RoomTest
{
    private Room room;

    @Before
    public void setUp() throws Exception
    {
        room = new Room.Builder("4.12").lab(true).size(23).build();
    }


    @Test
    public void testRoom() throws Exception
    {
        Assert.assertEquals(true, room.getLab());
    }
}
