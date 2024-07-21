package com.example.wordsfast;

import android.animation.ObjectAnimator;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WordsFast extends AppCompatActivity {

    private CardView LearnNewWordsCard , MixedModeCard , ReviewWordsCard;

    private ProgressBar ProgressBarWords;

    private TextView TextAddWords;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_words_fast);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

    LearnNewWordsCard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(WordsFast.this , LearnNewWordsActivity.class));
        }
    });
    ReviewWordsCard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(WordsFast.this , ReviewWordsActivity.class));
        }
    });

    MixedModeCard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(WordsFast.this , MixedModeActivity.class));
        }
    });
    }
    private void init(){
        LearnNewWordsCard = findViewById(R.id.LearnNewWordsCard);
        ReviewWordsCard = findViewById(R.id.ReviewWordsCard);
        MixedModeCard = findViewById(R.id.MixedModeCard);


        TextAddWords = findViewById(R.id.TextAddWords);

        ProgressBarWords = findViewById(R.id.progressBar);
        setProgressBarWords(0 , 65);


            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);




    }


    private void setProgressBarWords(int ValueZero ,int FullValue ){
        ObjectAnimator animation = ObjectAnimator.ofInt(ProgressBarWords, "progress", ValueZero, FullValue);
        animation.setDuration(1000);
        animation.start();
    }

}