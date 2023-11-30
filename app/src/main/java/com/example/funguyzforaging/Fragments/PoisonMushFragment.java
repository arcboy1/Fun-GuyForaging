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
 * Use the {@link PoisonMushFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PoisonMushFragment extends Fragment {

    //populates poisonmushroom list

    private List<Mushroom> poisonMushrooms = new ArrayList<Mushroom>() {{
        add(new Mushroom("Deadly Galerina", R.drawable.deadlygalerina, "Delicious and golden", "Forest"));
        add(new Mushroom("Death Cap", R.drawable.deathcap, "Spongy and earthy", "Woodland"));
        add(new Mushroom("Destroying Angel", R.drawable.destroyingangel, "Commonly used in Asian cuisine", "Cultivated"));
        add(new Mushroom("False Morel", R.drawable.falsemorel, "Delicious and golden", "Forest"));
        add(new Mushroom("Fly Agaric", R.drawable.flyagaric, "Spongy and earthy", "Woodland"));
        add(new Mushroom("Panther Cap", R.drawable.panthercap, "Commonly used in Asian cuisine", "Cultivated"));
        add(new Mushroom("Smith's Samanita", R.drawable.smithsamanita, "Commonly used in Asian cuisine", "Cultivated"));
    }};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PoisonMushFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PoisonMushFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PoisonMushFragment newInstance(String param1, String param2) {
        PoisonMushFragment fragment = new PoisonMushFragment();
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
    //sets up view and adds poisonmushroom list to mushroom adapter for recyclerview
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edible_mush, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewEdible);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);

        MushroomAdapter adapter = new MushroomAdapter(poisonMushrooms);
        recyclerView.setAdapter(adapter);

        return view;
    }

}