package com.example.funguyzforaging.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.funguyzforaging.DataClass.Mushroom;
import com.example.funguyzforaging.MainActivity;
import com.example.funguyzforaging.R;
import com.example.funguyzforaging.RecyclerView.FavMushroomAdapter;
import com.example.funguyzforaging.RecyclerView.MushroomAdapter;
import com.example.funguyzforaging.SharedPreferences.FavMushrooms;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavouriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavouriteFragment extends Fragment implements MushroomAdapter.OnFavoriteStatusChangedListener {

    private RecyclerView recyclerView;
    private FavMushroomAdapter adapter;
    private List<Mushroom> favoriteMushrooms = FavMushrooms.getInstance().getFavouriteMushroom();


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FavouriteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();

        // Check if the text size multiplier has changed
        if (getActivity() instanceof MainActivity && ((MainActivity) getActivity()).getTextSizeMultiplier() != 1.0f) {
            ((MainActivity) getActivity()).applyTextSizeMultiplier(requireView());
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FavouriteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavouriteFragment newInstance(String param1, String param2) {
        FavouriteFragment fragment = new FavouriteFragment();
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
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewFavourites);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);



        adapter = new FavMushroomAdapter(favoriteMushrooms);
//        favoriteMushrooms.add(new Mushroom("Test Mushroom", R.drawable.bolete, "Test Description", "Test Location"));
        adapter.notifyDataSetChanged();
        adapter.setOnFavoriteStatusChangedListener(this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onFavoriteStatusChanged(Mushroom mushroom) {
        Log.d("FavouriteFragment", "Favorite status changed for: " + mushroom.getName() + ", New status: " + mushroom.isFavorite());

        // check if the dataset change is triggered
        recyclerView.getAdapter().notifyDataSetChanged();

        // check if the mushroom is now a favorite and add/remove it from the list
        if (mushroom.isFavorite()) {
            if (!favoriteMushrooms.contains(mushroom)) {
                favoriteMushrooms.add(mushroom);
                Log.d("FavouriteFragment", "Added to favorites: " + mushroom.getName());
            }
        } else {
            boolean removed = favoriteMushrooms.remove(mushroom);
            Log.d("FavouriteFragment", "Removed from favorites: " + mushroom.getName() + ", Removed: " + removed);
        }

    }
}