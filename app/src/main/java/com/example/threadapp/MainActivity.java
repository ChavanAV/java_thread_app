package com.example.threadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv2;
    EditText ed;
    Button b1,b2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button) findViewById(R.id.b);
        b2=(Button) findViewById(R.id.button);
        ed=(EditText) findViewById(R.id.editTextTextPersonName);
        tv2=(TextView) findViewById(R.id.textView2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thr();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv2.setText("");
                ed.setText("");
            }
        });
    }

    private void thr() {
        String s=ed.getText().toString();
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv2.setText(s);
                    }
                }
                );
            }
        },3000);
    }
}