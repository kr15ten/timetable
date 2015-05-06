package za.ac.cput.kristen.timetable.domain;

import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.kristen.timetable.AppTest;
import za.ac.cput.kristen.timetable.conf.factory.ClassFactory;
import za.ac.cput.kristen.timetable.conf.factory.StudentFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by student on 2015/04/15.
 */
public class ClassTest
{
    private Student stud1, stud2, stud3;
    private Class clss;
    private List<Student> students;

    @Before
    public void setUp() throws Exception
    {
        stud1 = StudentFactory.createStudent("Tristan", "Bro", "N2350", 40, 2);
        stud2 = StudentFactory.createStudent("Mandy", "Mo", "N2350", 20, 2);
        stud3 = StudentFactory.createStudent("Mark", "NewKid", "N2350", 45, 3);
        students = new ArrayList<Student>();
        students.add(stud1);
        students.add(stud2);
        clss = ClassFactory.createClass("A3", "ND: Information Technology", students);
    }

    public static junit.framework.Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    @Test
    public void testCreateClass() throws Exception
    {
        Assert.assertEquals("Mandy", clss.getStudent(1).getName());
    }

    @Test
    public void testUpdateClass() throws Exception
    {
        Class newClass = new Class
                .Builder(clss.getClassCode(), clss.getCourseCode())
                .copy(clss)
                .addStudent(stud3)
                .build();
        Assert.assertEquals("Mark", clss.getStudent(2).getName());
    }
}
