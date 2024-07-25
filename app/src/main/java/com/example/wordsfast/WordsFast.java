package com.example.wordsfast;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
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

    private CardView LearnNewWordsCard, MixedModeCard, ReviewWordsCard;

    private ProgressBar ProgressBarWords;

    private TextView TextProgressWords;
    private SharedPreferences sharedPref;


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
                startActivity(new Intent(WordsFast.this, LearnNewWordsActivity.class));
            }
        });
        ReviewWordsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WordsFast.this, ReviewWordsActivity.class));
            }
        });

        MixedModeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WordsFast.this, MixedModeActivity.class));
            }
        });
    }

    private void init() {
        LearnNewWordsCard = findViewById(R.id.LearnNewWordsCard);
        ReviewWordsCard = findViewById(R.id.ReviewWordsCard);
        MixedModeCard = findViewById(R.id.MixedModeCard);

        TextProgressWords = findViewById(R.id.progressText);

        ProgressBarWords = findViewById(R.id.progressBar);

        sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        int IndexWord = sharedPref.getInt("myNumber", 0);
        ProgressBarWords.setProgress(IndexWord);
        TextProgressWords.setText(IndexWord + "/575");
        setProgressBarWords(0, IndexWord);
    }


    private void setProgressBarWords(int ValueZero, int FullValue) {
        ObjectAnimator animation = ObjectAnimator.ofInt(ProgressBarWords, "progress", ValueZero, FullValue);
        animation.setDuration(1000);
        animation.start();
    }

}