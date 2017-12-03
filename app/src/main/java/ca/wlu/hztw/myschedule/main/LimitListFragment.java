package ca.wlu.hztw.myschedule.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import ca.wlu.hztw.myschedule.R;
import ca.wlu.hztw.myschedule.event.EventActivity;
import ca.wlu.hztw.myschedule.limit.LimitActivity;
import ca.wlu.hztw.myschedule.util.ColorManager;
import ca.wlu.hztw.myschedule.util.SimpleDividerItemDecoration;
import ca.wlu.hztw.myschedule.util.SwipeItemLayout;
import com.bumptech.glide.Glide;

import java.io.Serializable;

public class LimitListFragment extends Fragment implements MainContract.ItemClickListener {
    private final static String PRESENTER = "presenter";

    private MainPresenter presenter;

    public LimitListFragment() {
        // Required empty public constructor
    }


    public static LimitListFragment newInstance(Serializable presenter) {
        LimitListFragment fragment = new LimitListFragment();
        Bundle args = new Bundle();
        args.putSerializable(PRESENTER, presenter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_limit_list, container, false);

        // get presenter
        presenter = (MainPresenter) getArguments().getSerializable(PRESENTER);

        // RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.limit_list_recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager recyclerLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(recyclerLayoutManager);

        // adapter
        LimitListRecyclerAdapter recyclerAdapter = new LimitListRecyclerAdapter(presenter, this);
        recyclerView.setAdapter(recyclerAdapter);

        // divider line
        SimpleDividerItemDecoration decoration = new SimpleDividerItemDecoration(getContext());
        recyclerView.addItemDecoration(decoration);

        // set item touch listener for swiping
        recyclerView.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(getContext()));

        // collapsing toolbar
        CollapsingToolbarLayout collapsingToolbar = getActivity().findViewById(R.id.main_collapsing_toolbar);
        collapsingToolbar.setTitle("Available Time");
        // set image for collapsing toolbar
        ImageView imageView = getActivity().findViewById(R.id.backdrop);
        Glide.with(this)
                .load(ColorManager.getPicture())
                .into(imageView);
        ColorManager colorManager = ColorManager.getInstance(getActivity().getResources());
        collapsingToolbar.setStatusBarScrimColor(colorManager.getMuted());
        collapsingToolbar.setContentScrimColor(colorManager.getMuted());

        setHasOptionsMenu(false);
        return view;
    }

    // when item of recycler view is clicked
    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), LimitActivity.class);
        intent.putExtra(MainActivity.LIMIT_PARAM, position);
        getActivity().startActivityForResult(intent, MainActivity.LIMIT_ACTIVITY);
    }

}
