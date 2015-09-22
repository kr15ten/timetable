package za.ac.cput.kristen.timetable.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Student;
import za.ac.cput.kristen.timetable.model.LessonResource;
import za.ac.cput.kristen.timetable.service.ClassService;
import za.ac.cput.kristen.timetable.service.LecturerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/17/15.
 */

@RestController
@RequestMapping("/api/**")
public class HomePage
{
    @Autowired
    private ClassService classService;
    @Autowired
    private LecturerService lecturerService;
    

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String Index()
    {
        return "Home Page of Timetable Website";
    }

    @RequestMapping(value = "/lessons", method = RequestMethod.GET)
    public String LessonIndex()
    {
        return "View lessons";
    }

    @RequestMapping(value = "/lessons/lecturer/{id}", method = RequestMethod.GET)
    public List<LessonResource> getLecturerLessons(@PathVariable Long id)
    {
        List<LessonResource> hateoas = new ArrayList<>();
        List<Lesson> lessons = lecturerService.getLessons(id);

        for(Lesson lesson: lessons)
        {
            LessonResource res = new LessonResource
                    .Builder()
                    .topic(lesson.getTopic())
                    .practical(lesson.getPrac())
                    .build();

            Link lecturerLessons = new
                    Link("http://localhost:8080/api/lessons/lecturer/" + id.toString())
                    .withRel("lessons");

            res.add(lecturerLessons);
            hateoas.add(res);
        }
        //return lecturerService.getLessons(id);

        return hateoas;
    }

    @RequestMapping(value = "/lessons/student/{id}", method = RequestMethod.GET)
    public List<LessonResource> getStudentLessons(@PathVariable Long id)
    {
        List<LessonResource> hateoas = new ArrayList<>();
        List<Lesson> lessons = classService.getLessons(classService.getClassCode(id));

        for(Lesson lesson: lessons)
        {
            LessonResource res = new LessonResource
                    .Builder()
                    .topic(lesson.getTopic())
                    .practical(lesson.getPrac())
                    .build();

            Link lecturerLessons = new
                    Link("http://localhost:8080/api/lessons/student/" + id.toString())
                    .withRel("lessons");

            res.add(lecturerLessons);
            hateoas.add(res);
        }
        //return classService.getLessons(classService.getClassCode(id));

        return hateoas;
    }
}
