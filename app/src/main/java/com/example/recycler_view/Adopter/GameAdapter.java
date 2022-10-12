package com.example.recycler_view.Adopter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler_view.MainActivity;
import com.example.recycler_view.Model.GameModel;
import com.example.recycler_view.MyInterface.OnItemClick;
import com.example.recycler_view.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameHolder> {
    Context context;
    List<GameModel> gameModelList=new ArrayList<>();
    OnItemClick onItemClick;

    public GameAdapter(Context context, List<GameModel> gameModelList) {
        this.context = context;
        this.gameModelList = gameModelList;
    }

    public GameAdapter(Context context, List<GameModel> gameModelList, OnItemClick onItemClick) {
        this.context = context;
        this.gameModelList = gameModelList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public GameHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root=LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_vertical,parent,false);
        return new GameHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull GameHolder holder, int position) {
        holder.game.setText(gameModelList.get(position).getName());
        holder.country.setText(gameModelList.get(position).getCountry());
        holder.team.setText(gameModelList.get(position).getPeople());
        holder.gameimage.setImageResource(gameModelList.get(position).getGameImg());
    }

    @Override
    public int getItemCount() {
        return gameModelList.size();
    }


    public class GameHolder extends RecyclerView.ViewHolder{
        TextView game,country,team;
       ShapeableImageView gameimage;

        public GameHolder(@NonNull View itemView) {
            super(itemView);
game=itemView.findViewById(R.id.game_name);
country=itemView.findViewById(R.id.game_country);
team=itemView.findViewById(R.id.game_people);
gameimage=itemView.findViewById(R.id.game_image);

    itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           onItemClick.Onclick(getAdapterPosition());
            Toast.makeText(context, "Selected"+gameModelList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();


        }
    });

        }
    }
}
