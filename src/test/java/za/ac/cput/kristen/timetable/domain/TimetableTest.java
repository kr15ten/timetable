package za.ac.cput.kristen.timetable.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.kristen.timetable.conf.factory.TimetableFactory;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kris on 4/24/15.
 */
public class TimetableTest
{
    private Date date;
    private Date start, end;
    private Time tStart, tEnd;

    private Student stud1, stud2, stud3;
    private Class clss;
    private Subject sub1;
    private Course course;
    private Exam exam;
    private Examslot examslot;
    private Lecturer lecturer;
    private Lesson lesson;
    private Timeslot timeslot;
    private Room room;
    private Termslot termslot;

    private List<Student> students;
    private List<Subject> subjects;


    @Before
    public void setUp() throws Exception
    {
        date = new Date(2015, 05, 04);
        start = new Date(2015, 05, 25);
        end = new Date(2015, 06, 12);
        tStart = new Time(8, 30, 00);
        tEnd = new Time(9, 55, 00);

        //Student setUp
        stud1 = TimetableFactory.createStudent(Long.valueOf(1234), "Tristan", "Bro", "N2350", 40, 2);
        stud2 = TimetableFactory.createStudent(Long.valueOf(5678), "Mandy", "Mo", "N2350", 20, 2);
        stud3 = TimetableFactory.createStudent(Long.valueOf(1123), "Mark", "NewKid", "N2350", 45, 3);
        students = new ArrayList<Student>();
        students.add(stud1);
        students.add(stud2);


        //Class setUp
        clss = TimetableFactory.createClass("A3", "ND: Information Technology", students);


        //Subject setUp
        sub1 = TimetableFactory.createSubject("TP200S", "Technical Programming", 40);
        subjects = new ArrayList<Subject>();
        subjects.add(sub1);


        //Course setUp
        course = TimetableFactory.createCourse("ND:IT", "ND: Information Technology", "National Diploma", 3, 400, subjects);


        //Exam setUp
        exam = TimetableFactory.createExam(date, 2.5, 0.20, "functions", sub1, true);


        //Examslot setUp
        examslot = TimetableFactory.createExamslot(2, start, end);


        //Lecturer setUp
        lecturer = TimetableFactory.createLecturer(Long.valueOf(123), "William", "Hide", "none", subjects);


        //Room setUp
        room = TimetableFactory.createRoom("1.12", 38, true);


        //Timeslot setUp
        timeslot = TimetableFactory.createTimeslot("Wednesday", tStart, tEnd, 0);


        //Lesson setUp
        lesson = TimetableFactory.createLesson(timeslot, lecturer, room, clss, sub1, "functions", true);


        //Termslot setUp
        termslot = TimetableFactory.createTermslot(2, start, end);
    }


    //testClass
    @Test
    public void testCreateClass() throws Exception
    {
        Assert.assertEquals("Mandy", clss.getStudent(1).getName());
    }

    @Test
    public void testUpdateClass() throws Exception
    {
        Class newClass = new Class
                .Builder(clss.getClassCode(), clss.getCourseCode())
                .copy(clss)
                .addStudent(stud3)
                .build();
        Assert.assertEquals("Mark", clss.getStudent(2).getName());
    }


    //testCourse
    @Test
    public void testCreateCourse() throws Exception
    {
        Assert.assertEquals(400, course.getCredits());
    }

    @Test
    public void testUpdateCourse() throws Exception
    {
        Course newCourse = new Course
                .Builder(course.getCourseCode())
                .copy(course)
                .credits(360)
                .build();
        Assert.assertEquals(360, newCourse.getCredits());
    }


    //testExam
    @Test
    public void testCreateExam() throws Exception
    {
        Assert.assertEquals(2.5, exam.getHours(), 2);
    }

    @Test
    public void testUpdateExam() throws Exception
    {
        Exam newExam = new Exam
                .Builder(exam.getSubjectContribution(), exam.getTopic(),
                        exam.getSubject())
                .copy(exam)
                .hours(2.0)
                .build();
        Assert.assertEquals(2.0, newExam.getHours(), 2);
    }


    //testExamslot
    @Test
    public void testCreateExamslot() throws Exception
    {
        Assert.assertEquals(2, examslot.getTerm());
    }

    @Test
    public void testUpdateExamslot() throws Exception
    {
        Examslot newExamslot = new Examslot
                .Builder(examslot.getStartDate(), examslot.getEndDate())
                .copy(examslot)
                .term(3)
                .build();

        Assert.assertEquals(3, newExamslot.getTerm());
    }


    //testLecturer
    @Test
    public void testCreateLecturer() throws Exception
    {
        Assert.assertEquals("none", lecturer.getQualification());
    }

    @Test
    public void testUpdateLecturer() throws Exception
    {
        Lecturer newLecturer = new Lecturer
                .Builder(lecturer.getEmpNo(), lecturer.getName(),
                    lecturer.getSurname())
                .copy(lecturer)
                .qualifications("National Diploma")
                .build();
        Assert.assertEquals("National Diploma", newLecturer.getQualification());
    }


    //testLesson
    @Test
    public void testCreateLesson() throws Exception
    {
        Assert.assertEquals("functions", lesson.getTopic());
    }

    @Test
    public void testUpdateLesson() throws Exception
    {
        Lesson newLesson = new Lesson
                .Builder(lesson.getSlot(), lesson.getLecturer(),
                        lesson.getClss(), lesson.getSubject())
                .copy(lesson)
                .topic("functions and arrays")
                .build();
        Assert.assertEquals("functions and arrays", newLesson.getTopic());
    }


    //testRoom
    @Test
    public void testCreateRoom() throws Exception
    {
        Assert.assertEquals(true, room.getLab());
    }

    @Test
    public void testUpdateRoom() throws Exception
    {
        Room newRoom = new Room
                .Builder(room.getRoomNumber())
                .copy(room)
                .lab(false)
                .build();
        Assert.assertEquals(false, newRoom.getLab());
    }


    //testStudent
    @Test
    public void testCreateStudent() throws Exception
    {
        Assert.assertEquals(2, stud2.getCourseYear());
    }

    @Test
    public void testUpdateStudent() throws Exception
    {
        Student newStudent = new Student
                .Builder(stud2.getStudNo(), stud2.getName(), stud2.getSurname())
                .copy(stud2)
                .courseYear(3)
                .build();
        Assert.assertEquals(3, newStudent.getCourseYear());
    }


    //testSubject
    @Test
    public void testCreateSubject() throws Exception
    {
        Assert.assertEquals(40, sub1.getCredits());
    }

    @Test
    public void testUpdateSubject() throws Exception
    {
        Subject newSub = new Subject
                .Builder(sub1.getCode())
                .copy(sub1)
                .credits(20)
                .build();
        Assert.assertEquals(20, newSub.getCredits());
    }


    //testTermslot
    @Test
    public void testCreateTermslot() throws Exception
    {
        Assert.assertEquals(2, termslot.getTerm());
    }

    @Test
    public void testUpdateTermslot() throws Exception
    {
        Termslot newTermslot = new Termslot
                .Builder(termslot.getStartDate(), termslot.getEndDate())
                .term(4)
                .build();
        Assert.assertEquals(4, newTermslot.getTerm());
    }


    //testTimeslot
    @Test
    public void testCreateTimeslot() throws Exception
    {
        Assert.assertEquals(0 , timeslot.getRotationalWeek());
    }

    @Test
    public void testUpdateTimeslot() throws Exception
    {
        Timeslot newTimeslot = new Timeslot
                .Builder("Thursday", timeslot.getStart(), timeslot.getEnd())
                .copy(timeslot)
                .rotationalWeek(2)
                .build();
        Assert.assertEquals(2, newTimeslot.getRotationalWeek());
    }
}
