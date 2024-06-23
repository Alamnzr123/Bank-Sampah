package com.example.banksampah.activity.user;

import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.banksampah.R;
import com.example.banksampah.adapter.SampahAdapter;
import com.example.banksampah.adapter.SetorSampahAdapter;
import com.example.banksampah.model.JenisSampah;
import com.example.banksampah.model.SetorSampah;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class RiwayatActivity extends AppCompatActivity {

    SetorSampahAdapter adapter;
    Toolbar toolbar;
    RecyclerView rvRiwayat;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);

        rvRiwayat = (RecyclerView) findViewById(R.id.recyclerView_riwayat);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        rvRiwayat.setLayoutManager(layoutManager);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Riwayat Setor");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));


        FirebaseRecyclerOptions<SetorSampah> options =
                new FirebaseRecyclerOptions.Builder<SetorSampah>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("SetorSampah"), SetorSampah.class)
                        .build();

        adapter = new SetorSampahAdapter(options);
        rvRiwayat.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
