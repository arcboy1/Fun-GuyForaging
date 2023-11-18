package com.example.funguyzforaging.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.funguyzforaging.R;

import java.util.List;

public class ForagingItemAdapter extends ArrayAdapter<ForagingItem> {

    public ForagingItemAdapter(@NonNull Context context, @NonNull List<ForagingItem> foragingItems) {
        super(context, 0, foragingItems);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ForagingItem foragingItem = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_view, parent, false);
            TextView textView = convertView.findViewById(R.id.name);
            // Set the text to display item name along with its position
            textView.setText((position+1) + ". " + foragingItem.getName());
        }

        return convertView;
    }

}
