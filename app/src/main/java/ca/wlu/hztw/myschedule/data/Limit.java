package ca.wlu.hztw.myschedule.data;

import java.io.Serializable;

public class Limit implements Serializable {
    private String tname;
    private String date;
    private String startTime;
    private String endTime;

    public Limit(String tname, String date, String startTime, String endTime) {
        this.tname = tname;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return startTime + '-' + endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
