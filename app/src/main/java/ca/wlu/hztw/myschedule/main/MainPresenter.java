package ca.wlu.hztw.myschedule.main;

import android.view.View;
import ca.wlu.hztw.myschedule.data.EventRepository;

import java.io.Serializable;

public class MainPresenter implements Serializable {

    private transient EventRepository repository;

    public MainPresenter(EventRepository repository) {
        this.repository = repository;
    }

    public void onBindListViewHolder(MainRecyclerAdapter.ViewHolder holder, int position) {
        holder.setTitle(repository.getTitle(position));
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
}
