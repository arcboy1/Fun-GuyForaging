package com.example.funguyzforaging.ImageAdapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.funguyzforaging.R;

import java.util.List;

public class ImageAdapter extends ArrayAdapter<Uri> {
    public ImageAdapter(Context context, List<Uri> imageList) {
        super(context, R.layout.item_photo, imageList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.photoImageView);

        Uri imageUri = getItem(position);
        if (imageUri != null) {
            imageView.setImageURI(imageUri);
        }

        return convertView;
    }
}

