package f.dev.exampletagdf.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import f.dev.exampletagdf.R;
import f.dev.exampletagdf.adapters.GuestsAdapter;
import f.dev.exampletagdf.interfaces.OnItemClickListener;
import f.dev.exampletagdf.interfaces.ReplaceToolbar;
import f.dev.exampletagdf.utils.GuestModel;

public class GuetsFragment extends Fragment {

    private ReplaceToolbar replaceToolbar;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.collapsingToolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @Bind(R.id.recyclerViewGuests)
    RecyclerView recyclerViewGuests;

    @Bind(R.id.imageViewbackdrop)
    ImageView imageViewbackdrop;


    private List<GuestModel> guestModelList;


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

        initRecyclerView();

        changeTittleToolbar(getString(R.string.app_name));
    }


    private void initRecyclerView() {

        guestModelList = createGuests();

        GuestsAdapter guestsAdapter = new GuestsAdapter(getActivity(), guestModelList);

        recyclerViewGuests.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerViewGuests.setAdapter(guestsAdapter);

        guestsAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                changeTittleToolbar(getString(guestModelList.get(position).getIdName()));
                Picasso.with(getActivity()).load(guestModelList.get(position).getIdImage()).into(imageViewbackdrop);

            }
        });

    }

    private void changeTittleToolbar(String title) {
        collapsingToolbar.setTitle(title);
    }




    @Override
    public void onDetach() {
        super.onDetach();

        replaceToolbar = null;
    }


    private static List<GuestModel> createGuests() {

        int[] nameGuests = {R.string.name_guest_1, R.string.name_guest_2, R.string.name_guest_3, R.string.name_guest_4};
        int[] imageGuets = {R.drawable.guest_1, R.drawable.guest_2, R.drawable.guest_3, R.drawable.guest_4};

        List<GuestModel> guestModels = new ArrayList<>();


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < nameGuests.length; j++) {
                guestModels.add(new GuestModel(imageGuets[j], nameGuests[j]));
            }
        }


        return guestModels;
    }

}
