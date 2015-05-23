package za.ac.cput.kristen.timetable.model;


import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/23/15.
 */
public class LecturerResource extends ResourceSupport
{
    private Long empNo;
    private String name, surname, qualification;

    private List<Subject> subjects;

    private List<Lesson> lessons;


    private LecturerResource() {
    }

    public LecturerResource(Builder builder) {
        name = builder.name;
        surname = builder.surname;
        qualification = builder.qualification;
        subjects = builder.subjects;
        lessons = builder.lessons;
    }

    public Long getEmpNo() {
        return empNo;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getQualification() {
        return qualification;
    }

    public Subject getSubject(int i) {
        return subjects.get(i);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Lesson> getLessons() {return lessons;}


    public static class Builder {
        private String name, surname, qualification;
        private List<Subject> subjects;
        private List<Lesson> lessons;

        public Builder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Builder qualifications(String qualification) {
            this.qualification = qualification;
            return this;
        }

        public Builder addSubject(Subject subject) {
            if (subjects.isEmpty())
                subjects = new ArrayList<Subject>();

            this.subjects.add(subject);
            return this;
        }

        public Builder subjects(List<Subject> subjects) {
            this.subjects = subjects;
            return this;
        }

        public Builder addLesson(Lesson lesson)
        {
            if (lessons.isEmpty())
                lessons = new ArrayList<Lesson>();

            this.lessons.add(lesson);
            return this;
        }

        public Builder lessons(List<Lesson> lessons)
        {
            this.lessons = lessons;
            return this;
        }

        public Builder copy(LecturerResource lect) {
            this.name = lect.name;
            this.qualification = lect.qualification;
            this.surname = lect.surname;
            this.subjects = lect.subjects;
            this.lessons = lect.lessons;
            return this;
        }

        public LecturerResource build() {
            return new LecturerResource(this);
        }
    }
}
