package za.ac.cput.kristen.timetable.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.domain.Timeslot;

/**
 * Created by kris on 5/12/15.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudTimeslot extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private TimeslotRepository repository;


    @Test
    public void create() throws Exception
    {
        Timeslot timeslot = new Timeslot.Builder("Wednesday", null, null)
                .build();
        repository.save(timeslot);
        id = timeslot.getId();

        Assert.assertNotNull(timeslot.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Timeslot timeslot = repository.findOne(id);

        Assert.assertEquals("Wednesday", timeslot.getDay());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Timeslot newTimeslot = new Timeslot.Builder("Thursday", null, null)
                .build();

        repository.save(newTimeslot);
        id = newTimeslot.getId();
        Timeslot updatedTimeslot = repository.findOne(id);

        Assert.assertEquals("Thursday", updatedTimeslot.getDay());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Timeslot timeslot = repository.findOne(id);
        repository.delete(timeslot);
        Timeslot newTimeslot = repository.findOne(id);
        Assert.assertNull(newTimeslot);
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
