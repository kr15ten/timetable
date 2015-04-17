package za.ac.cput.kristen.timetable.domain;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by student on 2015/04/13.
 */

@Entity
public class Student implements Serializable
{
    private String studNo, name, surname, courseCode;
    private int creditsEarned, courseYear;

    public String getStudNo() {
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
        private String studNo, name, surname, courseCode;
        private int creditsEarned, courseYear;

        public Builder(String studNo, String name, String surname)
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

        public Student build()
        {
            return new Student(this);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (studNo != null ? !studNo.equals(student.studNo) : student.studNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return studNo != null ? studNo.hashCode() : 0;
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
