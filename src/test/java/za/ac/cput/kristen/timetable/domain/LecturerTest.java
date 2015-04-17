package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kris on 4/15/15.
 */
public class LecturerTest
{
    private Lecturer lecturer;

    @Before
    public void setUp() throws Exception
    {
        lecturer = new Lecturer.Builder("E123", "William", "Hide").qualifications("none").build();
    }


    @Test
    public void testLecturer() throws Exception
    {
        Assert.assertEquals("William", lecturer.getName());
    }
}
