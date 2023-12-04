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

    // called when the fragment is created to set up preferences from XML resource
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

    //method uses a float to toggle large or normal text size for the application
    //applies to all text
    private void adjustTextSize(boolean isLargerTextEnabled) {
        float textSizeMultiplier = isLargerTextEnabled ? 1.5f : 1f;

        ((MainActivity) requireActivity()).setTextSizeMultiplier(textSizeMultiplier);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
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
