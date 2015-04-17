package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kris on 4/15/15.
 */
public class CourseTest
{
    private Subject sub;
    private Course course;

    @Before
    public void setUp() throws Exception
    {
        sub = new Subject.Builder("TP200S").credits(40).name("Technical Programming").build();
        course = new Course.Builder("ND:IT").addSubject(sub).credits(400).qualification("National Diploma").build();
    }

    @Test
    public void testCourse() throws Exception
    {
        Assert.assertEquals(40, course.getSubject(0).getCredits());
    }
}
