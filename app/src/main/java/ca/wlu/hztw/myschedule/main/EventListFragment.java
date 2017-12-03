package ca.wlu.hztw.myschedule.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.ImageView;
import ca.wlu.hztw.myschedule.R;
import ca.wlu.hztw.myschedule.event.EventActivity;
import ca.wlu.hztw.myschedule.util.ColorManager;
import ca.wlu.hztw.myschedule.util.SimpleDividerItemDecoration;
import ca.wlu.hztw.myschedule.util.SwipeItemLayout;
import com.bumptech.glide.Glide;

import java.io.Serializable;

public class EventListFragment extends Fragment implements MainContract.ItemClickListener {
    private final static String PRESENTER = "presenter";

    private MainPresenter presenter;

    public EventListFragment() {
        // Required empty public constructor
    }

    public static EventListFragment newInstance(Serializable presenter) {
        EventListFragment fragment = new EventListFragment();
        Bundle args = new Bundle();
        args.putSerializable(PRESENTER, presenter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);

        // get presenter
        presenter = (MainPresenter) getArguments().getSerializable(PRESENTER);

        // RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.event_list_recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager recyclerLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(recyclerLayoutManager);

        // adapter
        EventListRecyclerAdapter recyclerAdapter = new EventListRecyclerAdapter(presenter, this);
        recyclerView.setAdapter(recyclerAdapter);

        // divider line
        SimpleDividerItemDecoration decoration = new SimpleDividerItemDecoration(getContext());
        recyclerView.addItemDecoration(decoration);

        // set item touch listener for swiping
        recyclerView.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(getContext()));

        // collapsing toolbar
        CollapsingToolbarLayout collapsingToolbar = getActivity().findViewById(R.id.main_collapsing_toolbar);
        collapsingToolbar.setTitle("MySchedule");
        // set image for collapsing toolbar
        ImageView imageView = getActivity().findViewById(R.id.backdrop);
        Glide.with(this)
                .load(ColorManager.getPicture())
                .into(imageView);
        ColorManager colorManager = ColorManager.getInstance(getActivity().getResources());
        collapsingToolbar.setStatusBarScrimColor(colorManager.getMuted());
        collapsingToolbar.setContentScrimColor(colorManager.getMuted());

        setHasOptionsMenu(true);
        return view;
    }

    // when item of recycler view is clicked
    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), EventActivity.class);
        intent.putExtra(MainActivity.EDIT_PARAM, position);
        getActivity().startActivityForResult(intent, MainActivity.EDIT_ACTIVITY);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_list_main, menu);
        menu.getItem(0).setVisible(true);
        menu.getItem(1).setVisible(true);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_calender:
                Snackbar.make(getActivity().getWindow().getDecorView(), "Show in Calender", Snackbar.LENGTH_SHORT).show();
                return true;
            case R.id.action_hide:
                Snackbar.make(getActivity().getWindow().getDecorView(), "Hide Completed Events", Snackbar.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}
