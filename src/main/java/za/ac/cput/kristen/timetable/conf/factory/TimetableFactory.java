package za.ac.cput.kristen.timetable.conf.factory;

import za.ac.cput.kristen.timetable.domain.*;
import za.ac.cput.kristen.timetable.domain.Class;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * Created by kris on 4/24/15.
 */
public class TimetableFactory
{
    public static Class createClass(String classCode, String courseCode,
                                    List<Student> students)
    {
        Class clss = new Class
                .Builder(classCode, courseCode)
                .students(students)
                .build();
        return clss;
    }

    public static Course createCourse(String courseCode, String name,
                                      String qualification, int years,
                                      int credits, List<Subject> subjects)
    {
        Course course = new Course
                .Builder(courseCode)
                .name(name)
                .qualification(qualification)
                .years(years)
                .subjects(subjects)
                .credits(credits)
                .build();
        return course;
    }

    public static Exam createExam(Date startTime, double hours,
                                  double subjectContribution,
                                  String topic, Subject subject,
                                  Boolean prac)
    {
        Exam exam = new Exam
                .Builder(subjectContribution, topic, subject)
                .startTime(startTime)
                .hours(hours)
                .practical(prac)
                .build();
        return exam;
    }

    public static Examslot createExamslot(int term, Date startDate,
                                          Date endDate)
    {
        Examslot examslot = new Examslot
                .Builder(startDate, endDate)
                .term(term)
                .build();
        return examslot;
    }

    public static Lecturer createLecturer(Long empNo, String name,
                                          String surname, String qualification,
                                          List<Subject> subjects)
    {
        Lecturer lecturer = new Lecturer
                .Builder(empNo, name, surname)
                .qualifications(qualification)
                .subject(subjects)
                .build();
        return lecturer;
    }

    public static Lesson createLesson(Timeslot slot, Lecturer lecturer,
                                      Room room, Class clss, Subject subject,
                                      String topic, Boolean prac)
    {
        Lesson lesson = new Lesson
                .Builder(slot, lecturer, clss, subject)
                .room(room)
                .topic(topic)
                .practical(prac)
                .build();
        return lesson;
    }

    public static Room createRoom(String roomNumber, int size, Boolean lab)
    {
        Room room = new Room
                .Builder(roomNumber)
                .size(size)
                .lab(lab)
                .build();
        return room;
    }

    public static Student createStudent(Long studNo, String name, String surname,
                                        String courseCode, int creditsEarned,
                                        int courseYear)
    {
        Student stud = new Student
                .Builder(studNo, name, surname)
                .courseCode(courseCode)
                .creditsEarned(creditsEarned)
                .courseYear(courseYear)
                .build();
        return stud;
    }

    public static Subject createSubject(String code, String name, int credits)
    {
        Subject subject = new Subject
                .Builder(code)
                .name(name)
                .credits(credits)
                .build();
        return subject;
    }

    public static Termslot createTermslot(int term, Date startDate, Date endDate)
    {
        Termslot termslot = new Termslot
                .Builder(startDate, endDate)
                .term(term)
                .build();
        return termslot;
    }

    public static Timeslot createTimeslot(String day, Time start, Time end,
                                          int rotationalWeek)
    {
        Timeslot timeslot = new Timeslot
                .Builder(day, start, end)
                .rotationalWeek(rotationalWeek)
                .build();
        return timeslot;
    }
}
