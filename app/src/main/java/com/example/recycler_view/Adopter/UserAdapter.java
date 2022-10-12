package com.example.recycler_view.Adopter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler_view.Model.UserModel;
import com.example.recycler_view.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    Context context;
    List<UserModel> userModelList=new ArrayList<>();

    public UserAdapter(Context context, List<UserModel> userModelList) {
        this.context = context;
        this.userModelList = userModelList;
    }

    @NonNull
    @Override
    public UserAdapter.UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_horizontal,parent,false);
        return new UserHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserHolder holder, int position) {
        holder.textView.setText(userModelList.get(position).getName());
        holder.shapeableImageView.setImageResource(userModelList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public class UserHolder  extends RecyclerView.ViewHolder {

        ShapeableImageView shapeableImageView;
        TextView textView;
        public UserHolder(@NonNull View itemView) {
            super(itemView);

            shapeableImageView=itemView.findViewById(R.id.user_Image);
            textView=itemView.findViewById(R.id.horitext1);
        }
    }
}

