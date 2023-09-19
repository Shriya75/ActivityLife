package com.example.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MyAutoCompleteActivity extends Activity {

    String[] countries = {"India", "Australia", "West Indies", "Indonesia", "Indiana",
            "South Africa", "England", "Bangladesh", "Sri Lanka", "Singapore"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView textView = findViewById(R.id.txtcountries);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, countries);

        // Set the threshold here
        textView.setThreshold(3);
        textView.setAdapter(adapter);
    }
}
