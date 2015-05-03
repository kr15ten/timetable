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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_code")
    private List<Student> students;

    private Class() {
    }

    public Class(Builder builder) {
        classCode = builder.classCode;
        courseCode = builder.courseCode;
        students = builder.students;
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


    public static class Builder {
        private String classCode, courseCode;
        private List<Student> students;

        public Builder(String classCode, String courseCode) {
            this.classCode = classCode;
            this.courseCode = courseCode;
        }

        public Builder addStudent(Student stud) {
            if (students == null) {
                students = new ArrayList<Student>();
            }

            students.add(stud);
            return this;
        }

        public Builder students(List<Student> students) {
            this.students = students;
            return this;
        }

        public Builder copy(Class clss) {
            this.classCode = clss.classCode;
            this.courseCode = clss.courseCode;
            this.students = clss.students;
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
