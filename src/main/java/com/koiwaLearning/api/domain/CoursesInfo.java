package com.koiwaLearning.api.domain;

public class CoursesInfo {

    private String cid;

    private String tno;

    private String courseName;

    public CoursesInfo() {
    }

    public CoursesInfo(String cid, String tno, String courseName) {
        this.cid = cid;
        this.tno = tno;
        this.courseName = courseName;
    }

    public String getId() {
        return cid;
    }

    public void setId(String cid) {
        this.cid = cid;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
