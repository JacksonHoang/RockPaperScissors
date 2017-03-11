package com.example.jacks.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;
import java.util.Random;


public class PlayActivity extends AppCompatActivity {

    ImageView imgViewYou, imgViewOpp;
    ImageButton ratButton, catButton, elephantButton;
    TextView resultTV, countTV, scoreYou, scoreOpp;
    Random r;
    int cnt = 0;
    int npc = 1;
    int you = 1;
    int rand;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        r = new Random();

        imgViewYou = (ImageView) findViewById(R.id.imageViewYou);
        imgViewOpp = (ImageView) findViewById(R.id.imageViewOpp);
        ratButton = (ImageButton) findViewById(R.id.imageButtonRat);
        catButton = (ImageButton) findViewById(R.id.imageButtonCat);
        elephantButton = (ImageButton) findViewById(R.id.imageButtonElephant);
        countTV  = (TextView) findViewById(R.id.countTV);
        resultTV = (TextView) findViewById(R.id.resultTV);
        scoreYou = (TextView) findViewById(R.id.scoreYou);
        scoreOpp = (TextView) findViewById(R.id.scoreOpp);
        addListenerOnButton();
    }

    public int randey(){
        rand = (int)(Math.random()*0+1);
        return rand;
    }

    public void onClicks(View imgViewYou){
        int ran = (int)(Math.random()*3);
        cnt++;

        switch(ran){
            case 0:
                imgViewOpp.setImageResource(R.drawable.rat);
                switch (imgViewYou.getId()) {
                    case R.id.imageButtonRat:
                        resultTV.setText("Tie!!!");
                        countTV.setText("Round: " + cnt);
                        break;
                    case R.id.imageButtonCat:
                        resultTV.setText("You Lose!!!");
                        countTV.setText("Round: " + cnt);
                        scoreOpp.setText("NPC: " + npc++);
                        break;
                    case R.id.imageButtonElephant:
                        resultTV.setText("You Win!!!");
                        countTV.setText("Round: " + cnt);
                        scoreYou.setText("You: " + you++);
                        break;
                }
                break;
            case 1:
                imgViewOpp.setImageResource(R.drawable.cat);
                switch (imgViewYou.getId()) {
                    case R.id.imageButtonRat:
                        resultTV.setText("You lose!!!");
                        countTV.setText("Round: " + cnt);
                        scoreOpp.setText("NPC: " + npc++);
                        break;
                    case R.id.imageButtonCat:
                        resultTV.setText("Tie!!!");
                        countTV.setText("Round: " + cnt);
                        break;
                    case R.id.imageButtonElephant:
                        resultTV.setText("You win!!!");
                        countTV.setText("Round: " + cnt);
                        scoreYou.setText("You: " + you++);
                        break;
                }
                break;
            case 2:
                imgViewOpp.setImageResource(R.drawable.elephant);
                switch (imgViewYou.getId()) {
                    case R.id.imageButtonRat:
                        resultTV.setText("You Win!!!");
                        countTV.setText("Round: " + cnt);
                        scoreYou.setText("You: " + you++);
                        break;
                    case R.id.imageButtonCat:
                        resultTV.setText("You Lose!!!");
                        countTV.setText("Round: " + cnt);
                        scoreOpp.setText("NPC: " + npc++);
                        break;
                    case R.id.imageButtonElephant:
                        resultTV.setText("Tie!!!");
                        countTV.setText("Round: " + cnt);
                        break;
                }
                break;
        }
    }

    public void addListenerOnButton() {
        ratButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(PlayActivity.this,
                        "Hisss!", Toast.LENGTH_SHORT).show();
                imgViewYou.setImageResource(R.drawable.rat);
                onClicks(ratButton);
            }
        });
        catButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(PlayActivity.this,
                        "Meow!", Toast.LENGTH_SHORT).show();
                imgViewYou.setImageResource(R.drawable.cat);
                onClicks(catButton);
            }
        });
        elephantButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(PlayActivity.this,
                        "Phooo!", Toast.LENGTH_SHORT).show();
                imgViewYou.setImageResource(R.drawable.elephant);
                onClicks(elephantButton);
            }
        });
    }

    public void main(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
