package za.ac.cput.kristen.timetable.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.kristen.timetable.domain.Lesson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/23/15.
 */
public class SubjectResource extends ResourceSupport
{
    private String code;
    private String name;
    private int credits;

    private List<Lesson> lessons;


    private SubjectResource() {
    }

    public SubjectResource(Builder builder) {
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

        public Builder copy(SubjectResource sub) {
            this.code = sub.code;
            this.name = sub.name;
            this.credits = sub.credits;
            this.lessons = sub.lessons;
            return this;
        }

        public SubjectResource build() {
            return new SubjectResource(this);
        }
    }
}
