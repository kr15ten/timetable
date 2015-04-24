package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

/**
 * Created by kris on 4/15/15.
 */
public class LessonTest
{
    private Lesson lesson;
    private Timeslot timeslot;
    private Time start, end;
    private Lecturer lecturer;
    private Class clss;
    private Subject subject;
    private Room room;

    @Before
    public void setUp() throws Exception
    {
        room = new Room.Builder("4.23").lab(true).build();
        subject = new Subject.Builder("TPG300S").credits(40).build();
        clss = new Class.Builder("A3", "ND:IT").build();
        lecturer = new Lecturer.Builder(1234, "Paul", "Runner").build();
        start = new Time(8, 30, 00);
        end = new Time(9, 55, 00);
        timeslot = new Timeslot.Builder("Tuesday", end, start).build();
        lesson = new Lesson.Builder(timeslot, lecturer, clss, subject).room(room).practical(false).build();
    }


    @Test
    public void testLesson() throws Exception
    {
        Assert.assertEquals(timeslot, lesson.getSlot());
    }
}
