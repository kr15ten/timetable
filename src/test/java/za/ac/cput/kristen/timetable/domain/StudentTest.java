package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kris on 4/15/15.
 */
public class StudentTest
{
    private Student stud;

    @Before
    public void setUp() throws Exception
    {
        stud = new Student.Builder(Long.valueOf(123), "Richard", "Worster").build();
    }


    @Test
    public void test() throws Exception
    {
        Assert.assertEquals("Richard", stud.getName());
    }
}
