package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.kristen.timetable.conf.factory.RoomFactory;

/**
 * Created by kris on 4/15/15.
 */
public class RoomTest
{
    private Room room;

    @Before
    public void setUp() throws Exception
    {
        room = RoomFactory.createRoom("1.12", 38, true, null);
    }


    @Test
    public void testCreateRoom() throws Exception
    {
        Assert.assertEquals(true, room.getLab());
    }

    @Test
    public void testUpdateRoom() throws Exception
    {
        Room newRoom = new Room
                .Builder(room.getRoomNumber())
                .copy(room)
                .lab(false)
                .build();
        Assert.assertEquals(false, newRoom.getLab());
    }
}
