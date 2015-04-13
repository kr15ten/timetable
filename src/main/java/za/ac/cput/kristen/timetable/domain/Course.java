package za.ac.cput.kristen.timetable.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/13.
 */
public class Course implements Serializable
{
    private String courseCode, name, qualification;
    private int years, credits;
    private List<Subject> subjects;

    private Course()
    {
    }

    public Course(Builder builder)
    {
        courseCode = builder.courseCode;
        name = builder.name;
        qualification = builder.qualification;
        years = builder.years;
        subjects = builder.subjects;
        credits = builder.credits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getName() {
        return name;
    }

    public String getQualification() {
        return qualification;
    }

    public int getYears() {
        return years;
    }

    public Subject getSubject(int i)
    {
        return subjects.get(i);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public int getCredits()
    {
        return credits;
    }

    public static class Builder
    {
        private String courseCode, name, qualification;
        private int years, credits;
        private List<Subject> subjects;

        public Builder(String courseCode)
        {
            this.courseCode = courseCode;
        }

        public Builder name(String name)
        {
            this.name = name;
            return this;
        }

        public Builder qualification(String qualification)
        {
            this.qualification = qualification;
            return this;
        }

        public Builder years(int years)
        {
            this.years = years;
            return this;
        }

        public Builder addSubject(Subject sub)
        {
            subjects.add(sub);
            return this;
        }

        public Builder subjects(List<Subject> subjects)
        {
            this.subjects = subjects;
            return this;
        }

        public Builder credits(int credits)
        {
            this.credits = credits;
            return this;
        }

        public Course build()
        {
            return new Course(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        if (courseCode != null ? !courseCode.equals(course.courseCode) : course.courseCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return courseCode != null ? courseCode.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", name='" + name + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }
}
