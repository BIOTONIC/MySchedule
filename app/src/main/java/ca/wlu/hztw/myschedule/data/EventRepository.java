package ca.wlu.hztw.myschedule.data;

import java.util.ArrayList;

public class EventRepository {
    private static EventRepository INSTANCE = null;
    private ArrayList<Event> eventList;

    private EventRepository() {
        eventList = new ArrayList<>();
        eventList.add(new Event("TW", "David", "2017-11-24", "13:00", "14:00", "!@#$%^*()(*^%$#@#$%^*(*\\\\^%$#!@#$%^*()(*^%$#@#$%^*(*\\\\^%$#@!@#$%^*()(*^%$#@#$%^*(*\\\\^%$#@@", "qdnqonqoqnc"));
        eventList.add(new Event("ZY", "Song", "2017-11-25", "09:00", "10:00", "Android Quiz", "\n\nlalalala"));
        eventList.add(new Event("ZH", "Hoang", "2017-11-25", "10:30", "10:40", "Wireless Lab", "qqq"));
        eventList.add(new Event("LI", "Ilias", "2017-11-26", "11:20", "11:40", "Wireless Midterm", "lalala"));
    }

    public static synchronized EventRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EventRepository();
        }
        return INSTANCE;
    }

    public int getSize() {
        return eventList.size();
    }

    public String getTitle(int pos) {
        return eventList.get(pos).getTitle();
    }

    public String getDesc(int pos){return eventList.get(pos).getDesc();}

    public Event getEvent(int pos) {
        return eventList.get(pos);
    }
}

