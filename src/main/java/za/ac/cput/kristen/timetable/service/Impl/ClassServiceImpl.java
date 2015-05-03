package za.ac.cput.kristen.timetable.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import za.ac.cput.kristen.timetable.domain.Class;
import za.ac.cput.kristen.timetable.repository.ClassRepository;
import za.ac.cput.kristen.timetable.service.ClassService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/2/15.
 */
@Service
public class ClassServiceImpl implements ClassService
{
    @Autowired
    private ClassRepository repository;

    public List<Class> getClasses()
    {
        List<Class> allClasses = new ArrayList<Class>();

        Iterable<Class> classes = repository.findAll();
        for(Class clss: classes)
        {
            allClasses.add(clss);
        }

        return allClasses;
    }
}
