package za.ac.cput.kristen.timetable.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by kris on 5/23/15.
 */
public class LessonResource extends ResourceSupport
{
    private Long resId;
    private String topic;
    private Boolean prac;

    private LessonResource() {
    }

    public LessonResource(Builder builder) {
        topic = builder.topic;
        prac = builder.prac;
    }

    public Long getResId()
    {
        return resId;
    }

    public String getTopic() {
        return topic;
    }

    public Boolean getPrac() {
        return prac;
    }

    public static class Builder {
        private String topic;
        private Boolean prac;

        public Builder() {

        }


        public Builder topic(String topic) {
            this.topic = topic;
            return this;
        }

        public Builder practical(Boolean prac) {
            this.prac = prac;
            return this;
        }

        public Builder copy(LessonResource lesson) {
            this.topic = lesson.topic;
            this.prac = lesson.prac;
            return this;
        }

        public LessonResource build() {
            return new LessonResource(this);
        }
    }
}
