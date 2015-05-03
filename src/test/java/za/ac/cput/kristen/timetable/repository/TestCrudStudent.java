package za.ac.cput.kristen.timetable.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.domain.Student;

/**
 * Created by kris on 5/3/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudStudent
{
    private Long studNo;

    @Autowired
    private StudentRepository repository;


    @Test
    public void create() throws Exception
    {
        Student student = new Student.Builder(Long.valueOf(1123), "Paul", "Patter")
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

        Assert.assertEquals(Long.valueOf(1123), student.getStudNo());
    }


    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Student student = repository.findOne(studNo);
        Student newStudent = new Student.Builder(Long.valueOf(2234), "Rob", "Ray")
                .creditsEarned(29)
                .build();
        repository.save(newStudent);

        Assert.assertEquals(Long.valueOf(2234), student.getStudNo());
    }


    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Student student = repository.findOne(studNo);
        repository.delete(student);
        Student newStudent = repository.findOne(studNo);

        Assert.assertNull(newStudent);
    }
}
