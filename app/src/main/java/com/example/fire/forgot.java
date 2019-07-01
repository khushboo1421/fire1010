package com.example.fire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgot extends AppCompatActivity {
    private EditText fgemail;
    private Button resetpswd;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        fgemail=(EditText)findViewById(R.id.frgt);
        resetpswd=(Button)findViewById(R.id.reset);

        firebaseAuth=FirebaseAuth.getInstance();



        resetpswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String useremail=fgemail.getText().toString();
                firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(forgot.this, "password reset email sent", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(forgot.this,MainActivity.class));
                        }
                        else
                        {
                            Toast.makeText(forgot.this, "email not registered", Toast.LENGTH_SHORT).show();
                        finish();
                        }
                    }
                });


            }
        });

    }
}
