package com.example.rabinhowlader.myfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button enterButton;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Button moveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name =(EditText) findViewById(R.id.name);
        enterButton =(Button) findViewById(R.id.enterButton);
        moveBtn =(Button)findViewById(R.id.moveBtn);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReferenceFromUrl("https://myfirebase-79bae.firebaseio.com/");

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference mChild = databaseReference.push();
                mChild.child("name").setValue(name.getText().toString().trim());
            }
        });

        moveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ReadData.class));
            }
        });

    }
}
