package za.ac.cput.kristen.timetable.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Subject;
import za.ac.cput.kristen.timetable.repository.SubjectRepository;
import za.ac.cput.kristen.timetable.service.SubjectService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/3/15.
 */
@Service
public class SubjectServiceImpl implements SubjectService
{
    @Autowired
    SubjectRepository repository;

    public List<Subject> getSubjects()
    {
        List<Subject> allSubjects = new ArrayList<Subject>();

        Iterable<Subject> subjects = repository.findAll();
        for(Subject subject: subjects)
        {
            allSubjects.add(subject);
        }

        return allSubjects;
    }

    @Override
    public List<Lesson> getLessons(String code) {
        return repository.findOne(code).getLessons();
    }
}
