package za.ac.cput.kristen.timetable.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.kristen.timetable.domain.Course;
import za.ac.cput.kristen.timetable.domain.Student;
import za.ac.cput.kristen.timetable.domain.Subject;
import za.ac.cput.kristen.timetable.model.CourseResource;
import za.ac.cput.kristen.timetable.model.StudentResource;
import za.ac.cput.kristen.timetable.model.SubjectResource;
import za.ac.cput.kristen.timetable.service.CourseService;
import za.ac.cput.kristen.timetable.service.StudentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/23/15.
 */

@RestController
@RequestMapping("api/**")
public class StudentPage
{
    @Autowired
    private StudentService service;
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/students/", method = RequestMethod.GET)
    public List<StudentResource> getStudents()
    {
        List<StudentResource> hateoas = new ArrayList<>();
        List<Student> students = service.getStudents();

        for(Student student: students)
        {
            StudentResource res = new StudentResource
                    .Builder(student.getName(), student.getSurname())
                    .courseCode(student.getCourseCode())
                    .courseYear(student.getCourseYear())
                    .build();

            Link studentsLink = new
                    Link("http://localhost:8080/api/students/" + res.getStudNo().toString())
                    .withRel("students");

            res.add(studentsLink);
            hateoas.add(res);
        }
        //return courseService.getSubjects(service.getCoursecode(id));

        return hateoas;
    }
    /*@RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "Visit student details";
    }*/

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public StudentResource getStudent(@PathVariable Long id)
    {
        StudentResource hateoas;
        Student student = service.getStudent(id);

        StudentResource res = new StudentResource
                .Builder(student.getName(), student.getSurname())
                .courseCode(student.getCourseCode())
                .creditsEarned(student.getCreditsEarned())
                .courseYear(student.getCourseYear())
                .build();

        Link studentDetails = new
                Link("http://localhost:8080/api/student/" + res.getStudNo().toString())
                .withRel("students");

        res.add(studentDetails);
        hateoas = res;

        //return service.getStudent(id);
        return hateoas;
    }

    @RequestMapping(value = "/student/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createStudent(@RequestBody Student student, UriComponentsBuilder ucBuilder){
        if (service.isStudentExisting(student))
        {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        service.save(student);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(student.getStudNo()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/student/course/{id}", method = RequestMethod.GET)
    public CourseResource getCourse(@PathVariable Long id)
    {
        CourseResource hateoas;
        Course course = courseService.getCourse(service.getCoursecode(id));

        CourseResource res = new CourseResource
                .Builder(course.getCourseCode())
                .name(course.getName())
                .qualification(course.getQualification())
                .years(course.getYears())
                .subjects(course.getSubjects())
                .credits(course.getCredits())
                .build();

        Link studentsCourse = new
                Link("http://localhost:8080/api/student/course/" + res.getCourseCode().toString())
                .withRel("courses");

        res.add(studentsCourse);
        hateoas = res;

        //return courseService.getCourse(service.getCoursecode(id));
        return hateoas;
    }

    @RequestMapping(value = "/student/subjects/{id}", method = RequestMethod.GET)
    public List<SubjectResource> getSubjects(@PathVariable Long id)
    {
        List<SubjectResource> hateoas = new ArrayList<>();
        List<Subject> subjects = courseService.getSubjects(service.getCoursecode(id));

        for(Subject subject: subjects)
        {
            SubjectResource res = new SubjectResource
                    .Builder(subject.getCode(), subject.getName())
                    .credits(subject.getCredits())
                    .lessons(subject.getLessons())
                    .build();

            Link studentSubjects = new
                    Link("http://localhost:8080/api/student/subjects/" + res.getCode().toString())
                    .withRel("subjects");

            res.add(studentSubjects);
            hateoas.add(res);
        }
        //return courseService.getSubjects(service.getCoursecode(id));

        return hateoas;
    }
}
