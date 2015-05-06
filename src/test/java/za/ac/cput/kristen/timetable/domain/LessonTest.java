package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.kristen.timetable.conf.factory.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 4/15/15.
 */
public class LessonTest
{
    private Lesson lesson;
    private Timeslot timeslot;
    private Time tStart, tEnd;
    private Lecturer lecturer;
    private Room room;
    private Class clss;
    private Student stud1;
    private List<Student> students;
    private Subject sub1;
    private List<Subject> subjects;

    @Before
    public void setUp() throws Exception
    {
        tStart = new Time(8, 30, 00);
        tEnd = new Time(9, 55, 00);
        timeslot = TimeslotFactory.createTimeslot("Wednesday", tStart, tEnd, 0);

        stud1 = StudentFactory.createStudent("Tristan", "Bro", "N2350", 40, 2);
        students = new ArrayList<Student>();
        students.add(stud1);

        room = RoomFactory.createRoom("1.12", 38, true);
        clss = ClassFactory.createClass("A3", "ND: Information Technology", students);

        sub1 = SubjectFactory.createSubject("TP200S", "Technical Programming", 40);
        subjects = new ArrayList<Subject>();
        subjects.add(sub1);

        lesson = LessonFactory.createLesson(timeslot, lecturer, room, clss, sub1, "functions", true);
        lecturer = LecturerFactory.createLecturer("William", "Hide", "none", subjects);

    }


    @Test
    public void testCreateLesson() throws Exception
    {
        Assert.assertEquals("functions", lesson.getTopic());
    }

    @Test
    public void testUpdateLesson() throws Exception
    {
        Lesson newLesson = new Lesson
                .Builder(lesson.getSlot(), lesson.getLecturer(),
                lesson.getClss(), lesson.getSubject())
                .copy(lesson)
                .topic("functions and arrays")
                .build();
        Assert.assertEquals("functions and arrays", newLesson.getTopic());
    }
}
