package com.example.staggered_gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.UserHolder> {

    Context context;
   List<UserModel> list=new ArrayList<>();
   StagGridInterace onitemclick;

    public AdapterClass(Context context, List<UserModel> list, StagGridInterace onitemclick) {
        this.context = context;
        this.list = list;
        this.onitemclick = onitemclick;
    }

// Constructor for initialization


    public AdapterClass(Context context, List<UserModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root=LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_gridview_layout,parent,false);

        return new UserHolder(root);
    }

    // Binding data to the into specified position
    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        // TypeCast Object to int type
       // int res = (int) images.get(position);
       holder.img.setImageResource(list.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class UserHolder extends RecyclerView.ViewHolder {
        ImageView img;

        public UserHolder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.imgvw1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "selected"+list.get(getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
