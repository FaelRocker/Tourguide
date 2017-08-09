package com.android.rafael.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location("Hotel 1", "Fake Street, 000", "(00) 0000-0000", R.drawable.hotel));
        locations.add(new Location("Hotel 2", "Fake Street, 000", "(00) 0000-0000", R.drawable.hotel));
        locations.add(new Location("Hotel 3", "Fake Street, 000", "(00) 0000-0000", R.drawable.hotel));
        locations.add(new Location("Hotel 4", "Fake Street, 000", "(00) 0000-0000", R.drawable.hotel));
        locations.add(new Location("Hotel 5", "Fake Street, 000", "(00) 0000-0000", R.drawable.hotel));
        locations.add(new Location("Hotel 6", "Fake Street, 000", "(00) 0000-0000", R.drawable.hotel));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent photoIntent = new Intent(getActivity(), PhotoActivity.class);

                photoIntent.putExtra("image",locations.get(position).getImageResourceId());
                startActivity(photoIntent);
            }
        });
        return rootView;
    }

}
