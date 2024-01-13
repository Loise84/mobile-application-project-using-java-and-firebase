package com.example.ifoodmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class vegetables extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);
        // Find the backButton by its ID
        Button backButton = findViewById(R.id.button2);

        // Set an OnClickListener for the backButton
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate back to the home page (MainActivity)
                Intent intent = new Intent(vegetables.this, home.class);
                startActivity(intent);
                finish(); // Close the current activity
            }
        });
    }
}