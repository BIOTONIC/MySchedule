package ca.wlu.hztw.myschedule.event;

import ca.wlu.hztw.myschedule.data.Event;
import ca.wlu.hztw.myschedule.data.EventRepository;
import ca.wlu.hztw.myschedule.main.MainActivity;

public class EventPresenter {
    private EventRepository repository;

    public EventPresenter(EventRepository repository) {
        this.repository = repository;
    }

    public Event getEvent(int pos) {
        return repository.getEvent(pos, MainActivity.filter);
    }

    public boolean editNewEvent(int pos, String title, String date, String time, String note) {
        if (MainActivity.filter != 0) {
            return false;
        }
        String[] strs = time.split("-");
        String startTime = strs[0];
        String endTime = strs[1];
        Event event = repository.getEvent(pos, MainActivity.filter);
        event.setTitle(title);
        event.setDate(date);
        event.setStartTime(startTime);
        event.setEndTime(endTime);
        event.setNote(note);
        return repository.editNewEvent(pos, event);
    }

    public void addNewEvent(String title, String tname, String date, String time, String note) {
        String[] strs = time.split("-");
        String startTime = strs[0];
        String endTime = strs[1];
        Event event = new Event("sname", tname, date, startTime, endTime, title, note);
        repository.addNewEvent(event);
    }
}
