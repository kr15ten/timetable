package za.ac.cput.kristen.timetable.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/13.
 */
@Entity
public class Class implements Serializable {
    @Id
    private String classCode;
    private String courseCode;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "class_code")
    private List<Student> students;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "class")
    private List<Lesson> lessons;


    private Class() {
    }

    public Class(Builder builder) {
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

        public Builder copy(Class clss) {
            this.classCode = clss.classCode;
            this.courseCode = clss.courseCode;
            this.students = clss.students;
            this.lessons = clss.lessons;
            return this;
        }


        public Class build() {
            return new Class(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Class)) return false;

        Class aClass = (Class) o;

        if (classCode != null ? !classCode.equals(aClass.classCode) : aClass.classCode != null) return false;
        if (courseCode != null ? !courseCode.equals(aClass.courseCode) : aClass.courseCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classCode != null ? classCode.hashCode() : 0;
        result = 31 * result + (courseCode != null ? courseCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classCode='" + classCode + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", students=" + students +
                '}';
    }
}
