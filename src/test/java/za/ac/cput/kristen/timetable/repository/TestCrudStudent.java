package za.ac.cput.kristen.timetable.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.domain.Student;

/**
 * Created by kris on 5/3/15.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudStudent extends AbstractTestNGSpringContextTests
{
    private Long studNo;

    @Autowired
    private StudentRepository repository;


    /*@Test
    public void create() throws Exception
    {
        Student student = new Student.Builder("Paul", "Patter")
                .courseYear(2)
                .build();
        repository.save(student);
        studNo = student.getStudNo();

        Assert.assertNotNull(student.getStudNo());
    }


    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Student student = repository.findOne(studNo);

        Assert.assertEquals("Paul", student.getName());
    }


    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Student newStudent = new Student.Builder("Rob", "Ray")
                .creditsEarned(29)
                .build();
        repository.save(newStudent);

        studNo = newStudent.getStudNo();
        Student updatedStudent = repository.findOne(studNo);

        Assert.assertEquals("Rob", updatedStudent.getName());
    }


    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Student student = repository.findOne(studNo);
        repository.delete(student);
        Student newStudent = repository.findOne(studNo);

        Assert.assertNull(newStudent);
    }


    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }*/
}
