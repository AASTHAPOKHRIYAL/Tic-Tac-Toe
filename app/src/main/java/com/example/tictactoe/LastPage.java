package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LastPage extends AppCompatActivity {
    TextView textView3;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_page);
        textView3=findViewById(R.id.textView3);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);

        Intent intent=getIntent();
        String winner=intent.getStringExtra("FINAL_WINNER");
        textView3.setText(winner);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(returnIntent);
            }
        });

    }
}