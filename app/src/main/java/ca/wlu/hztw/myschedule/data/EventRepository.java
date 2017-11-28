package ca.wlu.hztw.myschedule.data;

import java.util.ArrayList;

public class EventRepository {
    private static EventRepository INSTANCE = null;
    private ArrayList<Event> eventList;

    private EventRepository(){
        eventList = new ArrayList<>();
        eventList.add(new Event(11,21,"2017-11-24 13:00:00","2017-11-24 13:30:00", "!@#$%^*()(*^%$#@#$%^*(*\\\\^%$#!@#$%^*()(*^%$#@#$%^*(*\\\\^%$#@!@#$%^*()(*^%$#@#$%^*(*\\\\^%$#@@"));
        eventList.add(new Event(12,21,"2017-11-25 09:00:00","2017-11-25 09:15:00", "Android Quiz"));
        eventList.add(new Event(13,22,"2017-11-25 10:00:00","2017-11-25 10:30:00", "Wireless Lab"));
        eventList.add(new Event(14,22,"2017-11-26 14:00:00","2017-11-24 15:00:00","Wireless Midterm"));
    }

    public static synchronized EventRepository getInstance(){
        if(INSTANCE == null){
            INSTANCE = new EventRepository();
        }
        return INSTANCE;
    }

    public int getSize(){
        return eventList.size();
    }

    public String getTitle(int pos){
        return eventList.get(pos).getTitle();
    }
}

