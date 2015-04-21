package za.ac.cput.kristen.timetable.domain;



import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by student on 2015/04/13.
 */
@Entity
public class Exam implements Serializable
{
    private Date startTime;
    private double hours, subjectContribution;
    private String topic;
    private Subject subject;
    private Boolean prac;

    private Exam(){}

    public Exam(Builder builder)
    {
        startTime = builder.startTime;
        hours = builder.hours;
        subjectContribution = builder.subjectContribution;
        topic = builder.topic;
        subject = builder.subject;
        prac = builder.prac;
    }

    public Date getStartTime() {
        return startTime;
    }

    public double getHours() {
        return hours;
    }

    public double getSubjectContribution() {
        return subjectContribution;
    }

    public String getTopic() {
        return topic;
    }

    public Subject getSubject() {
        return subject;
    }

    public Boolean getPrac() {
        return prac;
    }

    public static class Builder
    {
        private Date startTime;
        private double hours, subjectContribution;
        private String topic;
        private Subject subject;
        private Boolean prac;

        public Builder(double subjectContribution, String topic, Subject subject)
        {
            this.subjectContribution = subjectContribution;
            this.topic = topic;
            this.subject = subject;
        }

        public Builder startTime(Date startTime)
        {
            this.startTime = startTime;
            return this;
        }

        public Builder hours(double hours)
        {
            this.hours = hours;
            return this;
        }

        public Builder practical(Boolean prac)
        {
            this.prac = prac;
            return this;
        }

        public Builder copy(Exam exam)
        {
            this.startTime = exam.startTime;
            this.hours = exam.hours;
            this.subjectContribution = exam.subjectContribution;
            this.topic = exam.topic;
            this.subject = exam.subject;
            this.prac = exam.prac;
            return this;
        }

        public Exam build()
        {
            return new Exam(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exam)) return false;

        Exam exam = (Exam) o;

        if (startTime != null ? !startTime.equals(exam.startTime) : exam.startTime != null) return false;
        if (subject != null ? !subject.equals(exam.subject) : exam.subject != null) return false;
        if (topic != null ? !topic.equals(exam.topic) : exam.topic != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = startTime != null ? startTime.hashCode() : 0;
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Exam{" +
                "startTime=" + startTime +
                ", topic='" + topic + '\'' +
                ", subject=" + subject +
                '}';
    }
}
