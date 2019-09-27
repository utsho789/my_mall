package com.example.mymall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity {

    private ViewFlipper imgFlipper;
    private RecyclerView recyclerView,secondRecylarview;
    private PopularAdapter popularAdapter;
    private CatgoryAdapter catgoryAdapter;
    private List<Popular>populars;
    private List<Catagory>catagoriesm;
    private  DatabaseReference  databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);



        imgFlipper = findViewById(R.id.imageFlipperId);

        int [] sliders = {R.drawable.image1,R.drawable.image33,R.drawable.image44};

        for(int slide : sliders){
            bannerFlipper(slide);
        }

        showCatagory();
        showDetails();







    }


    public  void bannerFlipper (int image){
        ImageView imageView = new ImageView(this);

        imageView.setImageResource(image);

        imgFlipper.addView(imageView);
        imgFlipper.setFlipInterval(6000);
        imgFlipper.setAutoStart(true);
        imgFlipper.setInAnimation(this,android.R.anim.fade_in);
        imgFlipper.setOutAnimation(this,android.R.anim.fade_out);




    }

    public  void showDetails(){

        recyclerView = findViewById(R.id.recyClearId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        populars = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("populars");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())


                {
                    Popular popular = dataSnapshot1.getValue(Popular.class);
                    populars.add(popular);



                }

                popularAdapter = new PopularAdapter(ShopActivity.this,populars);
                recyclerView.setAdapter(popularAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(ShopActivity.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });




    }

    public  void showCatagory(){
        secondRecylarview = findViewById(R.id.recCatgoryViewId);
        secondRecylarview.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this,2);
        secondRecylarview.setLayoutManager(manager);
        catagoriesm = new ArrayList<>();
        databaseReference =FirebaseDatabase.getInstance().getReference("catagory");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Catagory catagory = dataSnapshot1.getValue(Catagory.class);
                    catagoriesm.add(catagory);

                    catgoryAdapter = new CatgoryAdapter(ShopActivity.this,catagoriesm);
                    recyclerView.setAdapter(catgoryAdapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(ShopActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}
