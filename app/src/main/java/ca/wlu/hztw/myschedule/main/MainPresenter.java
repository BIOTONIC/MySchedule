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

    public void onBindListViewHolder(EventListRecyclerAdapter.ViewHolder holder, int position) {
        holder.setEventTitle(repository.getTitle(position));
        holder.setEventDesc(repository.getDesc(position));
    }

    public int getListItemCount() {
        return repository.getSize();
    }

    public boolean doneEvent(View view, int pos) {
        return false;
    }

    public boolean dropEvent(View view, int pos) {
        return false;
    }

    public Event getEvent(int pos){
        return repository.getEvent(pos);
    }
}
