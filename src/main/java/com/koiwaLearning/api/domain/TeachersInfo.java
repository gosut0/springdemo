package com.koiwaLearning.api.domain;

public class TeachersInfo {


    private String tid;

    private String tname;

    private String tsex;

    private String depart;
    
    private String tbirthday;
    
    private String prof;

    public TeachersInfo() {
		// TODO 自动生成的构造函数存根
	}

    public TeachersInfo(String tid, String tname, String tsex, String depart, String tbirthday, String prof) {
        this.tid = tid;
        this.tname = tname;
        this.tsex = tsex;
        this.depart = depart;
        this.tbirthday = tbirthday;
        this.prof = prof;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getTbirthday() {
        return tbirthday;
    }

    public void setTbirthday(String tbirthday) {
        this.tbirthday = tbirthday;
    }
    
    public String getProf() {
		return prof;
	}

    public void setProf(String prof) {
		this.prof = prof;
	}
}
