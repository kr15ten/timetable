package za.ac.cput.kristen.timetable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.conf.factory.LessonFactory;
import za.ac.cput.kristen.timetable.conf.factory.RoomFactory;
import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Room;
import za.ac.cput.kristen.timetable.repository.RoomRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/17/15.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class RoomServiceTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private RoomService service;

    private String id;

    @Autowired
    private RoomRepository repository;
    private List<Lesson> lessons;

    @BeforeMethod
    public void setUp() throws Exception
    {
        lessons = new ArrayList<Lesson>();
    }


    @Test
    public void create() throws Exception
    {
        Lesson less1 = LessonFactory.createLesson("Topic", false);
        Lesson less2 = LessonFactory.createLesson("Topic2", false);
        Lesson less3 = LessonFactory.createLesson("Topic3", true);
        lessons.add(less1);
        lessons.add(less2);
        lessons.add(less3);

        Room room = RoomFactory.createRoom("3.12", 24, true, lessons);

        repository.save(room);
        id = room.getRoomNumber();

        Assert.assertNotNull(room.getRoomNumber());
    }


    @Test(dependsOnMethods = "create")
    public void testGetRoomLessons() throws Exception
    {
        List<Lesson> lessons = service.getLessons(id);
        Assert.assertEquals(3, lessons.size());
    }


    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
