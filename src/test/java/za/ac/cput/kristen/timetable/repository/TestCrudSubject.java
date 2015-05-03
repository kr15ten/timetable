package za.ac.cput.kristen.timetable.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.domain.Subject;

/**
 * Created by kris on 5/3/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudSubject
{
    private String code;

    @Autowired
    private SubjectRepository repository;


    @Test
    public void create() throws Exception
    {
        Subject subject = new Subject.Builder("TPG300S")
                .credits(800)
                .build();
        repository.save(subject);
        code = subject.getCode();

        Assert.assertNotNull(subject.getCode());
    }


    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Subject subject = repository.findOne(code);

        Assert.assertEquals("TPG300S", subject.getCode());
    }


    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Subject subject = repository.findOne(code);
        Subject newSubject = new Subject.Builder("OLE200S")
                .build();
        repository.save(newSubject);

        Assert.assertEquals("OLE200S", subject.getCode());
    }


    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Subject subject = repository.findOne(code);
        repository.delete(subject);
        Subject newSubject = repository.findOne(code);

        Assert.assertNull(newSubject);
    }

}
