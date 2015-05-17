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

    @Before
    public void setUp() throws Exception
    {
        lesson = LessonFactory.createLesson("functions", true);
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
                .Builder()
                .copy(lesson)
                .topic("functions and arrays")
                .build();
        Assert.assertEquals("functions and arrays", newLesson.getTopic());
    }
}
