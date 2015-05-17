package za.ac.cput.kristen.timetable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.conf.factory.LessonFactory;
import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.repository.LessonRepository;

/**
 * Created by kris on 5/17/15.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class LessonServiceTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private LessonService service;

    private Long id;

    @Autowired
    private LessonRepository repository;


    @Test
    public void create() throws Exception
    {
        Lesson lesson = LessonFactory.createLesson("Topic", false);

        repository.save(lesson);
        id = lesson.getId();

        Assert.assertNotNull(lesson.getId());
    }


    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
