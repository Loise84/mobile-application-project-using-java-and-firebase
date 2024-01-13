package com.example.ifoodmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class shopping_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        // Find the backButton by its ID
        Button backButton = findViewById(R.id.button2);

        // Set an OnClickListener for the backButton
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate back to the home page (MainActivity)
                Intent intent = new Intent(shopping_activity.this, home.class);
                startActivity(intent);
                finish(); // Close the current activity
            }
        });
    }
}