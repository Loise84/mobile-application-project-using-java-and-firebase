package com.example.ifoodmarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button create;
    private EditText InputName, InputPassword, ConfirmPassword, EmailID;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate back to the login page (MainActivity)
                Intent intent = new Intent(signup.this, MainActivity.class);
                startActivity(intent);

            }
        });

        // Initialize your views here
        create = findViewById(R.id.reg_btn);
        InputName = findViewById(R.id.editText);
        InputPassword = findViewById(R.id.password_reg);
        ConfirmPassword = findViewById(R.id.editText2);
        EmailID = findViewById(R.id.email);
        System.out.println("hello");

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String username = InputName.getText().toString().trim();
                String pwd = InputPassword.getText().toString().trim();
                String mail = EmailID.getText().toString().trim();
                String repwd = ConfirmPassword.getText().toString().trim();

                // Validation methods
                ValidateName();
                ValidateEmail();
                ValidatePwd();
                mAuth.createUserWithEmailAndPassword(mail, repwd)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(signup.this, "Account created.",
                                            Toast.LENGTH_SHORT).show();
                                    // Add your login logic here
                                    Intent intent = new Intent(signup.this, MainActivity.class);
                                    startActivity(intent);


                                } else {
                                    // If sign in fails, display a message to the user
                                    Toast.makeText(signup.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

            private void ValidateName() {
                String name = InputName.getText().toString();
                if (name.isEmpty()) {
                    InputName.setError("Please enter your Username!");
                }
            }

            private void ValidateEmail() {
                String mail = EmailID.getText().toString();
                String regex = "^(.+)@(.+)$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(mail);

                if (mail.isEmpty()) {
                    EmailID.setError("Please enter your email ID");
                } else if (!matcher.matches()) {
                    EmailID.setError("Please enter a valid email ID");
                }
            }

            private void ValidatePwd() {
                String password = InputPassword.getText().toString();
                String repass = ConfirmPassword.getText().toString();

                if (password.isEmpty()) {
                    InputPassword.setError("Please enter your Password!");
                } else if (!password.equals(repass)) {
                    ConfirmPassword.setError("Passwords do not match!");
                }




            }
        });
    }
}
