package com.example.funguyzforaging.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.funguyzforaging.DataClass.Mushroom;
import com.example.funguyzforaging.MainActivity;
import com.example.funguyzforaging.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MushroomDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MushroomDetailFragment extends Fragment {

    private ImageView imageView;
    private TextView nameTextView;
    private TextView descriptionTextView;
    private TextView locationTextView;

    private Mushroom mushroom;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MushroomDetailFragment() {
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

     * @return A new instance of fragment MushroomDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MushroomDetailFragment newInstance(String param1, String param2) {
        MushroomDetailFragment fragment = new MushroomDetailFragment();
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
        View view = inflater.inflate(R.layout.fragment_mushroom_detail, container, false);

        ImageView imageView = view.findViewById(R.id.imageViewDetail);
        TextView nameTextView = view.findViewById(R.id.nameTextViewDetail);
        TextView descriptionTextView = view.findViewById(R.id.descriptionTextViewDetail);
        TextView locationTextView = view.findViewById(R.id.locationTextViewDetail);

        Bundle args = getArguments();
            if (args != null) {
                imageView.setImageResource(args.getInt("DRAWABLE"));
                nameTextView.setText(args.getString("NAME"));
                descriptionTextView.setText(args.getString("DESCRIPTION"));
                locationTextView.setText(args.getString("LOCATION"));
            }




        return view;
    }
}