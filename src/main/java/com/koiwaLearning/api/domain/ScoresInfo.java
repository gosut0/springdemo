package com.koiwaLearning.api.domain;

public class ScoresInfo {

    private String sname;

    private String courseName;

    private String degree;

    public ScoresInfo() {
    }

    public ScoresInfo(String sname, String degree, String courseName) {
        this.sname = sname;
        this.degree = degree;
        this.courseName = courseName;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
