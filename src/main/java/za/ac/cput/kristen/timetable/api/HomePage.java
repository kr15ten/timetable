package za.ac.cput.kristen.timetable.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.kristen.timetable.domain.Student;
import za.ac.cput.kristen.timetable.domain.Subject;
import za.ac.cput.kristen.timetable.service.StudentService;

import java.util.List;

/**
 * Created by kris on 5/17/15.
 */

@RestController
@RequestMapping("/api/**")
public class HomePage
{
    @Autowired
    private StudentService service;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String Index()
    {
        return "Home Page of Website";
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public Student getStudent()
    {
        Student student = new Student.Builder("William", "Paine")
                .courseYear(2)
                .build();

        return student;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getStudents()
    {
        return service.getStudents();
    }
}
