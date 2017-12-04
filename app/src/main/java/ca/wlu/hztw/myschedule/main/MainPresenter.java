package ca.wlu.hztw.myschedule.main;

import android.view.View;
import ca.wlu.hztw.myschedule.data.EventRepository;
import ca.wlu.hztw.myschedule.data.LimitRepository;

import java.io.Serializable;

public class MainPresenter implements Serializable {

    private transient EventRepository eRepository;
    private transient LimitRepository lRepository;

    public MainPresenter(EventRepository eRepository, LimitRepository lRepository) {
        this.eRepository = eRepository;
        this.lRepository = lRepository;
    }

    public void onBindEventListViewHolder(EventListRecyclerAdapter.ViewHolder holder, int position) {
        holder.setEventTitle(eRepository.getTitle(position, MainActivity.filter));
        holder.setEventDesc(eRepository.getDesc(position, MainActivity.filter));
    }

    public int getEventListItemCount() {
        return eRepository.getSize(MainActivity.filter);
    }

    public boolean doneEvent(View view, int pos) {
        return eRepository.completeEvent(pos);
    }

    public boolean discardEvent(View view, int pos) {
        return eRepository.discardEvent(pos);
    }

    public void onBindLimitListViewHolder(LimitListRecyclerAdapter.ViewHolder holder, int position) {
        holder.setLimitTime(lRepository.getTime(position));
        holder.setLimitDesc(lRepository.getDate(position));
    }

    public int getLimitListItemCount() {
        return lRepository.getSize();
    }

    public boolean deleteLimit(View view, int pos) {
        return lRepository.discardLimit(pos);
    }
}
