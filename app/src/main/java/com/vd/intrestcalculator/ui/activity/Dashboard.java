package com.vd.intrestcalculator.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.vd.intrestcalculator.R;
import com.vd.intrestcalculator.ui.adapters.ICListAdapter;
import com.vd.intrestcalculator.utils.DatabaseClient;
import com.vd.intrestcalculator.utils.ICDAO;
import com.vd.intrestcalculator.utils.ICDBSingleton;
import com.vd.intrestcalculator.utils.ICEntity;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    ExtendedFloatingActionButton addNewInterest;
    List<ICEntity> listOfInterests = new ArrayList<>();
    ICDAO icdao;
    LinearLayout noRecordsFoundLayout;
    RecyclerView listOfItems;
    ICListAdapter icListAdapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        icdao = DatabaseClient.getInstance(this).getDatabase().icdao();
        addNewInterest = findViewById(R.id.addNewInterest);
        addNewInterest.setOnClickListener(this);
        listOfItems = findViewById(R.id.listOfRecordsRV);
        noRecordsFoundLayout = findViewById(R.id.noRecordsFoundLayout);
        Context context;
        linearLayoutManager = new LinearLayoutManager(this);
    }

    private void getListOfRecords(){
        listOfInterests.clear();
        listOfInterests = icdao.getAll();
        if (listOfInterests.size() != 0){
            noRecordsFoundLayout.setVisibility(View.GONE);
        }
        else {
            noRecordsFoundLayout.setVisibility(View.VISIBLE);
        }

        icListAdapter = new ICListAdapter(this,listOfInterests);
        listOfItems.setLayoutManager(linearLayoutManager);
        listOfItems.setAdapter(icListAdapter);
        icListAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getListOfRecords();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addNewInterest:
                startActivity(new Intent(Dashboard.this,AddInterest.class));
                break;
        }
    }
}