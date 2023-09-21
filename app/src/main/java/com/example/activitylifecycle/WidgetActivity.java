package com.example.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Toast;

public class WidgetActivity extends Activity {

    private static final int pic_id = 123;
    private Button cameraButton;
    private ImageView imageView;
    private CheckBox pizzaCheckBox, coffeeCheckBox, burgerCheckBox;
    private Button orderButton;
    private AutoCompleteTextView countryAutoComplete;
    private Button horizontalViewButton;
    private ToggleButton toggleButton;
    private TextView textView;

    String[] countries = {"India", "Australia", "West Indies", "Indonesia", "Indiana",
            "South Africa", "England", "Bangladesh", "Sri Lanka", "Singapore"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        // Initialize UI elements
        cameraButton = findViewById(R.id.camera_button);
        imageView = findViewById(R.id.click_image);
        pizzaCheckBox = findViewById(R.id.checkBox);
        coffeeCheckBox = findViewById(R.id.checkBox2);
        burgerCheckBox = findViewById(R.id.checkBox3);
        orderButton = findViewById(R.id.button);
        countryAutoComplete = findViewById(R.id.txtcountries);
        horizontalViewButton = findViewById(R.id.horizontal_view_button);
        toggleButton = findViewById(R.id.toggleButton);
        textView = findViewById(R.id.textView);

        // Set click listeners for buttons
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the camera_intent ACTION_IMAGE_CAPTURE to open the camera
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Start the activity with cameraIntent and request pic_id
                startActivityForResult(cameraIntent, pic_id);
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalAmount = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected Items:");

                if (pizzaCheckBox.isChecked()) {
                    result.append("\nPizza 100Rs");
                    totalAmount += 100;
                }
                if (coffeeCheckBox.isChecked()) {
                    result.append("\nCoffee 50Rs");
                    totalAmount += 50;
                }
                if (burgerCheckBox.isChecked()) {
                    result.append("\nBurger 120Rs");
                    totalAmount += 120;
                }

                result.append("\nTotal: " + totalAmount + "Rs");
                // Display the message on a toast
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }
        });

        // AutoCompleteTextView setup
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, countries);
        countryAutoComplete.setThreshold(3);
        countryAutoComplete.setAdapter(adapter);

        // Button to open HorizontalView activity
        horizontalViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WidgetActivity.this, HorizontalView.class));
            }
        });

        // ToggleButton click listener
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    textView.setText("Toggle is ON");
                } else {
                    textView.setText("Toggle is OFF");
                }
            }
        });
    }

    // This method will help to retrieve the image
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id && resultCode == RESULT_OK) {
            // BitMap is a data structure for storing images in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageView to display it
            imageView.setImageBitmap(photo);
        }
    }
}
