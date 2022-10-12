package com.example.staggered_gridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaggeredGridViewMainActivity extends AppCompatActivity  implements StagGridInterace{
    RecyclerView recyclerView;
 UserModel userModel;
 AdapterClass adapterClass;
 List<UserModel> userModelList=new ArrayList<>();

    // Using ArrayList to store images data
//ArrayList arrayList = new ArrayList<>(Arrays.asList(R.drawable.twitter, R.drawable.instagram, R.drawable.youtube, R.drawable.linkedin, R.drawable.facebook, R.drawable.dropbox, R.drawable.pinterest));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_staggered_grid_view_main);

            // Getting reference of recyclerView
            recyclerView=findViewById(R.id.recyclervw1);
            recyclerView.setHasFixedSize(true);

            // Setting the layout as Staggered Grid for vertical orientation
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

            staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
            recyclerView.setLayoutManager(staggeredGridLayoutManager);


            // Sending reference and data to Adapter
            adapterClass=new AdapterClass(getApplicationContext(),userModelList,this);
            recyclerView.setAdapter(adapterClass);

            loaduserData();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loaduserData() {
        userModel=new UserModel(R.drawable.instagram,"Instagram");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.linkedin,"Linked In");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.facebook,"Facebook");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.dropbox,"Drop box");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.twitter,"Twitter");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.youtube,"Youtube");
        userModelList.add(userModel);


        adapterClass.notifyDataSetChanged();



    }


    @Override
    public void onclick(int position) {
        Toast.makeText(this, "Selected"+userModelList.get(position), Toast.LENGTH_SHORT).show();
    }
}