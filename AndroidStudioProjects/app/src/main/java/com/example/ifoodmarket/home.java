package com.example.ifoodmarket;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class home extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        auth=FirebaseAuth.getInstance();
        user =auth.getCurrentUser();
        if (user==null){
            Intent intent= new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        }
       

        // Find the ImageView by its ID
        ImageView imageView = findViewById(R.id.imageView13);

        // Set an OnClickListener for the ImageView
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the login activity when the ImageView is clicked
                Intent intent = new Intent(home.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView fruitsImage = findViewById(R.id.imageView6);

        fruitsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event, for example, navigate to another activity
                Intent intent = new Intent(home.this, shopping_activity.class);
                startActivity(intent);
            }
        });
        // Set up click listener for vegetables category
        ImageView vegetablesImage = findViewById(R.id.imageView7);
        vegetablesImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event, for example, navigate to another activity
                Intent intent = new Intent(home.this, vegetables.class);
                startActivity(intent);
            }
        });
    }

    // The onClick method defined in XML layout
    public void onFruitsImageClick(View view) {
        // Handle the click event, if needed
    }
    // The onClick method defined in XML layout for vegetables category
    public void onVegetablesImageClick(View view) {
        // Handle the click event, if needed
    }
}

