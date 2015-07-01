package f.dev.exampletagdf.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import f.dev.exampletagdf.R;
import f.dev.exampletagdf.interfaces.ReplaceToolbar;

public class GuetsFragment extends Fragment {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private ReplaceToolbar replaceToolbar;


    public GuetsFragment() {
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

        View rootView = inflater.inflate(R.layout.fragment_guets, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        replaceToolbar.onReplaceToolbar(toolbar);
    }


    @Override
    public void onDetach() {
        super.onDetach();

        replaceToolbar = null;
    }


}
