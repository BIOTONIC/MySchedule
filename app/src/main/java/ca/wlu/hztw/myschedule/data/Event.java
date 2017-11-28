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

    public Event(String sname, String tname, String date, String startTime, String endTime, String title, String note) {
        this.sname = sname;
        this.tname = tname;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.note = note;
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
        return startTime + " - " + endTime;
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
        if (tname != "") {
            result += tname;
        }
        if (date != "") {
            result += sep;
            result += date;
        }
        if (startTime != "" && endTime != "") {
            result += sep;
            result += getTimeDuration();
        }
        if (note != "") {
            result += sep;
            result += "Note";
        }
        return result;
    }
}
