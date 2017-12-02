package com.example.user.klrahul;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Info extends AppCompatActivity {
    public Spinner spinner;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        button = (Button) findViewById(R.id.button1);
        spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.blood_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        final String name = getIntent().getStringExtra("name").toLowerCase();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String blood_type = spinner.getSelectedItem().toString();
                Intent in = new Intent(getApplicationContext(), Final_info.class);
                in.putExtra("name", name);
                in.putExtra("blood", blood_type);
                startActivity(in);
            }

    /*    tv1 = (TextView) findViewById(R.id.name);
        tv2 = (TextView) findViewById(R.id.textView3);
        String name = getIntent().getStringExtra("name").toLowerCase();
        tv1.setText(name);
        FirebaseDatabase.getInstance().getReference().child(name).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                tv2.setText(snapshot.getValue().toString());  //prints "Do you have data? You'll love Firebase."
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });*/

        });
    }
}