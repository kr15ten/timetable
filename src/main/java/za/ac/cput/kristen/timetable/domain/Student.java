package za.ac.cput.kristen.timetable.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/04/13.
 */

@Entity
public class Student implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studNo;
    private String name, surname, courseCode;
    private int creditsEarned, courseYear;

    public int getStudNo() {
        return studNo;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCreditsEarned() {
        return creditsEarned;
    }

    public int getCourseYear() {
        return courseYear;
    }

    private Student()
    {
    }

    public Student(Builder builder)
    {
        this.studNo = builder.studNo;
        this.name = builder.name;
        this.surname = builder.surname;
        this.courseCode = builder.courseCode;
        this.creditsEarned = builder.creditsEarned;
        this.courseYear = builder.courseYear;
    }

    public static class Builder
    {
        private int studNo;
        private String name, surname, courseCode;
        private int creditsEarned, courseYear;

        public Builder(int studNo, String name, String surname)
        {
            this.studNo = studNo;
            this.name = name;
            this.surname = surname;
        }

        public Builder courseCode(String courseCode)
        {
            this.courseCode = courseCode;
            return this;
        }

        public Builder creditsEarned(int creditsEarned)
        {
            this.creditsEarned = creditsEarned;
            return this;
        }

        public Builder courseYear(int courseYear)
        {
            this.courseYear = courseYear;
            return this;
        }

        public Builder copy(Student stud)
        {
            this.studNo = stud.studNo;
            this.name = stud.name;
            this.surname = stud.surname;
            this.courseCode = stud.courseCode;
            this.creditsEarned = stud.creditsEarned;
            this.courseYear = stud.courseYear;
            return this;
        }

        public Student build()
        {
            return new Student(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return studNo == student.studNo;

    }

    @Override
    public int hashCode() {
        return studNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studNo='" + studNo + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
