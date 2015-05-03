package za.ac.cput.kristen.timetable.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/04/13.
 */
@Entity
public class Subject implements Serializable {
    @Id
    private String code;
    private String name;
    private int credits;


    private Subject() {
    }

    public Subject(Builder builder) {
        this.code = builder.code;
        this.name = builder.name;
        this.credits = builder.credits;
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


    public static class Builder {
        private String code;
        private String name;
        private int credits;

        public Builder(String code) {
            this.code = code;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder credits(int credits) {
            this.credits = credits;
            return this;
        }

        public Builder copy(Subject sub) {
            this.code = sub.code;
            this.name = sub.name;
            this.credits = sub.credits;
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
