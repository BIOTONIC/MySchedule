package ca.wlu.hztw.myschedule.main;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import ca.wlu.hztw.myschedule.R;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    private final MainPresenter presenter;
    private final MainContract.ItemClickListener listener;

    public MainRecyclerAdapter(MainPresenter presenter, MainContract.ItemClickListener listener){
        this.presenter = presenter;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_event_main, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        presenter.onBindListViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return presenter.getListItemCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final CardView cardView;
        private final TextView eventTitle;
        private final Button doneBtn;
        private final Button dropBtn;

        public ViewHolder(View itemView){
            super(itemView);

            cardView = itemView.findViewById(R.id.event_card);
            eventTitle = itemView.findViewById(R.id.event_title);
            doneBtn = itemView.findViewById(R.id.done_btn);
            dropBtn = itemView.findViewById(R.id.drop_btn);

            cardView.setOnClickListener(this);
            doneBtn.setOnClickListener(this);
            dropBtn.setOnClickListener(this);
        }

        public void setTitle(String title){
            eventTitle.setText(title);
        }

        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.event_card:
                    listener.onItemClick(v,getLayoutPosition());
                    break;
                case R.id.done_btn:
                    int pos = getLayoutPosition();
                    if(presenter.doneEvent(v,pos)){
                        notifyItemRemoved(pos);
                    }
                    break;
                case R.id.drop_btn:
                    pos = getLayoutPosition();
                    if(presenter.dropEvent(v, pos)){
                        notifyItemRemoved(pos);
                    }
                    break;
            }
        }
    }
}
