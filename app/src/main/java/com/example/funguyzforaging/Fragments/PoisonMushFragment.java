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
        add(new Mushroom("Deadly Galerina", R.drawable.deadlygalerina, "The Deadly Galerina is a small, brown mushroom with a convex cap. It is often found in the quiet corners of deciduous and coniferous forests, preferring the damp and shaded areas beneath fallen leaves and decaying wood. Despite its unassuming appearance, this mushroom is highly toxic, containing deadly toxins that make it hazardous for consumption. Caution is advised when exploring wooded areas where the Deadly Galerina may be present.", "Deciduous and coniferous forests"));
        add(new Mushroom("Death Cap", R.drawable.deathcap, "The Death Cap presents a smooth cap, ranging from greenish to yellowish, atop a slender stem with white gills. This toxic mushroom thrives in mixed woodlands and gardens, where it often masquerades as harmless fungi. Its preference for damp environments and the rich soil of these settings makes it a perilous find for unsuspecting foragers. The Death Cap is notorious for its lethally poisonous nature, and extreme care should be taken to avoid accidental ingestion.", "Mixed woodlands and gardens"));
        add(new Mushroom("Destroying Angel", R.drawable.destroyingangel, "Elegance defines the Destroying Angel, a white mushroom with a delicate and silky cap. Flourishing in deciduous and coniferous forests, this toxic beauty can be found in areas with rich, organic soil. Though alluring in appearance, the Destroying Angel conceals a deadly secret – it contains potent toxins that can cause severe harm if consumed. Foragers should exercise extreme caution when encountering this mushroom in the wild.", "Deciduous and coniferous forests"));
        add(new Mushroom("False Morel", R.drawable.falsemorel, "The False Morel displays an irregularly shaped cap with a distinctive wrinkled appearance. Thriving in deciduous and mixed forests, this mushroom often emerges in the aftermath of spring rains. While it may bear a passing resemblance to true morels, the False Morel is not suitable for consumption, as it contains toxins that can lead to adverse health effects. As such, it's important for foragers to correctly identify this species and exercise caution when exploring suitable habitats.", "Deciduous and mixed forests"));
        add(new Mushroom("Fly Agaric", R.drawable.flyagaric, "The Fly Agaric stands out with its bright red cap adorned with characteristic white spots. Typically found in birch and pine forests, this iconic mushroom captivates with its enchanting appearance. Despite its popularity in folklore and fairy tales, the Fly Agaric is not suitable for consumption, as it contains psychoactive compounds that can induce hallucinations and other adverse effects. Foragers should admire its beauty from a safe distance without attempting to harvest or consume it.", "Birch and pine forests"));
        add(new Mushroom("Panther Cap", R.drawable.panthercap, "Distinguished by its dark brown to black cap, often with remnants of a veil, the Panther Cap adds an air of mystery to deciduous and coniferous forests. This mushroom, found in a variety of woodland settings, should be approached with caution, as it contains toxins that can cause illness if ingested. Foragers are advised to be mindful of its distinctive features and to avoid any attempts at consumption.", "Deciduous and coniferous forests"));
        add(new Mushroom("Smith's Samanita", R.drawable.smithsamanita, "Smith's Samanita is a large mushroom with a brown cap covered in prominent scales. This mushroom can be found in mixed woodlands and gardens, often making appearances in late summer and early fall. Though it may seem enticing, this mushroom is not suitable for consumption, as it contains compounds that can cause gastrointestinal distress. Foragers should exercise caution and refrain from harvesting this visually striking but inedible species.", "Mixed woodlands and gardens"));
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