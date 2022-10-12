package com.example.grid_layout_manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.UserHolder> {
    Context context;
    List<UserModelClass> list=new ArrayList<>();
    myInterface interface1;
     LayoutInflater layoutInflater;
    public AdapterClass(Context context, List<UserModelClass> list, myInterface interface1) {
        this.context = context;
        this.list = list;
        this.interface1 = interface1;
    }

    public AdapterClass(Context context, List<UserModelClass> list) {
        this.context = context;
        this.list = list;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public AdapterClass.UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_grid_layout_manager,parent,false);
        return new UserHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        // Set the data to textview and imageview.
        UserModelClass Data =list.get(position);
        holder.textView.setText(list.get(position).getTitle());
        holder.imageView.setImageResource(list.get(position).getImages());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public UserHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.idimgvw);
            textView=itemView.findViewById(R.id.idtextvw);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Selected :"+list.get(getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
