package ca.wlu.hztw.myschedule.main;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import ca.wlu.hztw.myschedule.R;

public class LimitListRecyclerAdapter extends RecyclerView.Adapter<LimitListRecyclerAdapter.ViewHolder> {

    private final MainPresenter presenter;
    private final MainContract.ItemClickListener listener;

    public LimitListRecyclerAdapter(MainPresenter presenter, MainContract.ItemClickListener listener) {
        this.presenter = presenter;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_limit_list, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        presenter.onBindLimitListViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return presenter.getLimitListItemCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private CardView cardView;
        private TextView limitTime;
        private TextView limitDesc;
        private Button deleteBtn;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cell_limit_card);
            limitTime = itemView.findViewById(R.id.cell_limit_time);
            limitDesc = itemView.findViewById(R.id.cell_limit_desc);
            deleteBtn = itemView.findViewById(R.id.cell_limit_delete);

            cardView.setOnClickListener(this);
            deleteBtn.setOnClickListener(this);
        }

        public void setLimitTime(String time) {
            limitTime.setText(time);
        }

        public void setLimitDesc(String desc) {
            limitDesc.setText(desc);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.cell_limit_card:
                    listener.onItemClick(v, getLayoutPosition());
                    break;
                case R.id.cell_limit_delete:
                    int pos = getLayoutPosition();
                    if (presenter.deleteLimit(v, pos)) {
                        notifyItemRemoved(pos);
                    }
                    break;
            }
        }
    }
}
