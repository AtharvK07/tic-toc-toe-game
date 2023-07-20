package com.example.tictoctoeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class TwoNameActivity extends AppCompatActivity {

    EditText player1,player2;
    ImageView back;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_name);

        player1 = findViewById(R.id.playerone1);
        player2 = findViewById(R.id.playerone2);
        next = findViewById(R.id.continue1);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TwoNameActivity.this,MainActivity.class));
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(player1.getText()))
                {
                    player1.setError("Please Enter Player 1");
                    player1.requestFocus();
                }
                else if (TextUtils.isEmpty(player2.getText()))
                {
                    player2.setError("Please Enter Player 2");
                    player2.requestFocus();
                }
                else {

                    Intent i = new Intent(TwoNameActivity.this, HomeActivity.class);
                    String p1 = player1.getText().toString();
                    String p2 = player2.getText().toString();

                    i.putExtra("Player", p1);
                    i.putExtra("Player2", p2);

                    startActivity(i);
                }
            }
        });

    }
}