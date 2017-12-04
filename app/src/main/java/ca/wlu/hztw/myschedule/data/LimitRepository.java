package ca.wlu.hztw.myschedule.data;

import java.util.ArrayList;

public class LimitRepository {
    private static LimitRepository INSTANCE = null;
    private ArrayList<Limit> limitList;

    private LimitRepository() {
        limitList = new ArrayList<>();
        limitList.add(new Limit("David", "2017-11-24", "10:00", "16:00"));
        limitList.add(new Limit("Song", "2017-11-25", "09:00", "14:00"));
        limitList.add(new Limit("Hoang", "2017-11-25", "09:30", "14:00"));
        limitList.add(new Limit("Ilias", "2017-11-26", "10:30", "12:00"));
    }

    public static synchronized LimitRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LimitRepository();
        }
        return INSTANCE;
    }

    public int getSize() {
        return limitList.size();
    }

    public String getDate(int pos) {
        return limitList.get(pos).getDate();
    }

    public String getTime(int pos) {
        return limitList.get(pos).getTime();
    }

    public void addNewLimit(Limit limit) {
        limitList.add(limit);
    }

    public boolean discardLimit(int pos) {
        if (pos >= limitList.size() || pos < 0) {
            return false;
        }
        limitList.remove(pos);
        return true;
    }
}
