package za.ac.cput.kristen.timetable.service;

import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Subject;

import java.util.List;

/**
 * Created by kris on 4/16/15.
 */
public interface SubjectService
{
    List<Subject> getSubjects();

    List<Lesson> getLessons(String code);
}
