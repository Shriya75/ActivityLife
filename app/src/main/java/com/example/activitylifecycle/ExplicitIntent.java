package com.example.activitylifecycle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExplicitIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);
    }

    public void newsScreen(View view) {
        Intent i = new Intent(getApplicationContext(), ExplicitIntent.class);
        startActivity(i);
    }
}