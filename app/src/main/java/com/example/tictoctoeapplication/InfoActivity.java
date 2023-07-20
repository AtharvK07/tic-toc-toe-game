package com.example.tictoctoeapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    Button exitapp,donate,help,sendemail,sendmsg;
    EditText message;
    TextView gn,my;
    Switch darkmode;
    RelativeLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        exitapp=(Button)findViewById(R.id.exit);

        sendemail=(Button)findViewById(R.id.email);
        sendemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in=new Intent(Intent.ACTION_SENDTO);
                in.setData(Uri.parse("mailto:atharvkshirsagar7@gmail.com"));
                startActivity(in);
            }
        });

        exitapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        cl=(RelativeLayout) findViewById(R.id.relt);
        gn=(TextView)findViewById(R.id.general);
        my=(TextView)findViewById(R.id.myname);

        darkmode=(Switch)findViewById(R.id.switch1);

        darkmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(darkmode.isChecked())
                {
                    cl.setBackgroundColor(Color.parseColor("#5C595B"));
                    gn.setTextColor(Color.WHITE);
                    my.setTextColor(Color.WHITE);
                }
                else
                {
                    cl.setBackgroundColor(Color.WHITE);
                    gn.setTextColor(Color.BLACK);
                    my.setTextColor(Color.BLACK);
                }
            }
        });



    }
}