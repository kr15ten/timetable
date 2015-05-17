package za.ac.cput.kristen.timetable.repository;


/**
 * Lost on 5/9/15
 *
 * Recreated by kris on 5/9/15
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.domain.Class;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudClass extends AbstractTestNGSpringContextTests
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

        Assert.assertEquals("3A", clss.getClassCode());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Class newClass = new Class.Builder("3B", "ND: IT")
                .build();

        repository.save(newClass);
        code = newClass.getClassCode();
        Class updatedClass = repository.findOne(code);

        Assert.assertEquals("3B", updatedClass.getClassCode());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Class clss = repository.findOne(code);
        repository.delete(clss);
        Class newClass = repository.findOne(code);
        Assert.assertNull(newClass);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
