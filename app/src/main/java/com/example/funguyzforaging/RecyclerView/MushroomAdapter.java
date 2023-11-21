package com.example.funguyzforaging.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funguyzforaging.DataClass.Mushroom;
import com.example.funguyzforaging.R;

import java.util.List;

public class MushroomAdapter extends RecyclerView.Adapter<MushroomAdapter.MushroomViewHolder> {

    private List<Mushroom> mushrooms;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Mushroom mushroom);
    }

    public MushroomAdapter(List<Mushroom> mushrooms, OnItemClickListener listener) {
        this.mushrooms = mushrooms;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MushroomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mushroom, parent, false);
        return new MushroomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MushroomViewHolder holder, int position) {
        Mushroom mushroom = mushrooms.get(position);

        // Bind mushroom data to the ViewHolder views
        holder.nameTextView.setText(mushroom.getName());
        holder.imageView.setImageResource(mushroom.getImage());

        // Set click listener
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(mushroom);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mushrooms.size();
    }

    static class MushroomViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;

        MushroomViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
        }
    }





}
