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
 * Use the {@link MagicMushFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MagicMushFragment extends Fragment {
    //populates magic mushroom list
    private List<Mushroom> magicMushrooms = new ArrayList<Mushroom>() {{
        add(new Mushroom("Blue Foot", R.drawable.bluefoot, "The Blue Foot mushroom features a distinctive blue-hued stem, adding a touch of enchantment to its appearance. Found in dense forests, this magical fungus is known for its delicious and golden cap. Foragers who seek a taste of the extraordinary are drawn to the forested realms where the Blue Foot may reveal its captivating presence.", "Forest"));
        add(new Mushroom("Blue Meanies", R.drawable.bluemeanies, "Known for their spongy and earthy texture, the Blue Meanies are a magical mushroom species that thrive in secluded woodlands. The enchanting blue tint of their caps adds an otherworldly quality to their appearance. For those seeking a connection to nature's mystical side, the woodlands provide a habitat where the Blue Meanies silently flourish.", "Woodland"));
        add(new Mushroom("Blue Ringer", R.drawable.blueringer, "The Blue Ringer is a magical mushroom with a cap that is commonly used in Asian cuisine for its unique flavors and properties. Cultivated in controlled environments, this mystical fungus has found its way into culinary practices. Those who wish to explore the magical and gastronomic realms may encounter the Blue Ringer in cultivated spaces dedicated to its growth.", "Cultivated"));
        add(new Mushroom("Flying Saucer", R.drawable.flyingsaucer, "The Flying Saucer mushroom, with its delicious and golden cap, adds an extraterrestrial touch to the forest floor. Nestled in the heart of lush forests, this magical fungus captures the imagination of foragers who are drawn to its unique appearance. The forest becomes a realm of wonder where the Flying Saucer manifests its magical allure.", "Forest"));
        add(new Mushroom("Landslide", R.drawable.landslidemushroom, "The Landslide mushroom, known for its spongy and earthy characteristics, can be found thriving in quiet woodlands. Its presence adds a touch of mystery to the woodland floor, inviting foragers to explore the magical qualities of this unique fungus. Woodland habitats become enchanting realms where the Landslide mushroom reveals its magic.", "Woodland"));
        add(new Mushroom("Pajaritos", R.drawable.pajaritos, "Pajaritos, a magical mushroom commonly used in Asian cuisine, brings its unique flavors to cultivated spaces. With its connection to culinary practices, this fungus is carefully nurtured in controlled environments. Foragers seeking the intersection of magic and cuisine may discover the enchanting Pajaritos in cultivated settings dedicated to its growth.", "Cultivated"));
        add(new Mushroom("Wavy Caps", R.drawable.wavycap, "The Wavy Caps, known for their delicious and golden appearance, can be found flourishing in the heart of dense forests. This magical mushroom species captures the essence of enchantment with its wavy caps and alluring presence. Foragers exploring the depths of the forest may encounter the magical Wavy Caps in their quest for the extraordinary.", "Forest"));


    }};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MagicMushFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MagicMushFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MagicMushFragment newInstance(String param1, String param2) {
        MagicMushFragment fragment = new MagicMushFragment();
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
    //sets up view and adds magicmushrooms list to mushroom adapter for recyclerview

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edible_mush, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewEdible);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);

        MushroomAdapter adapter = new MushroomAdapter(magicMushrooms);
        recyclerView.setAdapter(adapter);

        return view;
    }

}