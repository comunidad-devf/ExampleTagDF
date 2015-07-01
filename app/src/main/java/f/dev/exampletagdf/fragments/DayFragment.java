package f.dev.exampletagdf.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import f.dev.exampletagdf.R;
import f.dev.exampletagdf.adapters.SessionsAdapter;
import f.dev.exampletagdf.interfaces.OnItemClickListener;
import f.dev.exampletagdf.utils.FragmentPagerModel;

public class DayFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private int numberDate;

    @Bind(R.id.recyclerViewSessions)
    RecyclerView recyclerViewSessions;

    FloatingActionButton floatingActionButton;


    public static DayFragment newInstance(int numberDate) {
        DayFragment fragment = new DayFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, numberDate);
        fragment.setArguments(args);
        return fragment;
    }

    public DayFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            numberDate = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_day, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecyclerView();

    }

    private void initRecyclerView() {

        SessionsAdapter sessionsAdapter = new SessionsAdapter(getActivity());

        recyclerViewSessions.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerViewSessions.setAdapter(sessionsAdapter);

        sessionsAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                showSnackbar(itemView);
            }
        });

    }

    private void showSnackbar(View itemView) {
        Snackbar.make(itemView, R.string.message_selected_session, Snackbar.LENGTH_LONG)
                .setAction(R.string.ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
    }

    public static List<FragmentPagerModel> createPagerDates(Context context) {

        List<FragmentPagerModel> fragmentPagerModels = new ArrayList<>();

        fragmentPagerModels.add(new FragmentPagerModel(DayFragment.newInstance(1), context.getString(R.string.tab_date_one)));
        fragmentPagerModels.add(new FragmentPagerModel(DayFragment.newInstance(2), context.getString(R.string.tab_date_two)));
        fragmentPagerModels.add(new FragmentPagerModel(DayFragment.newInstance(3), context.getString(R.string.tab_date_three)));

        return fragmentPagerModels;
    }
}
