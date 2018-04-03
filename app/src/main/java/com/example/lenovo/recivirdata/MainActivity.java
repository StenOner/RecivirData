package com.example.lenovo.recivirdata;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null){
            if ("text/plain".equals(type)){
                manipularTexto(intent);
            }
        }
    }
    public void manipularTexto(Intent intent){
        ArrayList<String> sharedText = intent.getStringArrayListExtra((intent.EXTRA_STREAM));
        String pedido = "Pedido: \n";
        for (String arrays : sharedText){
            pedido += arrays;
        }
        if (sharedText != null){
            LinearLayout linearLayout = (LinearLayout)findViewById(R.id.main_layout);
            TextView textView = new TextView(this);
            textView.setText(pedido);
            textView.setTextSize(20);
            textView.setTextColor(Color.parseColor("Black"));
            linearLayout.addView(textView);
            Toast.makeText(MainActivity.this,pedido,Toast.LENGTH_LONG).show();
        }
    }
}
