package za.ac.cput.kristen.timetable.repository;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.domain.Class;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by kris on 5/2/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudClass
{
    private String code;

    @Autowired
    private ClassRepository repository;



    @Test
    public void create() throws Exception
    {
        Class clss = new Class.Builder("3A", "ND:IT")
            .build();
        repository.save(clss);
        code = clss.getClassCode();

        Assert.assertNotNull(clss.getClassCode());
    }


    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Class clss = repository.findOne(code);

        Assert.assertEquals("3A", clss.getCourseCode());
    }


    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Class clss = repository.findOne(code);
        Class newClass = new Class.Builder("3B", "ND:IT")
                    .build();
        repository.save(newClass);

        Assert.assertEquals("3B", clss.getCourseCode());
    }


    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Class clss = repository.findOne(code);
        repository.delete(clss);
        Class newClass = repository.findOne(code);

        Assert.assertNull(newClass);
    }
}
