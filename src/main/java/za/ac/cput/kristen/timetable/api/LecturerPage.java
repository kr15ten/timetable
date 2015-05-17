package za.ac.cput.kristen.timetable.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.kristen.timetable.domain.Subject;
import za.ac.cput.kristen.timetable.service.LecturerService;

import java.util.List;

/**
 * Created by kris on 5/17/15.
 */

@RestController
@RequestMapping("/lecturer/**")
public class LecturerPage
{
    @Autowired
    private LecturerService service;

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.GET)
    public List<Subject> getSubjects(@PathVariable Long id)
    {
        return service.getSubjects(id);
    }
}
