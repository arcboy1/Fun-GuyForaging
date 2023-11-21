package com.example.funguyzforaging.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.funguyzforaging.DataClass.Mushroom;
import com.example.funguyzforaging.R;
import com.example.funguyzforaging.RecyclerView.MushroomAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EdibleMushFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EdibleMushFragment extends Fragment {

    private List<Mushroom> edibleMushrooms = new ArrayList<Mushroom>() {{
        add(new Mushroom("Black Trumpet", R.drawable.blacktrumpet, "Delicious and golden", "Forest"));
        add(new Mushroom("Bolete", R.drawable.bolete, "Spongy and earthy", "Woodland"));
        add(new Mushroom("Chanterelles", R.drawable.chanterelles, "Commonly used in Asian cuisine", "Cultivated"));
        // Add more edible mushrooms as needed
    }};


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EdibleMushFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EdibleMushFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EdibleMushFragment newInstance(String param1, String param2) {
        EdibleMushFragment fragment = new EdibleMushFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edible_mush, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewEdible);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);

        MushroomAdapter adapter = new MushroomAdapter(edibleMushrooms, mushroom -> {
            // Handle item click (e.g., show enlarged image and details)
            showMushroomDetails(mushroom);
        });
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void showMushroomDetails(Mushroom mushroom) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        MushroomDetailFragment detailFragment = MushroomDetailFragment.newInstance(mushroom);

        fragmentTransaction.replace(R.id.nav_host_fragment_content_main, detailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}