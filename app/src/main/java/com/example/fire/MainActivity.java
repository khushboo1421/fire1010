package com.example.fire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private EditText email,password;
    private FirebaseAuth firebaseAuth;
    private TextView reg,fremail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=(Button)findViewById(R.id.login);
        reg=(TextView)findViewById(R.id.reg);
        fremail=(TextView)findViewById(R.id.fr);

        email=(EditText) findViewById(R.id.email);
        password=(EditText)findViewById(R.id.pswd);

        firebaseAuth= FirebaseAuth.getInstance();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validate(email.getText().toString(),password.getText().toString());

            }



        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,signup.class));


            }
        });
        fremail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,forgot.class));

            }
        });
    }

    private void validate(String userName,String UserPassword)
    {
        firebaseAuth.signInWithEmailAndPassword(userName,UserPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this,"successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,login.class));

                }
                else
                {
                    Toast.makeText(MainActivity.this,"unsuccessful",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}


