package com.example.ifoodmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        // Find the ImageView by its ID
        ImageView imageView = findViewById(R.id.imageView2);

        // Set an OnClickListener for the ImageView
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the login activity when the ImageView is clicked
                Intent intent = new Intent(homepage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
