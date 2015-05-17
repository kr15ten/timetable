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
import za.ac.cput.kristen.timetable.conf.factory.CourseFactory;
import za.ac.cput.kristen.timetable.conf.factory.SubjectFactory;
import za.ac.cput.kristen.timetable.domain.Course;
import za.ac.cput.kristen.timetable.domain.Subject;
import za.ac.cput.kristen.timetable.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/17/15.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CourseServiceTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private CourseService service;

    private String courseCode;

    @Autowired
    private CourseRepository repository;
    private List<Subject> subjects;

    @BeforeMethod
    public void setUp() throws Exception
    {
        subjects = new ArrayList<Subject>();
    }


    @Test
    public void create() throws Exception
    {
        Subject sub1 = SubjectFactory.createSubject("TPblah", "Technical Programming", 40, null);
        Subject sub2 = SubjectFactory.createSubject("NP00", "National Pottery", 5, null);

        subjects.add(sub1);
        subjects.add(sub2);

        Course course = CourseFactory.createCourse("IT", null, null, 3, 400, subjects);

        repository.save(course);
        courseCode = course.getCourseCode();

        Assert.assertNotNull(course.getCourseCode());
    }


    @Test
    public void testGetCourseSubjects() throws Exception
    {
        subjects = service.getSubjects(courseCode);
        Assert.assertEquals(2, subjects.size());
    }


    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
