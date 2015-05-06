package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.kristen.timetable.conf.factory.StudentFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 4/15/15.
 */
public class StudentTest
{
    private Student stud1, stud2, stud3;
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
    }


    @Test
    public void testCreateStudent() throws Exception
    {
        Assert.assertEquals(2, stud2.getCourseYear());
    }

    @Test
    public void testUpdateStudent() throws Exception
    {
        Student newStudent = new Student
                .Builder(stud2.getName(), stud2.getSurname())
                .copy(stud2)
                .courseYear(3)
                .build();
        Assert.assertEquals(3, newStudent.getCourseYear());
    }
}
