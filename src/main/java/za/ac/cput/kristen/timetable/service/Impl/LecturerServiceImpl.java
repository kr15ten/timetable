package za.ac.cput.kristen.timetable.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.kristen.timetable.domain.Lecturer;
import za.ac.cput.kristen.timetable.repository.LecturerRepository;
import za.ac.cput.kristen.timetable.service.LecturerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/3/15.
 */
@Service
public class LecturerServiceImpl implements LecturerService
{
    @Autowired
    LecturerRepository repository;

    public List<Lecturer> getLecturers()
    {
        List<Lecturer> allLecturers = new ArrayList<Lecturer>();

        Iterable<Lecturer> lecturers = repository.findAll();
        for(Lecturer lecturer: lecturers)
        {
            allLecturers.add(lecturer);
        }

        return allLecturers;
    }
}
