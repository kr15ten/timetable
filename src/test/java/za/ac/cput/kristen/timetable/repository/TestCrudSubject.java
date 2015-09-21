package za.ac.cput.kristen.timetable.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.domain.Subject;

/**
 * Created by kris on 5/3/15.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudSubject extends AbstractTestNGSpringContextTests
{
    private String code;

    @Autowired
    private SubjectRepository repository;


    @Test
    public void create() throws Exception
    {
        Subject subject = new Subject.Builder("TPG300S", "Technical Programming 3")
                .credits(800)
                .build();
        repository.save(subject);
        code = subject.getCode();

        Assert.assertNotNull(subject.getCode());
    }


    /*@Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Subject subject = repository.findOne(code);

        Assert.assertEquals("TPG300S", subject.getCode());
    }


    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Subject newSubject = new Subject.Builder("OLE200S", "Oley")
                .build();
        repository.save(newSubject);

        code = newSubject.getCode();
        Subject updatedSubject = repository.findOne(code);

        Assert.assertEquals("OLE200S", updatedSubject.getCode());
    }


    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Subject subject = repository.findOne(code);
        repository.delete(subject);
        Subject newSubject = repository.findOne(code);

        Assert.assertNull(newSubject);
    }*/


    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
