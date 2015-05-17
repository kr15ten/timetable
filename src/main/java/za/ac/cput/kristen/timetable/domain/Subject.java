package za.ac.cput.kristen.timetable.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/13.
 */
@Entity
public class Subject implements Serializable {
    @Id
    private String code;
    private String name;
    private int credits;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "subject")
    private List<Lesson> lessons;


    private Subject() {
    }

    public Subject(Builder builder) {
        this.code = builder.code;
        this.name = builder.name;
        this.credits = builder.credits;
        this.lessons = builder.lessons;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
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
        private String code;
        private String name;
        private int credits;
        private List<Lesson> lessons;

        public Builder(String code, String name)
        {
            this.code = code;
            this.name = name;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder credits(int credits) {
            this.credits = credits;
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

        public Builder copy(Subject sub) {
            this.code = sub.code;
            this.name = sub.name;
            this.credits = sub.credits;
            this.lessons = sub.lessons;
            return this;
        }

        public Subject build() {
            return new Subject(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;

        Subject subject = (Subject) o;

        if (code != null ? !code.equals(subject.code) : subject.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
