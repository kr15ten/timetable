package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.kristen.timetable.conf.factory.LecturerFactory;
import za.ac.cput.kristen.timetable.conf.factory.SubjectFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 4/15/15.
 */
public class LecturerTest
{
    private Lecturer lecturer;
    private Subject sub1;
    private List<Subject> subjects;

    @Before
    public void setUp() throws Exception
    {
        sub1 = SubjectFactory.createSubject("TP200S", "Technical Programming", 40);
        subjects = new ArrayList<Subject>();
        subjects.add(sub1);
        lecturer = LecturerFactory.createLecturer("William", "Hide", "none", subjects);
    }


    @Test
    public void testCreateLecturer() throws Exception
    {
        Assert.assertEquals("none", lecturer.getQualification());
    }

    @Test
    public void testUpdateLecturer() throws Exception
    {
        Lecturer newLecturer = new Lecturer
                .Builder(lecturer.getName(),
                lecturer.getSurname())
                .copy(lecturer)
                .qualifications("National Diploma")
                .build();
        Assert.assertEquals("National Diploma", newLecturer.getQualification());
    }
}
