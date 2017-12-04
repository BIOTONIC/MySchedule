package ca.wlu.hztw.myschedule.data;

import java.util.ArrayList;

public class EventRepository {
    private static EventRepository INSTANCE = null;
    private ArrayList<Event> eventList;
    private ArrayList<Event> todoList;
    private ArrayList<Event> completedList;
    private ArrayList<Event> discardedList;

    private EventRepository() {
        eventList = new ArrayList<>();
        eventList.add(new Event("TW", "David", "2017-11-24", "13:00", "14:00", "Quantum Lab", "qdnqonqoqnc"));
        eventList.add(new Event("ZY", "Song", "2017-11-25", "09:00", "10:00", "Android Quiz", "\n\nlalalala"));
        eventList.add(new Event("ZH", "Hoang", "2017-11-25", "10:30", "10:40", "Wireless Lab", ""));
        eventList.add(new Event("LI", "Ilias", "2017-11-26", "11:20", "11:40", "Wireless Midterm", ""));

        todoList = new ArrayList<>();
        for (Event event : eventList) {
            todoList.add(event);
        }
        completedList = new ArrayList<>();
        discardedList = new ArrayList<>();
    }

    public static synchronized EventRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EventRepository();
        }
        return INSTANCE;
    }

    public int getSize(int filter) {
        if (filter == 0) {
            return todoList.size();
        } else if (filter == 1) {
            return completedList.size();
        } else if (filter == 2) {
            return discardedList.size();
        } else {
            return eventList.size();
        }
    }

    public String getTitle(int pos, int filter) {
        if (filter == 0) {
            return todoList.get(pos).getTitle();
        } else if (filter == 1) {
            return completedList.get(pos).getTitle();
        } else if (filter == 2) {
            return discardedList.get(pos).getTitle();
        } else {
            return eventList.get(pos).getTitle();
        }
    }

    public String getDesc(int pos, int filter) {
        if (filter == 0) {
            return todoList.get(pos).getDesc();
        } else if (filter == 1) {
            return completedList.get(pos).getDesc();
        } else if (filter == 2) {
            return discardedList.get(pos).getDesc();
        } else {
            return eventList.get(pos).getDesc();
        }
    }

    public Event getEvent(int pos, int filter) {
        if (filter == 0) {
            return todoList.get(pos);
        } else if (filter == 1) {
            return completedList.get(pos);
        } else if (filter == 2) {
            return discardedList.get(pos);
        } else {
            return eventList.get(pos);
        }

    }

    public boolean editNewEvent(int pos, Event event) {
        Event old = todoList.get(pos);
        todoList.set(pos, event);
        int index = eventList.indexOf(old);
        if (index > -1) {
            eventList.set(index, event);
            return true;
        }
        return false;
    }

    public void addNewEvent(Event event) {
        eventList.add(event);
        todoList.add(event);
    }

    public boolean completeEvent(int pos) {
        Event e = todoList.get(pos);
        boolean result = e.setCompleted();
        if (result) {
            eventList.set(pos, e);
            todoList.remove(e);
            completedList.add(e);
        }
        return result;
    }

    public boolean discardEvent(int pos) {
        Event e = todoList.get(pos);
        boolean result = e.setDiscarded();
        if (result) {
            eventList.set(pos, e);
            todoList.remove(e);
            discardedList.add(e);
        }
        return result;
    }
}

