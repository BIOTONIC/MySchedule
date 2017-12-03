package ca.wlu.hztw.myschedule.main;

import android.view.View;
import ca.wlu.hztw.myschedule.data.Event;
import ca.wlu.hztw.myschedule.data.EventRepository;

import java.io.Serializable;

public class MainPresenter implements Serializable {

    private transient EventRepository repository;

    public MainPresenter(EventRepository repository) {
        this.repository = repository;
    }

    public void onBindEventListViewHolder(EventListRecyclerAdapter.ViewHolder holder, int position) {
        holder.setEventTitle(repository.getTitle(position));
        holder.setEventDesc(repository.getDesc(position));
    }

    public int getEventListItemCount() {
        return repository.getSize();
    }

    public boolean doneEvent(View view, int pos) {
        return false;
    }

    public boolean discardEvent(View view, int pos) {
        return false;
    }

    public void onBindLimitListViewHolder(LimitListRecyclerAdapter.ViewHolder holder, int position) {
        holder.setLimitTime("12:00-13:00");
        holder.setLimitDesc("Every Mon Wed Fri");
    }

    public int getLimitListItemCount() {
        return 5;
    }

    public boolean deleteLimit(View view, int pos) {
        return false;
    }
}
