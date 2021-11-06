package com.vd.intrestcalculator.ui.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.vd.intrestcalculator.R;
import com.vd.intrestcalculator.utils.DatabaseClient;
import com.vd.intrestcalculator.utils.ICDBSingleton;
import com.vd.intrestcalculator.utils.ICEntity;

import java.util.Calendar;
import java.util.Random;

public class AddInterest extends AppCompatActivity implements View.OnClickListener{

    EditText personName,dateAmountTaken,amountOfInterest,interestPercentage;
    Button addNewEntry;
    Calendar calendar;
    LinearLayout container;
    String nameOfThePerson,dateInterestTaken,amountTaken,percentageOfInterest = "";
    ICDBSingleton dbClient;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_interest);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbClient = DatabaseClient.getInstance(this).getDatabase();
        calendar = Calendar.getInstance();
        container = findViewById(R.id.container);
        personName = findViewById(R.id.personName);
        dateAmountTaken = findViewById(R.id.dateInterestTaken);
        amountOfInterest = findViewById(R.id.amountTaken);
        interestPercentage = findViewById(R.id.interestPercentage);
        addNewEntry = findViewById(R.id.addNewEntry);
        addNewEntry.setOnClickListener(this);
        dateAmountTaken.setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addNewEntry:
                validateFields();
                break;
            case R.id.dateInterestTaken:
                dateAmountTaken.setError(null);
                dateAmountTaken.clearFocus();
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, month+1, dayOfMonth);
                        dateInterestTaken = dayOfMonth+"/"+(month+1)+"/"+year;
                        dateAmountTaken.setText(dateInterestTaken);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
        }
    }

    private void validateFields() {
        nameOfThePerson = personName.getText().toString();
        dateInterestTaken = dateAmountTaken.getText().toString();
        amountTaken = amountOfInterest.getText().toString();
        percentageOfInterest = interestPercentage.getText().toString();

        if (nameOfThePerson.equalsIgnoreCase("")){
            personName.setError("Please enter person name");
        }else if (dateInterestTaken.equalsIgnoreCase("")){
            dateAmountTaken.setError("Please pick the date");
        }else if (amountTaken.equalsIgnoreCase("")){
            amountOfInterest.setError("Please enter amount");
        }else if (Integer.parseInt(amountTaken) <= 0){
            amountOfInterest.setError("Amount should always be greater than 1");
        } else if (percentageOfInterest.equalsIgnoreCase("")){
            interestPercentage.setError("Please enter percentage of interest");
        }else if (Integer.parseInt(percentageOfInterest) <= 0){
            interestPercentage.setError("Percentage should always be 1 or greater than 1");
        }else {
            dbClient.icdao().insert(new ICEntity(new Random().nextInt(),nameOfThePerson,dateInterestTaken,amountTaken,percentageOfInterest));
            Toast.makeText(this, "Record created successfully.....!!", Toast.LENGTH_SHORT).show();
        }
    }


}