package za.ac.cput.kristen.timetable.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.kristen.timetable.domain.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/23/15.
 */
public class CourseResource extends ResourceSupport
{
    private String courseCode;
    private String name, qualification;
    private int years, credits;

    private List<Subject> subjects;


    private CourseResource() {
    }

    public CourseResource(Builder builder) {
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

    public Subject getSubject(int i) {
        return subjects.get(i);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public int getCredits() {
        return credits;
    }

    public static class Builder {
        private String courseCode, name, qualification;
        private int years, credits;
        private List<Subject> subjects;

        public Builder(String courseCode) {
            this.courseCode = courseCode;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder qualification(String qualification) {
            this.qualification = qualification;
            return this;
        }

        public Builder years(int years) {
            this.years = years;
            return this;
        }

        public Builder addSubject(Subject sub) {
            if (subjects == null)
                subjects = new ArrayList<Subject>();

            subjects.add(sub);
            return this;
        }

        public Builder subjects(List<Subject> subjects) {
            this.subjects = subjects;
            return this;
        }

        public Builder credits(int credits) {
            this.credits = credits;
            return this;
        }

        public Builder copy(CourseResource course) {
            this.courseCode = course.courseCode;
            this.credits = course.credits;
            this.name = course.name;
            this.qualification = course.qualification;
            this.subjects = course.subjects;
            this.years = course.years;
            return this;
        }

        public CourseResource build() {
            return new CourseResource(this);
        }
    }
}
