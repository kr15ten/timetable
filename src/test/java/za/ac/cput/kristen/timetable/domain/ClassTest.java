package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 2015/04/15.
 */
public class ClassTest
{
    private Student stud1, stud2;
    private Class clss;

    @Before
    public void setUp() throws Exception
    {
        stud1 = new Student.Builder(1234, "Tristan", "Bro").creditsEarned(70).build();
        stud2 = new Student.Builder(5678, "Mandy", "Mo").courseYear(2).creditsEarned(20).build();
        clss = new Class.Builder("A3", "ND: Information Technology").addStudent(stud1).addStudent(stud2).build();
    }

    @Test
    public void testClass() throws Exception
    {
        Assert.assertEquals("Mo", clss.getStudent(1).getSurname());
    }
}
