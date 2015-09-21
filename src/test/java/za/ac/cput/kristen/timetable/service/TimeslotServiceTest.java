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
import za.ac.cput.kristen.timetable.conf.factory.TimeslotFactory;
import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Timeslot;
import za.ac.cput.kristen.timetable.repository.TimeslotRepository;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/17/15.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TimeslotServiceTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private TimeslotService service;

    private Long id;

    @Autowired
    private TimeslotRepository repository;
    private List<Lesson> lessons;
    private Time start, end;

    @BeforeMethod
    public void setUp() throws Exception
    {
        lessons = new ArrayList<Lesson>();
        start = new Time(8, 30, 00);
        end = new Time(9, 55, 00);
    }


    @Test
    public void create() throws Exception
    {
        Lesson less1 = LessonFactory.createLesson("Topic", false);
        Lesson less2 = LessonFactory.createLesson("Topic2", false);
        Lesson less3 = LessonFactory.createLesson("Topic3", false);
        lessons.add(less1);
        lessons.add(less2);
        lessons.add(less3);

        Timeslot timeslot = TimeslotFactory.createTimeslot("Wednesday", start, end, 0, lessons);

        repository.save(timeslot);
        id = timeslot.getId();

        Assert.assertNotNull(timeslot.getId());
    }


    @Test(dependsOnMethods = "create")
    public void testGetTimeslotLessons() throws Exception
    {
        lessons = service.getLessons(id);
        Assert.assertEquals(3, lessons.size());
    }


    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
