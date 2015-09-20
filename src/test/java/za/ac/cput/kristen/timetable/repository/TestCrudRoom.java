package za.ac.cput.kristen.timetable.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.domain.Room;

/**
 * Created by kris on 5/7/15.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudRoom extends AbstractTestNGSpringContextTests
{
    private String roomNo;

    @Autowired
    private RoomRepository repository;


    @Test
    public void create() throws Exception
    {
        Room room = new Room.Builder("3.15")
                .lab(true)
                .build();
        repository.save(room);
        roomNo = room.getRoomNumber();


        Assert.assertNotNull(room.getRoomNumber());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Room room = repository.findOne(roomNo);

        Assert.assertEquals("3.15", room.getRoomNumber());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Room newRoom = new Room.Builder("4A")
                .build();

        repository.save(newRoom);
        roomNo = newRoom.getRoomNumber();
        Room updatedRoom = repository.findOne(roomNo);

        Assert.assertEquals("4A", updatedRoom.getRoomNumber());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Room room = repository.findOne(roomNo);
        repository.delete(room);
        Room newRoom = repository.findOne(roomNo);

        Assert.assertNull(newRoom);
    }


    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
