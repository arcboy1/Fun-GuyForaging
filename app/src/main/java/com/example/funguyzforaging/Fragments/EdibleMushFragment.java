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
        add(new Mushroom("Black Trumpet", R.drawable.blacktrumpet, "Trumpet shaped, often brown or gray in color. Are sometimes refered to as black chanterelles. Despite their appearance, they don't have a very delicate flesh. With a rich and smoky flavour, you'll want to cook in something like a soup, sauce or seafood recipe.", "They grow around decaying material and trees. Black trumpets are most common in wooded areas near oak and beech trees. These are tough to spot because of their color, but if you see moss or other mushrooms, there’s a good chance trumpets are nearby."));
        add(new Mushroom("Bolete", R.drawable.bolete, "There are about 300 species of bolete and nearly all are edible. There are a couple that are better than others, like the king bolete, admirable bolete, and aspen bolete. They have a bulbous stem and large cap that are typically natural colors like tan and brown.\n\n It’s not uncommon to pick a bolete that is filled with worms and insects, rendering them inedible. Usually you’re able to find enough to salvage any harvest, though. Boletes are great for any cooking application, including dehydrating.", "Boletes grow in mature forests. They’re found near a variety of trees like pine, spruce, hemlock, fir, red cedar, aspen, and birch."));
        add(new Mushroom("Chanterelles", R.drawable.chanterelles, "Chanterelles are one of the most highly regarded wild mushrooms. They’re quite recognizable with their bright orange and yellow coloration. Some claim that they have a fruity smell that’s most often described as apricot. Jack-o-lantern mushrooms are very toxic and look somewhat alike, but the similarities end at color.\n\nThese are some of the easier mushrooms to work with in the kitchen. They clean easily and can be used in a ton of applications. Because of their vibrant color and great taste, I like to make them the focus of a dish—sautéed in a pan as an appetizer or loaded on top of a slice of wild game.", "Chanterelles grow in mature forests and are most common around maple, beech, poplar, birch, pine, fir, and oak trees. They’ll often grow in sizeable clusters that are easy to spot from a distance. Look for soil that has a lot of moisture, like low spots and waterways."));
        add(new Mushroom("Chicken of the Woods", R.drawable.chickenofthewoods, "Chicken of the woods are another one of the foolproof four, meaning there isn't really a chicken of the woods look alike. They get their name because of their rooster-like vibrant colors that are easily spotted in the woods. They exclusively grow on trees or out of the ground above roots. They sometimes grow in massive clusters too big for one person to harvest.\n\nChickens are a hardy mushroom, which allows you to use them  in a number of cooking applications. In the vegan world, these are a favorite substitute in any recipe that calls for chicken or tofu. I like them as chicken of the woods alfredo, chicken of the woods noodle soup, and chicken of the woods stir fry.", "Chickens are most likely to appear on freshly dead trees. The trees can be standing or fallen. On standing trees, you’ll often find them at waist height or lower, but I’ve also seen them 20 feet up."));
        add(new Mushroom("Honey Cap", R.drawable.honeyfungi, "Honeys have a pretty bland appearance. Their cap is smooth with gills attached to the stem or beginning to run down it. Their name comes from their color, not their taste—honey mushrooms will be white to slightly pinkish. They’ll grow in clusters and the stems will appear to originate from the same spot. Honeys have a variety of inedible lookalikes (some are even toxic). This isn't a beginner mushroom—make sure you know exactly what you're taking home.\n\nSome refer to honey mushrooms as slimy and unappetizing, but they still make for good table fare. You wouldn’t cook them to standalone like chickens or hens, but use them to compliment meats or vegetables.", "They’re most common in the Midwest and on the coasts. They’re often found around hardwoods that are rotting, dying, or dead, but will sometimes be found near wood chips or standing conifers."));
        add(new Mushroom("Lions Mane", R.drawable.lionsmane, "Lion’s manes are one of the ugliest edible mushrooms. They look like their namesake, along with their other monikers (bearded tooth mushroom and pom pom mushroom). They are white when fresh but turn yellow or brown when past their prime.\n\nLion’s manes have decent flavor and texture, but they’re more so sought after for their medicinal purposes. Many claim that they are good for brain health and help prevent dementia, Alzheimer’s, and Parkinson’s. Cook them for longer than most mushrooms because they contain so much moisture that takes plenty of time and heat to sweat out.", "They exclusively grow on hardwood trees, specifically oak and beech. Unlike most other mushrooms that grow on wood, these are usually found higher up in trees rather than at the base."));
        add(new Mushroom("Oysters", R.drawable.oyster, "Like chicken or hen of the woods, oysters exclusively grow on trees. Unlike chicken or hen of the woods, oysters have gills. They often grow in smaller clusters with a flat, fan-shaped appearance. Their colors don’t vary much; they’re almost always white.\n\nOysters are one of the few mushrooms from this list that you’ll find at the grocery store. They don’t have much for flavor but do have a great texture. Use them as a complimentary mushroom to meats, pastas, soups, and stir fry. Oysters are a popular choice for Asian cuisine.", "Oysters often grow on dying or dead hardwoods, like sugar maple and beech. They’ll grow on standing or fallen trees. They’re a common mushroom to find along waterways."));
        add(new Mushroom("Puffball", R.drawable.puffball, "Puffballs are possibly the easiest mushroom to recognize from this list. That's why they're considered one of the \"foolproof four\"—a group of wild mushrooms that are easy to identify and don’t have many inedible lookalikes. You’ll find them as small as a baseball and as big as a basketball. Immature varieties of other mushrooms can look like a puffball on the exterior, but you can cut them open to be sure. If the flesh is totally solid from one end to the other, then it’s a puffball. If there is any kind of hollow area, stem, or cap, then it’s something else.\n\nA quality puffball will have solid white flesh. If there is any hue of purple or black, either trim around those areas or toss the whole thing. Puffballs are often referred to as the breakfast mushroom because they pair so well with omelets and breakfast burritos. I use them as a complimentary mushroom on burgers or in pasta, but they can also be turned into imitation pizza crusts or mozzarella sticks.", "Puffballs grow everywhere but seem to favor disturbed areas. I’ve found them in open pastures and dense forests, so there’s no telling where this fungus will show up."));
        add(new Mushroom("Shaggy mane", R.drawable.shaggymane, "Shaggy manes aren't part of the foolproof four— but they could be. These ones have a distinct, scaly, conical cap that resembles a British barrister’s wig. Once they start to age, they’ll develop a black goo that starts at the bottom of the gills and works its way up.\n\nShaggy manes have a very delicate flesh and shorter shelf life than other wild edibles. Cook them within hours or days after harvest and use them on steaks, on burgers, in pastas, in soups, or in stir fry.", "This is the most likely edible mushroom to appear in your backyard. Shaggy manes love disturbed areas like bike trails, ditches, soccer fields, parks, boat ramps, game trails, etc. They’re more likely to grow in the open than dense cover."));
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

        MushroomAdapter adapter = new MushroomAdapter(edibleMushrooms);
        recyclerView.setAdapter(adapter);

        return view;
    }


}