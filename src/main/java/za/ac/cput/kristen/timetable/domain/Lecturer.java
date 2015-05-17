package za.ac.cput.kristen.timetable.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/13.
 */
@Entity
public class Lecturer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empNo;
    private String name, surname, qualification;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "lect_emp_no")
    private List<Subject> subjects;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer")
    private List<Lesson> lessons;


    private Lecturer() {
    }

    public Lecturer(Builder builder) {
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

        public Builder subject(List<Subject> subjects) {
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

        public Builder copy(Lecturer lect) {
            this.name = lect.name;
            this.qualification = lect.qualification;
            this.surname = lect.surname;
            this.subjects = lect.subjects;
            this.lessons = lect.lessons;
            return this;
        }

        public Lecturer build() {
            return new Lecturer(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lecturer lecturer = (Lecturer) o;

        return empNo == lecturer.empNo;

    }

    @Override
    public int hashCode() {
        return empNo != null ? empNo.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "empNo='" + empNo + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
