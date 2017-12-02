package com.example.user.klrahul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    Button aboutus;
    Button login;
    Button signup;
    EditText username,password;
    DatabaseReference child;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final ImageView image = (ImageView) findViewById(R.id.image_logo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim);
        image.startAnimation(animation);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.submit_button);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        signup = (Button) findViewById(R.id.user_button);
        aboutus = (Button) findViewById(R.id.button4);
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),About.class);
                startActivity(in);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),Refistration.class);
                startActivity(in);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String us = username.getText().toString();
                final String passw = password.getText().toString();
                if(us.equals("Divya")&&passw.equals("123"))
                {
                    Intent in = new Intent(getApplicationContext(), MainActivity.class);
                    in.putExtra("username", us);
                    in.putExtra("password", passw);
                    startActivity(in);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please fill the required fields..." , Toast.LENGTH_LONG).show();
                    Intent in = new Intent(getApplicationContext(), Login.class);
                    startActivity(in);
                }
                /*if(us.isEmpty()||passw.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please fill the required fields..." , Toast.LENGTH_LONG).show();
                    Intent in = new Intent(getApplicationContext(), Login.class);
                    startActivity(in);
                }
                final String[] pass = new String[1];
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(us))
                        {
                            myRef.child(us).child("password").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    pass[0] = (String) dataSnapshot.getValue();
                                    if(pass[0].equals(passw)) {
                                        Intent in = new Intent(getApplicationContext(), MainActivity.class);
                                        in.putExtra("username", us);
                                        in.putExtra("password", pass[0]);
                                        startActivity(in);
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),"Wrong Credentials..... Check Again..." , Toast.LENGTH_LONG).show();
                                    }
                                }
                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                }
                            });
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"No account exist with this Username. Please Sign Up to continue" , Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });*/
            }
        });
    }
}
