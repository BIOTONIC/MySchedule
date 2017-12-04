package ca.wlu.hztw.myschedule.data;

import java.io.Serializable;

public class Event implements Serializable {
    private String sname;
    private String tname;
    private String date;
    private String startTime;
    private String endTime;
    private String title;
    private String note;
    private int state;

    public Event(String sname, String tname, String date, String startTime, String endTime, String title, String note) {
        this.sname = sname;
        this.tname = tname;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.note = note;
        this.state = 0;
    }

    public String getSname() {
        return sname;
    }

    public String getTname() {
        return tname;
    }

    public String getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getTimeDuration() {
        return startTime + "-" + endTime;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public String getDesc() {
        String sep = " · ";
        String result = "";
        if (tname != "" && tname != null) {
            result += tname;
        }
        if (date != "" && date != null) {
            result += sep;
            result += date;
        }
        if (startTime != "" && startTime != null && endTime != "" && endTime != null) {
            result += sep;
            result += getTimeDuration();
        }
        if (note != "" && note != null) {
            result += sep;
            result += "Note";
        }
        return result;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean setCompleted() {
        if (state == 0) {
            state = 1;
            return true;
        } else {
            return false;
        }
    }

    public boolean setDiscarded() {
        if (state == 0) {
            state = 2;
            return true;
        } else {
            return false;
        }
    }
}
