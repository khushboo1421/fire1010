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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    private EditText useremail,userpswd,username,userno;
    private Button signup;
    private FirebaseAuth firebaseAuth;
    String mobile,name,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        useremail=(EditText)findViewById(R.id.emailsignup);
        userpswd=(EditText)findViewById(R.id.pswdsignup);
        username=(EditText)findViewById(R.id.namesignup);
        userno=(EditText)findViewById(R.id.nosignup);
        signup=(Button)findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_email= useremail.getText().toString();
                String user_pswd=userpswd.getText().toString();

                firebaseAuth=FirebaseAuth.getInstance();

                firebaseAuth.createUserWithEmailAndPassword(user_email,user_pswd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            senduserdata();
                            Toast.makeText(signup.this, "registered successfully", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(signup.this,MainActivity.class));
                        }
                        else
                        {
                            Toast.makeText(signup.this, "registered unsuccessfully", Toast.LENGTH_SHORT).show();
                             finish();



                        }

                    }
                });



            }


        });
    }
private void senduserdata()
    {
        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();

        DatabaseReference databaseReference=firebaseDatabase.getReference(firebaseAuth.getUid());

        UserProfile userProfile=  new UserProfile(mobile,name,email);

        databaseReference.setValue(userProfile);


    }



}
