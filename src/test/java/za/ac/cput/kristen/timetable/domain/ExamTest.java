package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kris on 4/15/15.
 */
public class ExamTest
{
    private Exam exam;
    private Subject sub;

    @Before
    public void setUp() throws Exception
    {
        sub = new Subject.Builder("DOS300S").name("PL/SQL").credits(30).build();
        exam = new Exam.Builder(0.20, "functions", sub).hours(2.5).practical(true).build();
    }


    @Test
    public void testExam() throws Exception
    {
        Assert.assertEquals("functions", exam.getTopic());
    }
}
