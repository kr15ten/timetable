package za.ac.cput.kristen.timetable.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/23/15.
 */
public class ClassResource extends ResourceSupport
{
    private String classCode;
    private String courseCode;

    private List<Student> students;

    private List<Lesson> lessons;


    private ClassResource() {
    }

    public ClassResource(Builder builder) {
        classCode = builder.classCode;
        courseCode = builder.courseCode;
        students = builder.students;
        lessons = builder.lessons;
    }

    public String getClassCode() {
        return classCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public Student getStudent(int i) {
        return students.get(i);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Lesson getLesson(int i)
    {
        return lessons.get(i);
    }

    public List<Lesson> getLessons()
    {
        return lessons;
    }

    public static class Builder {
        private String classCode, courseCode;
        private List<Student> students;
        private List<Lesson> lessons;

        public Builder(String classCode, String courseCode) {
            this.classCode = classCode;
            this.courseCode = courseCode;
        }

        public Builder addStudent(Student stud) {
            if (students.isEmpty())
                students = new ArrayList<Student>();

            students.add(stud);
            return this;
        }

        public Builder students(List<Student> students) {
            this.students = students;
            return this;
        }

        public Builder addLesson(Lesson lesson)
        {
            if (lessons.isEmpty())
                lessons = new ArrayList<Lesson>();

            lessons.add(lesson);
            return this;
        }

        public Builder lessons(List<Lesson> lessons)
        {
            this.lessons = lessons;
            return this;
        }

        public Builder copy(ClassResource clss) {
            this.classCode = clss.classCode;
            this.courseCode = clss.courseCode;
            this.students = clss.students;
            this.lessons = clss.lessons;
            return this;
        }


        public ClassResource build() {
            return new ClassResource(this);
        }
    }
}
