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
import za.ac.cput.kristen.timetable.conf.factory.SubjectFactory;
import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Subject;
import za.ac.cput.kristen.timetable.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/17/15.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class SubjectServiceTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private SubjectService service;

    private String code;

    @Autowired
    private SubjectRepository repository;
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
        lessons.add(less1);

        Subject subject = SubjectFactory.createSubject("TP", "Technical Programming", 13, lessons);

        repository.save(subject);
        code = subject.getCode();

        Assert.assertNotNull(subject.getCode());
    }


    @Test(dependsOnMethods = "create")
    public void testGetSubjectLessons() throws Exception
    {
        lessons = service.getLessons(code);
        Assert.assertEquals(1, lessons.size());
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
