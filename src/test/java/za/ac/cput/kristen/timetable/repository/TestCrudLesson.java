package za.ac.cput.kristen.timetable.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.domain.Lesson;

/**
 * Created by kris on 5/12/15.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudLesson extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private LessonRepository repository;


    @Test
    public void create() throws Exception
    {
        Lesson lesson = new Lesson.Builder()
                .topic("Making pies")
                .build();
        repository.save(lesson);
        id = lesson.getId();

        Assert.assertNotNull(lesson.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Lesson lesson = repository.findOne(id);

        Assert.assertEquals("Making pies", lesson.getTopic());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Lesson newLesson = new Lesson.Builder()
                .topic("none")
                .build();

        repository.save(newLesson);
        id = newLesson.getId();
        Lesson updatedLesson = repository.findOne(id);

        Assert.assertEquals("none", updatedLesson.getTopic());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Lesson lesson = repository.findOne(id);
        repository.delete(lesson);
        Lesson newLesson = repository.findOne(id);
        Assert.assertNull(newLesson);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
