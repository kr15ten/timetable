package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.kristen.timetable.conf.factory.ExamFactory;
import za.ac.cput.kristen.timetable.conf.factory.SubjectFactory;

import java.util.Date;

/**
 * Created by kris on 4/15/15.
 */
public class ExamTest
{
    private Exam exam;
    private Subject sub1;
    private Date date;

    @Before
    public void setUp() throws Exception
    {
        date = new Date(2015, 05, 04);
        sub1 = SubjectFactory.createSubject("TP200S", "Technical Programming", 40, null);
        exam = ExamFactory.createExam(date, 2.5, 0.20, "functions", sub1, true);
    }


    @Test
    public void testCreateExam() throws Exception
    {
        Assert.assertEquals(2.5, exam.getHours(), 2);
    }

    @Test
    public void testUpdateExam() throws Exception
    {
        Exam newExam = new Exam
                .Builder(exam.getSubjectContribution(), exam.getTopic(),
                exam.getSubject())
                .copy(exam)
                .hours(2.0)
                .build();
        Assert.assertEquals(2.0, newExam.getHours(), 2);
    }
}
