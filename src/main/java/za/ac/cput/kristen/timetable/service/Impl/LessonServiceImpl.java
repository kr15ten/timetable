package za.ac.cput.kristen.timetable.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.repository.LessonRepository;
import za.ac.cput.kristen.timetable.service.LessonService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/12/15.
 */
@Service
public class LessonServiceImpl implements LessonService
{
    @Autowired
    private LessonRepository repository;

    public List<Lesson> getLessons()
    {
        List<Lesson> allLessons = new ArrayList<Lesson>();

        Iterable<Lesson> lessons = repository.findAll();
        for(Lesson lesson: lessons)
        {
            allLessons.add(lesson);
        }

        return allLessons;
    }
}
