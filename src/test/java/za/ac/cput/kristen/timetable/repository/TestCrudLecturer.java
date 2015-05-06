package za.ac.cput.kristen.timetable.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.domain.Lecturer;

/**
 * Created by kris on 5/3/15.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudLecturer extends AbstractTestNGSpringContextTests
{
    private Long empNo;

    @Autowired
    private LecturerRepository repository;


    @Test
    public void create() throws Exception
    {
        Lecturer lecturer = new Lecturer.Builder("Jacqui", "Jacobs")
                .qualifications("National Diploma: Information Technology")
                .build();
        repository.save(lecturer);
        empNo = lecturer.getEmpNo();

        Assert.assertNotNull(lecturer.getEmpNo());
    }


    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Lecturer lecturer = repository.findOne(empNo);

        Assert.assertEquals("Jacqui", lecturer.getName());
    }


    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Lecturer newLecturer = new Lecturer.Builder("Sam", "Sue")
                .build();
        repository.save(newLecturer);
        empNo = newLecturer.getEmpNo();
        Lecturer updatedLecturer = repository.findOne(empNo);

        Assert.assertEquals("Sam", updatedLecturer.getName());
    }


    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Lecturer lecturer = repository.findOne(empNo);
        repository.delete(lecturer);
        Lecturer newLecturer = repository.findOne(empNo);

        Assert.assertNull(newLecturer);
    }
}
