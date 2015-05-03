package za.ac.cput.kristen.timetable.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.domain.Lecturer;

/**
 * Created by kris on 5/3/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudLecturer
{
    private Long empNo;

    @Autowired
    private LecturerRepository repository;


    @Test
    public void create() throws Exception
    {
        Lecturer lecturer = new Lecturer.Builder(Long.valueOf(12345), "Jacqui", "Jacobs")
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

        Assert.assertEquals(Long.valueOf(12345), lecturer.getEmpNo());
    }


    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Lecturer lecturer = repository.findOne(empNo);
        Lecturer newLecturer = new Lecturer.Builder(Long.valueOf(2345), "Sam", "Sue")
                .build();
        repository.save(newLecturer);

        Assert.assertEquals(Long.valueOf(2345), lecturer.getEmpNo());
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
