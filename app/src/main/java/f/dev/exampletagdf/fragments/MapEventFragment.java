package f.dev.exampletagdf.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.Bind;
import butterknife.ButterKnife;
import f.dev.exampletagdf.R;
import f.dev.exampletagdf.interfaces.ReplaceToolbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapEventFragment extends Fragment implements OnMapReadyCallback {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private ReplaceToolbar replaceToolbar;


    public MapEventFragment() {
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

        View rootView = inflater.inflate(R.layout.fragment_map_event, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        replaceToolbar.onReplaceToolbar(toolbar);

        initMap();
    }

    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMyLocationEnabled(true);
        LatLng sydney = new LatLng(19.424906, -99.194936);
        googleMap.addMarker(new MarkerOptions().position(sydney).title(getString(R.string.app_name)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15));

    }

    @Override
    public void onDetach() {
        super.onDetach();

        replaceToolbar = null;
    }



}
