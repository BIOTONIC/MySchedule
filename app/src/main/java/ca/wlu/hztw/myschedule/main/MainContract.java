package ca.wlu.hztw.myschedule.main;

import android.view.View;

public interface MainContract {
    interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
