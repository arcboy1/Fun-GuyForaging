package com.example.funguyzforaging;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.funguyzforaging.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    NavController navController;
    private float textSizeMultiplier=1.0f;

    private List<View> excludedViews = new ArrayList<>();


    @Override
    protected void onResume() {
        super.onResume();

        excludedViews.clear(); // Clear the list

        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        excludedViews.add(headerView); // Exclude NavigationView header
        excludedViews.add(findViewById(R.id.textView)); // Exclude TextView with id "textView"

        // Apply the global text size modifier to the entire content view
        applyTextSizeMultiplier(findViewById(android.R.id.content));
    }

    public float getTextSizeMultiplier() {
        return textSizeMultiplier;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        float radius = getResources().getDimension(R.dimen.roundcorner);
        NavigationView navigationView = binding.navView;
        MaterialShapeDrawable navViewBackground = (MaterialShapeDrawable) navigationView.getBackground();
        navViewBackground.setShapeAppearanceModel(
                navViewBackground.getShapeAppearanceModel()
                        .toBuilder()
                        .setTopRightCorner(CornerFamily.ROUNDED,radius)
                        .build());
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,R.id.nav_mushidentifier,R.id.nav_cultivation,R.id.nav_favourites,R.id.nav_expedition,R.id.nav_settings,R.id.nav_userupload,R.id.nav_credits)
                .setOpenableLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                navController.navigate(R.id.nav_settings);
                break;
        }
        return super.onOptionsItemSelected(item);

    }
    public void setTextSizeMultiplier(float multiplier) {
        textSizeMultiplier = multiplier;
        applyTextSizeMultiplier(findViewById(android.R.id.content));
    }

    public void applyTextSizeMultiplier(View view) {
        if (excludedViews.contains(view)) {
            return;
        }

        if (view instanceof TextView) {
            float originalTextSize = ((TextView) view).getTextSize();
            float newTextSize = originalTextSize * textSizeMultiplier;
            ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_PX, newTextSize);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                applyTextSizeMultiplier(viewGroup.getChildAt(i));
            }
        }
    }


}