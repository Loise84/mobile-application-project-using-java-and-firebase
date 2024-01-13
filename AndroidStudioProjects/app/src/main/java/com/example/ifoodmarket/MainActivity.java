package com.example.ifoodmarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private TextView t_username, t_password ,forgotPasswordTextView;
    private Button login,signupButton;
    private Spinner s_usertype;  // Initialize the Spinner
    private FirebaseAuth mAuth;
    String username, password, user_type;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        t_password = findViewById(R.id.editTextPassword);
        t_username = findViewById(R.id.editTextUsername);
        login = findViewById(R.id.buttonLogin);
        signupButton = findViewById(R.id.createaccount);
        forgotPasswordTextView = findViewById(R.id.textView);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = t_username.getText().toString().trim();
                password = t_password.getText().toString().trim();

                if (username.isEmpty()) {
                    t_username.setError("Please enter the username!");
                }

                if (password.isEmpty()) {
                    t_password.setError("Please enter the password!");
                }
                mAuth.signInWithEmailAndPassword(username, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(MainActivity.this, "Login successful.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(),home.class);
                                    startActivity(intent);

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(MainActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                // Add your login logic here

                Intent intent = new Intent(MainActivity.this, home.class);
                startActivity(intent);
            }
        });
        // Add OnClickListener for the signupButton
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the sign-up page
                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);
            }

        });
        // Find the backButton by its ID
        Button backButton = findViewById(R.id.backButton);

        // Set an OnClickListener for the backButton
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate back to the home page (MainActivity)
                Intent intent = new Intent(MainActivity.this, home.class);
                startActivity(intent);
                finish(); // Close the current activity
            }
        });
        // Add OnClickListener for the forgotPasswordTextView
        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the forgot password activity when the TextView is clicked
                Intent intent = new Intent(MainActivity.this, forgot_password.class);
                startActivity(intent);
            }
        });

    }
}
