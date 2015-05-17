package za.ac.cput.kristen.timetable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.kristen.timetable.App;
import za.ac.cput.kristen.timetable.conf.factory.LecturerFactory;
import za.ac.cput.kristen.timetable.conf.factory.LessonFactory;
import za.ac.cput.kristen.timetable.conf.factory.SubjectFactory;
import za.ac.cput.kristen.timetable.domain.Lecturer;
import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Subject;
import za.ac.cput.kristen.timetable.repository.LecturerRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/17/15.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class LecturerServiceTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private LecturerService service;

    private Long empNo;

    @Autowired
    private LecturerRepository repository;
    private List<Subject> subjects;
    private List<Lesson> lessons;

    @BeforeMethod
    public void setUp() throws Exception
    {
        subjects = new ArrayList<Subject>();
        lessons = new ArrayList<Lesson>();
    }


    @Test
    public void create() throws Exception
    {
        Subject sub1 = SubjectFactory.createSubject("TP1", null, 60, null);
        subjects.add(sub1);

        Lesson less1 = LessonFactory.createLesson("Topic", false);
        Lesson less2 = LessonFactory.createLesson("OtherTopic", true);
        lessons.add(less1);
        lessons.add(less2);

        Lecturer lect = LecturerFactory.createLecturer("Sam", "Muller", null, subjects, lessons);

        repository.save(lect);
        empNo = lect.getEmpNo();

        Assert.assertNotNull(lect.getEmpNo());
    }


    @Test
    public void testGetLecturerSubjects() throws Exception
    {
        subjects = service.getSubjects(empNo);
        Assert.assertEquals(2, subjects.size());
    }

    @Test
    public void testGetLecturerLessons() throws Exception
    {
        lessons = service.getLessons(empNo);
        Assert.assertEquals(2, lessons.size());
    }


    @AfterClass
    public void cleanUp() throws Exception
    {
       repository.deleteAll();
    }
}
