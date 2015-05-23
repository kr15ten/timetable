package za.ac.cput.kristen.timetable.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by kris on 5/23/15.
 */
public class StudentResource extends ResourceSupport
{
    private Long studNo;
    private String name, surname, courseCode;
    private int creditsEarned, courseYear;


    public Long getStudNo() {
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

    private StudentResource() {
    }

    public StudentResource(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.courseCode = builder.courseCode;
        this.creditsEarned = builder.creditsEarned;
        this.courseYear = builder.courseYear;
    }

    public static class Builder {
        private String name, surname, courseCode;
        private int creditsEarned, courseYear;

        public Builder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Builder courseCode(String courseCode) {
            this.courseCode = courseCode;
            return this;
        }

        public Builder creditsEarned(int creditsEarned) {
            this.creditsEarned = creditsEarned;
            return this;
        }

        public Builder courseYear(int courseYear) {
            this.courseYear = courseYear;
            return this;
        }

        public Builder copy(StudentResource stud) {
            this.name = stud.name;
            this.surname = stud.surname;
            this.courseCode = stud.courseCode;
            this.creditsEarned = stud.creditsEarned;
            this.courseYear = stud.courseYear;
            return this;
        }

        public StudentResource build() {
            return new StudentResource(this);
        }
    }
}
