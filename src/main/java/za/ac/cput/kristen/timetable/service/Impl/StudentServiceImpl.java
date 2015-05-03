package za.ac.cput.kristen.timetable.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.kristen.timetable.domain.Student;
import za.ac.cput.kristen.timetable.repository.StudentRepository;
import za.ac.cput.kristen.timetable.service.StudentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/3/15.
 */
@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    StudentRepository repository;

    public List<Student> getStudents()
    {
        List<Student> allStudents = new ArrayList<Student>();

        Iterable<Student> students = repository.findAll();
        for(Student student: students)
        {
            allStudents.add(student);
        }

        return allStudents;
    }
}
