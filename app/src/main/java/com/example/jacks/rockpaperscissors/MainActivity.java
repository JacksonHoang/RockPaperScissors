package com.example.jacks.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void info(View view){
        Intent intent1 = new Intent(this, InfoActivity.class);
        startActivity(intent1);
    }
    public void play(View view){
        Intent intent2 = new Intent(this, PlayActivity.class);
        startActivity(intent2);
    }
}
