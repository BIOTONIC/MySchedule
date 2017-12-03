package ca.wlu.hztw.myschedule.main;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import ca.wlu.hztw.myschedule.R;
import ca.wlu.hztw.myschedule.util.ColorManager;

public class EventListRecyclerAdapter extends RecyclerView.Adapter<EventListRecyclerAdapter.ViewHolder> {

    private final MainPresenter presenter;
    private final MainContract.ItemClickListener listener;

    public EventListRecyclerAdapter(MainPresenter presenter, MainContract.ItemClickListener listener) {
        this.presenter = presenter;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_event_list, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        presenter.onBindEventListViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return presenter.getEventListItemCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final CardView cardView;
        private final TextView eventTitle;
        private final TextView eventDesc;
        private final Button doneBtn;
        private final Button discardBtn;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cell_event_card);
            eventTitle = itemView.findViewById(R.id.cell_event_title);
            eventDesc = itemView.findViewById(R.id.cell_event_desc);
            doneBtn = itemView.findViewById(R.id.cell_event_done);
            discardBtn = itemView.findViewById(R.id.cell_event_discard);

            ColorManager colorManager = ColorManager.getInstance(itemView.getResources());
            doneBtn.setBackgroundColor(colorManager.getVibrant());

            cardView.setOnClickListener(this);
            doneBtn.setOnClickListener(this);
            discardBtn.setOnClickListener(this);
        }

        public void setEventTitle(String title) {
            eventTitle.setText(title);
        }

        public void setEventDesc(String desc) {
            eventDesc.setText(desc);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.cell_event_card:
                    listener.onItemClick(v, getLayoutPosition());
                    break;
                case R.id.cell_event_done:
                    int pos = getLayoutPosition();
                    if (presenter.doneEvent(v, pos)) {
                        notifyItemRemoved(pos);
                    }
                    break;
                case R.id.cell_event_discard:
                    pos = getLayoutPosition();
                    if (presenter.discardEvent(v, pos)) {
                        notifyItemRemoved(pos);
                    }
                    break;
            }
        }
    }
}
