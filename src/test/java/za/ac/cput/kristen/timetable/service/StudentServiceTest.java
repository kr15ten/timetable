package za.ac.cput.kristen.timetable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.conf.factory.StudentFactory;
import za.ac.cput.kristen.timetable.domain.Student;
import za.ac.cput.kristen.timetable.repository.StudentRepository;

/**
 * Created by kris on 5/17/15.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class StudentServiceTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private StudentService service;

    private Long studNo;

    @Autowired
    private StudentRepository repository;

    @Test
    public void create() throws Exception
    {
        Student stud = StudentFactory.createStudent("Sam", "Wyes", null, 20, 2);

        repository.save(stud);
        studNo = stud.getStudNo();

        Assert.assertNotNull(stud.getStudNo());
    }


    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
