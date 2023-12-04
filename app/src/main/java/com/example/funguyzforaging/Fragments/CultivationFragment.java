package com.example.funguyzforaging.Fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.funguyzforaging.MainActivity;

import com.example.funguyzforaging.R;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CultivationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CultivationFragment extends Fragment {

    private WebView webView;
    private ScrollView textGuideScrollView;
    private TextView textGuideTextView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CultivationFragment() {
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
     * @return A new instance of fragment CultivationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CultivationFragment newInstance(String param1, String param2) {
        CultivationFragment fragment = new CultivationFragment();
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
        View view=inflater.inflate(R.layout.fragment_cultivation, container, false);

        webView = view.findViewById(R.id.webView);

        //url for youtube video embedded
        String url="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/CfiXhWhXO9w?si=X5mu6BdVOJzFRlc9\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";

        //sets up webview
        webView.loadData(url,"text/html","utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkLoads(false);
        if (18 < Build.VERSION.SDK_INT ){
            webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        }

        webView.setWebChromeClient(new MyChrome());
        webView.setWebViewClient(new WebViewClient());


        textGuideScrollView = view.findViewById(R.id.textGuideScrollView);
        textGuideTextView = view.findViewById(R.id.textGuideTextView);

        //set textGuide string
        String textGuide = requireContext().getString(R.string.growing_mushrooms_guide);
//        textGuideTextView.setText(textGuide);
        textGuideTextView.setText(Html.fromHtml(textGuide));


        return view;
    }
    //created custom webchromeclient which will allow youtube video to open and close full screen mode
    public class MyChrome extends WebChromeClient {
        View fullscreen = null;

        @Override
        public void onHideCustomView() {
            if (fullscreen != null) {
                ((FrameLayout) requireActivity().getWindow().getDecorView()).removeView(fullscreen);
            }
            webView.setVisibility(View.VISIBLE);
        }

        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            webView.setVisibility(View.GONE);

            if (fullscreen != null) {
                ((FrameLayout) requireActivity().getWindow().getDecorView()).removeView(fullscreen);
            }

            fullscreen = view;
            ((FrameLayout) requireActivity().getWindow().getDecorView()).addView(fullscreen, new FrameLayout.LayoutParams(-1, -1));
            fullscreen.setVisibility(View.VISIBLE);
        }
    }

}

