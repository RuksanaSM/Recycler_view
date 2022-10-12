package com.example.grid_layout_manager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Recycler_Grid_Layout_Manager extends AppCompatActivity implements myInterface {

    RecyclerView recyclerView;
    ArrayList<UserModelClass> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recycler_grid_layout_manager);
            recyclerView = findViewById(R.id.recyclerview1);
            recyclerView.setHasFixedSize(true);

            arrayList = new ArrayList<>();
            arrayList.add(new UserModelClass(R.drawable.flower1, "pink Lily"));
            arrayList.add(new UserModelClass(R.drawable.rose, "Rose"));
            arrayList.add(new UserModelClass(R.drawable.flower2, "Red Flower"));
            arrayList.add(new UserModelClass(R.drawable.rose2, "Rose Flower"));
            arrayList.add(new UserModelClass(R.drawable.flower3, "Lotus"));
            arrayList.add(new UserModelClass(R.drawable.dark_pink, "Dark Pink Flower"));

            // added data from arraylist to adapter class.
            AdapterClass adapterClass = new AdapterClass(getApplicationContext(),arrayList,this);

            // setting grid layout manager to implement grid view.
            // in this method '2' represents number of columns to be displayed in grid view.
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);


            // at last set adapter to recycler view.
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(adapterClass);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onitemclick(int position) {
        Toast.makeText(this, "selected"+arrayList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
    }
}