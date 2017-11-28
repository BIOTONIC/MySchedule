package ca.wlu.hztw.myschedule.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ca.wlu.hztw.myschedule.R;

import java.io.Serializable;

public class MainEventFragment extends Fragment {
    private final static String PRESENTER = "presenter";

    private MainPresenter presenter;

    public MainEventFragment() {
        // Required empty public constructor
    }

    public static MainEventFragment newInstance(Serializable presenter) {
        MainEventFragment fragment = new MainEventFragment();
        Bundle args = new Bundle();
        args.putSerializable(PRESENTER, presenter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_main, container, false);

        // get presenter
        presenter = (MainPresenter) getArguments().getSerializable(PRESENTER);

        return view;
    }
}
