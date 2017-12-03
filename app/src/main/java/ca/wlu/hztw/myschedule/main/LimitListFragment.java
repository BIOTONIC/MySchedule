package ca.wlu.hztw.myschedule.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ca.wlu.hztw.myschedule.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LimitListFragment extends Fragment {


    public LimitListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_limit_list, container, false);
    }

}
