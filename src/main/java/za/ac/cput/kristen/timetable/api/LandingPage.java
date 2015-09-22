package timetable.api;

import timetable.domain.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hashcode on 2015/09/17.
 */
@RestController
@RequestMapping("/")
public class LandingPage {
-    @RequestMapping(method = RequestMethod.GET)		
-    public Student getStudent(){		
-        Student stud = new Student.Builder("Kristen", "Hide")		
-                .creditsEarned(40)		
-                .build();		
-        return stud;		
-    }
}
