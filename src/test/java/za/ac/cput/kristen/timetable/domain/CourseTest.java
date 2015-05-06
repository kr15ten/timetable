package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.kristen.timetable.conf.factory.CourseFactory;
import za.ac.cput.kristen.timetable.conf.factory.SubjectFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 4/15/15.
 */
public class CourseTest
{
    private List subjects;
    private Subject sub1;
    private Course course;

    @Before
    public void setUp() throws Exception
    {
        sub1 = SubjectFactory.createSubject("TP200S", "Technical Programming", 40);
        subjects = new ArrayList<Subject>();
        subjects.add(sub1);
        course = CourseFactory.createCourse("ND:IT", "ND: Information Technology", "National Diploma", 3, 400, subjects);
    }

    @Test
    public void testCreateCourse() throws Exception
    {
        Assert.assertEquals(400, course.getCredits());
    }

    @Test
    public void testUpdateCourse() throws Exception
    {
        Course newCourse = new Course
                .Builder(course.getCourseCode())
                .copy(course)
                .credits(360)
                .build();
        Assert.assertEquals(360, newCourse.getCredits());
    }
}
