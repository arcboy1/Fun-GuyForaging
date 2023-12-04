package com.example.funguyzforaging.Fragments;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.funguyzforaging.ListView.ForagingItem;
import com.example.funguyzforaging.ListView.ForagingItemAdapter;
import com.example.funguyzforaging.MainActivity;
import com.example.funguyzforaging.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
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
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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


        View view=inflater.inflate(R.layout.fragment_home, container, false);
        TextView textView=view.findViewById(R.id.textView);
        ListView foragingListView=view.findViewById(R.id.foragingListView);
        ArrayList<ForagingItem> foragingItems=new ArrayList<>();
        //populates foragingitems list with info
        foragingItems.add(new ForagingItem("Field Guide", "A reliable field guidebook on mushrooms, preferably specific to your region."));
        foragingItems.add(new ForagingItem("Basket or Bag", "To carry the mushrooms you collect. It allows spores to disperse and helps in identification."));
        foragingItems.add(new ForagingItem("Knife", "For cutting and examining mushrooms. Ensure it's sharp and suitable for foraging."));
        foragingItems.add(new ForagingItem("Hand Lens", "A magnifying lens to examine smaller details like gills and spore prints."));
        foragingItems.add(new ForagingItem("Notebook and Pen", "For jotting down notes, observations, and sketches."));
        foragingItems.add(new ForagingItem("GPS or Map", "Helps you mark locations where you find specific mushrooms for future visits."));
        foragingItems.add(new ForagingItem("Flashlight", "Useful for mushroom foraging, especially in low-light conditions."));
        foragingItems.add(new ForagingItem("Weather-Appropriate Clothing", "Dress in layers and wear appropriate clothing and footwear for the weather and terrain."));
        foragingItems.add(new ForagingItem("Bug Repellent", "Depending on the season and location, insect repellent can be essential."));
        foragingItems.add(new ForagingItem("First Aid Kit", "A basic first aid kit for any minor injuries or accidents."));
        foragingItems.add(new ForagingItem("Mushroom Brush or Bristle Brush", "To clean dirt and debris from mushrooms."));
        foragingItems.add(new ForagingItem("Camera", "For documenting mushrooms and their habitats."));
        foragingItems.add(new ForagingItem("Permission and Regulations", "If foraging on private land, ensure you have permission. Be aware of local regulations regarding mushroom foraging."));


        //sets list to listview adapter
        Log.d("ForagingItems", "List contents: " + foragingItems.toString());
        ForagingItemAdapter adapter=new ForagingItemAdapter(requireContext(),foragingItems);
        foragingListView.setAdapter(adapter);

        //onclick uses showitemdescription method
        foragingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ForagingItem selectedForagingItem = (ForagingItem) parent.getItemAtPosition(position);
                if (selectedForagingItem != null) {
                    showItemDescription(selectedForagingItem.getDescription());
                }
            }
        });

        return view;
    }
    //method to create alert when listview item is clicked and show description
    private void showItemDescription(String description) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage(description)
                .setTitle("")
                .setPositiveButton("Got it!", null)
                .create()
                .show();

    }
}