package com.example.activitylifecycle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class myProgressbar extends AppCompatActivity {

    // on below line we are creating a variable.
    private Button showProgressBtn;
    private ProgressBar loadingPB;
    boolean isProgressVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_progressbar);
        showProgressBtn = findViewById(R.id.idBtnDisplayProgress);
        loadingPB = findViewById(R.id.idPBLoading);

        // on below line we are adding click listener for our button
        showProgressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are checking if
                // progress bar is already visible.
                if (isProgressVisible) {
                    // if it is visible we are
                    // updating text for our button.
                    showProgressBtn.setText("Show Progress Bar");
                    // on below line we are changing
                    // its visibility
                    loadingPB.setVisibility(View.GONE);

                    // on below line we are updating
                    // is progress visible to false
                    isProgressVisible = false;
                } else {
                    // this condition will be called if
                    // progress bar visibility is gone
                    isProgressVisible = true;

                    // on below line we are updating
                    // text for our button.
                    showProgressBtn.setText("Hide Progress Bar");

                    // on below line we are changing
                    // visibility for our progress bar.
                    loadingPB.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}