package com.example.funguyzforaging.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import com.example.funguyzforaging.MainActivity;
import com.example.funguyzforaging.R;

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static final String TEXT_SIZE_KEY = "largerText";


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

        SwitchPreferenceCompat largerTextSwitch = findPreference(TEXT_SIZE_KEY);
        if (largerTextSwitch != null) {
            largerTextSwitch.setOnPreferenceChangeListener((preference, newValue) -> {
                boolean isLargerTextEnabled = (boolean) newValue;
                adjustTextSize(isLargerTextEnabled);
                return true;
            });
        }
    }

    private void adjustTextSize(boolean isLargerTextEnabled) {
        float textSizeMultiplier = isLargerTextEnabled ? 1.5f : 1f;

        // Apply the text size multiplier globally to the app's views
        ((MainActivity) requireActivity()).setTextSizeMultiplier(textSizeMultiplier);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        // Handle other preferences if needed
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }
}
