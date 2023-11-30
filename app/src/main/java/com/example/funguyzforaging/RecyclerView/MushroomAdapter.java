package com.example.funguyzforaging.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.funguyzforaging.DataClass.Mushroom;
import com.example.funguyzforaging.R;
import com.example.funguyzforaging.SharedPreferences.FavMushrooms;

import java.util.List;

public class MushroomAdapter extends RecyclerView.Adapter<MushroomAdapter.MushroomViewHolder> {

    private List<Mushroom> mushrooms;
    private OnFavoriteStatusChangedListener mListener;

    public interface OnFavoriteStatusChangedListener {
        void onFavoriteStatusChanged(Mushroom mushroom);
    }

    public void setOnFavoriteStatusChangedListener(OnFavoriteStatusChangedListener listener) {
        this.mListener = listener;
    }


    public MushroomAdapter(List<Mushroom> mushrooms) {

        this.mushrooms = mushrooms;
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

        holder.nameTextView.setText(mushroom.getName());
        holder.imageView.setImageResource(mushroom.getImage());

        int favoriteIconResId = mushroom.isFavorite() ? R.drawable.ic_baseline_favorite_24 : R.drawable.ic_heart_outline;
        holder.favouriteImageView.setImageResource(favoriteIconResId);


    }

    @Override
    public int getItemCount() {
        return mushrooms.size();
    }



    class MushroomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        protected ImageView imageView;
        protected TextView nameTextView;
        protected ImageView favouriteImageView;


        public MushroomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.nameTextView = itemView.findViewById(R.id.nameTextView);
            this.favouriteImageView=itemView.findViewById(R.id.favoriteImageView);

            itemView.setOnClickListener(this);
            favouriteImageView.setOnClickListener(view -> onFavoriteIconClick());
        }

        @Override
        public void onClick(View view) {
            Mushroom mushroom=mushrooms.get(getAdapterPosition());
            Bundle bundle = new Bundle();
            bundle.putInt("DRAWABLE",mushroom.getImage());
            bundle.putString("NAME", mushroom.getName());
            bundle.putString("DESCRIPTION", mushroom.getDescription());
            bundle.putString("LOCATION", mushroom.getLocation());
            Navigation.findNavController(view).navigate(R.id.action_nav_mushidentifier_to_mushroomDetailFragment,bundle);


        }

        private void onFavoriteIconClick() {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Mushroom mushroom = mushrooms.get(position);
                mushroom.setFavorite(!mushroom.isFavorite());


                if (mushroom.isFavorite()){
                    FavMushrooms.getInstance().getFavouriteMushroom().add(mushroom);
//                    FavMushrooms.getInstance().setFavourite(true);
                }else{
                    FavMushrooms.getInstance().getFavouriteMushroom().remove(mushroom);
//                    FavMushrooms.getInstance().setFavourite(false);
                }

                notifyDataSetChanged();

                Log.d("MushroomViewHolder", "Favorite icon clicked - Mushroom: " + mushroom.getName() +
                        ", New favorite status: " + mushroom.isFavorite());

            }
        }

    }







}
