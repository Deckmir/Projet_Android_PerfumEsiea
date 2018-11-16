package com.example.vincenttieng.perfumesiea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class ListPerfume extends AppCompatActivity {
    
    FirebaseDatabase database;
    DatabaseReference perfume;
    String categoryId = "";
    FirebaseRecyclerAdapter <Perfume, PerfumeView> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_perfum);
        
       loadListPerfume(categoryId);
    }

    private void loadListPerfume(String categoryId) {
    }


}
