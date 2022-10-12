package com.example.recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recycler_view.Adopter.GameAdapter;
import com.example.recycler_view.Adopter.UserAdapter;
import com.example.recycler_view.Model.GameModel;
import com.example.recycler_view.Model.UserModel;
import com.example.recycler_view.MyInterface.OnItemClick;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClick {

    RecyclerView recyclerView_h,recyclerView_v;
    //Horizontal
    UserModel userModel;
    UserAdapter userAdapter;
    List<UserModel> userModelList=new ArrayList<>();

    //Vertical
    GameModel gameModel;
    GameAdapter gameAdapter;
    List<GameModel> gameModelList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView_h=findViewById(R.id.recyclerid1);
        recyclerView_v=findViewById(R.id.recycler_v);


        recyclerView_h.setHasFixedSize(true);
        recyclerView_v.setHasFixedSize(true);

        //Layout Manger
        recyclerView_h.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
       recyclerView_v.setLayoutManager(new LinearLayoutManager(this));

        userAdapter=new UserAdapter(getApplicationContext(),userModelList);
        recyclerView_h.setAdapter(userAdapter);

        //Vertical Adapter
        gameAdapter=new GameAdapter(getApplicationContext(),gameModelList,this);
        recyclerView_v.setAdapter(gameAdapter);

        loadHorizontalMethod();
        loadVerticalMethod();

    }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    private void loadVerticalMethod() {
        gameModel=new GameModel(R.drawable.cricket,"Cricket","India","11");
        gameModelList.add(gameModel);
        gameModel=new GameModel(R.drawable.hockey,"Hockey","India","11");
        gameModelList.add(gameModel);
        gameModel=new GameModel(R.drawable.basketball,"BasketBall","India","6");
        gameModelList.add(gameModel);
        gameModel=new GameModel(R.drawable.footbal,"Foot Ball","India","11");
        gameModelList.add(gameModel);
        gameModel=new GameModel(R.drawable.badmiton,"BadMintan","India","4");
        gameModelList.add(gameModel);
        gameModel=new GameModel(R.drawable.tennis,"Tennis","India","2");
        gameModelList.add(gameModel);
        gameAdapter.notifyDataSetChanged();
    }


    private void loadHorizontalMethod() {
        userModel=new UserModel(R.drawable.student1,"Karuna");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.student2,"Aishawarya");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.student5,"Goopika");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.student3,"Sanjay");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.student4,"Ram");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.student6,"Sai");
        userModelList.add(userModel);
        userModel=new UserModel(R.drawable.student5,"Raju");
        userModelList.add(userModel);

        userAdapter.notifyDataSetChanged();
    }




    @Override
    public void Onclick(int position) {
        Toast.makeText(this, ""+gameModelList.get(position).getName(), Toast.LENGTH_SHORT).show();

    }
}