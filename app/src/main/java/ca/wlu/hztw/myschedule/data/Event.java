package ca.wlu.hztw.myschedule.data;

public class Event {
    private int sId;
    private int tId;
    private String startTime;
    private String endTime;
    private String title;

    public Event(int sId, int tId, String startTime, String endTime, String title) {
        this.sId = sId;
        this.tId = tId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}
