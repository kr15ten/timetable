package za.ac.cput.kristen.timetable.conf.factory;

import za.ac.cput.kristen.timetable.domain.*;
import za.ac.cput.kristen.timetable.domain.Class;

import java.util.List;

/**
 * Created by kris on 5/4/15.
 */
public class ClassFactory
{
    public static za.ac.cput.kristen.timetable.domain.Class createClass(String classCode, String courseCode,
                                                                        List<Student> students)
    {
        Class clss = new Class
                .Builder(classCode, courseCode)
                .students(students)
                .build();
        return clss;
    }
}
