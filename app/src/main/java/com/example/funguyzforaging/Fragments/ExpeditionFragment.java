package com.example.funguyzforaging.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.funguyzforaging.MainActivity;
import com.example.funguyzforaging.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExpeditionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExpeditionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExpeditionFragment() {
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
     * @return A new instance of fragment ExpeditionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExpeditionFragment newInstance(String param1, String param2) {
        ExpeditionFragment fragment = new ExpeditionFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expedition, container, false);


        TextView expeditionTitle1 = view.findViewById(R.id.expeditionTitle1);
        ImageView expeditionImage1 = view.findViewById(R.id.expeditionImage1);
        Button bookButton1 = view.findViewById(R.id.bookButton1);
        Button mapButton1 = view.findViewById(R.id.mapButton1);
        TextView descriptionText1 = view.findViewById(R.id.descriptionText1);

        TextView expeditionTitle2 = view.findViewById(R.id.expeditionTitle2);
        ImageView expeditionImage2 = view.findViewById(R.id.expeditionImage2);
        Button bookButton2 = view.findViewById(R.id.bookButton2);
        Button mapButton2 = view.findViewById(R.id.mapButton2);
        TextView descriptionText2 = view.findViewById(R.id.descriptionText2);

        TextView expeditionTitle3 = view.findViewById(R.id.expeditionTitle3);
        ImageView expeditionImage3 = view.findViewById(R.id.expeditionImage3);
        Button bookButton3 = view.findViewById(R.id.bookButton3);
        Button mapButton3 = view.findViewById(R.id.mapButton3);
        TextView descriptionText3 = view.findViewById(R.id.descriptionText3);

        //on click for book buttons
        bookButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail("Book Winter Expedition", "I would like to book the Winter Expedition.");
            }
        });

        bookButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail("Book Spring Expedition", "I would like to book the Spring Expedition.");
            }
        });

        bookButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail("Book Summer Expedition", "I would like to book the Summer Expedition.");
            }
        });
        mapButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLocationOnMap("Whistler, British Columbia, Canada");
            }
        });

        mapButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLocationOnMap("Okanagan Valley, British Columbia, Canada");
            }
        });

        mapButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLocationOnMap("Vancouver Island, British Columbia, Canada");
            }
        });


        return view;
    }

    //method to create email intent and set subject and body
    private void sendEmail(String subject, String body) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:")); // Only email apps should handle this
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"w0707566@myscc.ca"}); // Set recipient email address
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);

//        if (emailIntent.resolveActivity(requireActivity().getPackageManager()) != null) {
//            startActivity(emailIntent);
//        } else {
//            Toast.makeText(requireContext(), "No email app found", Toast.LENGTH_SHORT).show();
//        }
        startActivity(emailIntent);

    }
    //method to create map intent for each expedition
    private void showLocationOnMap(String location) {
        Uri geoLocation = Uri.parse("geo:0,0?q=" + Uri.encode(location));

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoLocation);

//        if (mapIntent.resolveActivity(requireActivity().getPackageManager()) != null) {
//            startActivity(mapIntent);
//        } else {
//            // Handle the case where no map app is available
//            Toast.makeText(requireContext(), "No map app found", Toast.LENGTH_SHORT).show();
//        }
        startActivity(mapIntent);
    }
}