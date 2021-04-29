package sg.edu.rp.c346.classjournal;

import java.io.Serializable;

public class Grade implements Serializable {
    private int week;
    private String grade;

    public Grade(int week, String grade) {
        this.week = week;
        this.grade = grade;
    }

    public int getWeek() {
        return week;
    }

    public String getGrade() {
        return grade;
    }
}
