package f.dev.exampletagdf.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import f.dev.exampletagdf.R;
import f.dev.exampletagdf.adapters.DiaryFragmentPagerAdapter;
import f.dev.exampletagdf.dialogs.SearchDialog;
import f.dev.exampletagdf.interfaces.ReplaceToolbar;

public class DiaryFragment extends Fragment {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Bind(R.id.tabLayout)
    TabLayout tabLayout;

    private ReplaceToolbar replaceToolbar;

    public DiaryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        replaceToolbar = (ReplaceToolbar) activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_diary, container, false);
            ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        replaceToolbar.onReplaceToolbar(toolbar);

        initViewPager();


    }

    private void initViewPager() {
        viewPager.setAdapter(new DiaryFragmentPagerAdapter(getChildFragmentManager(), DayFragment.createPagerDates(getActivity())));
        tabLayout.setupWithViewPager(viewPager);
    }

    @OnClick(R.id.floatingActionButton)
    public void onClick() {
        new SearchDialog().show(getFragmentManager(),null);

    }

    @Override
    public void onDetach() {
        super.onDetach();

        replaceToolbar = null;
    }


}
