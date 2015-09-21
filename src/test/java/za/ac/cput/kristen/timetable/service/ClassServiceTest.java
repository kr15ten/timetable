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
import za.ac.cput.kristen.timetable.conf.factory.ClassFactory;
import za.ac.cput.kristen.timetable.conf.factory.LessonFactory;
import za.ac.cput.kristen.timetable.conf.factory.StudentFactory;
import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Student;
import za.ac.cput.kristen.timetable.domain.Class;
import za.ac.cput.kristen.timetable.repository.ClassRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/17/15.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ClassServiceTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private ClassService service;

    private String classCode;

    @Autowired
    private ClassRepository repository;
    private List<Student> students;
    private List<Lesson> lessons;

    @BeforeMethod
    public void setUp() throws Exception
    {
        students = new ArrayList<Student>();
        lessons = new ArrayList<Lesson>();
    }


    @Test
    public void create() throws Exception
    {
        Student stud1 = StudentFactory.createStudent("Paul", "Rudd", null, 0, 0);
        students.add(stud1);

        Lesson less1 = LessonFactory.createLesson("Topic", false);
        lessons.add(less1);

        Class clss = ClassFactory.createClass("A3", null, students, lessons);

        repository.save(clss);
        classCode = clss.getClassCode();

        Assert.assertNotNull(clss.getClassCode());
    }


    @Test(dependsOnMethods = "create")
    public void testGetClassStudents() throws Exception
    {
        students = service.getStudents(classCode);
        Assert.assertEquals(1, students.size());
    }

    @Test
    public void testGetClassLessons() throws Exception
    {
        lessons = service.getLessons(classCode);
        Assert.assertEquals(1, lessons.size());
    }

    @AfterClass
    public void cleanUp() throws Exception
    {
        repository.deleteAll();
    }
}
