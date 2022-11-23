package com.example.firebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView back;

    RecyclerView recyclerView;
    DatabaseReference database;
    cayThuocAdapter cayThuocAdapter;
    ArrayList<cayThuocNam> cayThuocNamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        returnLogin();

        recyclerView = findViewById(R.id.rcv_item);
        database = FirebaseDatabase.getInstance().getReference("Plants");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cayThuocNamList = new ArrayList<>();
        cayThuocNamList.add(new cayThuocNam("Bạc Hà", "Mentha arvensis L", R.drawable.bacha));
        cayThuocNamList.add(new cayThuocNam("Bách Bộ", "Stemona tuberosa Lour", R.drawable.bachbo));
        cayThuocNamList.add(new cayThuocNam("Bạch Đồng Nữ", "Clerodendrum chinense", R.drawable.bachdongnu));
        cayThuocNamList.add(new cayThuocNam("Bạch Hoa Xà Thiệt Thảo", "Hedyotis diffusa Willd", R.drawable.banhanam));
        cayThuocNamList.add(new cayThuocNam("Hạ Khô Thảo", "Prunella vulgaris L", R.drawable.bochinhsam));

        cayThuocAdapter = new cayThuocAdapter(this, cayThuocNamList);
        recyclerView.setAdapter(cayThuocAdapter);

//        database.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//
//                    cayThuocNam plant = dataSnapshot.getValue(cayThuocNam.class);
//                    cayThuocNamList.add(plant);
//                }
//                cayThuocAdapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

    }

    private void returnLogin(){
        back = (ImageView) findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}