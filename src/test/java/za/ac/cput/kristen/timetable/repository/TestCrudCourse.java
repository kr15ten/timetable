package za.ac.cput.kristen.timetable.repository;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.domain.Course;


/**
 * Created by kris on 5/3/15.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudCourse extends AbstractTestNGSpringContextTests
{

    private String code;

    @Autowired
    private CourseRepository repository;


    @Test
    public void create() throws Exception
    {
        Course course = new Course.Builder("ND: IT")
                .credits(400)
                .name("ND: Information Technology")
                .qualification("National Diploma")
                .build();
        repository.save(course);
        code = course.getCourseCode();

        Assert.assertNotNull(course.getCourseCode());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Course course = repository.findOne(code);

        Assert.assertEquals("ND: IT", course.getCourseCode());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Course newCourse = new Course.Builder("BTech: IT")
                .credits(450)
                .name("BTech: Information Technology")
                .qualification("Bachelor of Technology")
                .build();

        repository.save(newCourse);
        code = newCourse.getCourseCode();
        Course updatedCourse = repository.findOne(code);

        Assert.assertEquals("BTech: IT", updatedCourse.getCourseCode());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Course course = repository.findOne(code);
        repository.delete(course);
        Course newCourse = repository.findOne(code);
        Assert.assertNull(newCourse);
    }


    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
