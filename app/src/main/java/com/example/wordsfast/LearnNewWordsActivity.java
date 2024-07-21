package com.example.wordsfast;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LearnNewWordsActivity extends AppCompatActivity {

    private RelativeLayout WordLayout_five, WordLayout_four, WordLayout_three, WordLayout_two, WordLayout_one;
    private Button NextButton_five, NextButton_four, NextButton_three, NextButton_two, NextButton_one;
    private Animation AnimationLeft;

    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_learn_new_words);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

        NextButton_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WordLayout_five.startAnimation(AnimationLeft);
                constraintLayout.removeView(WordLayout_five);
            }
        });
        NextButton_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WordLayout_four.startAnimation(AnimationLeft);
                constraintLayout.removeView(WordLayout_four);
            }
        });
        NextButton_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WordLayout_three.startAnimation(AnimationLeft);
                constraintLayout.removeView(WordLayout_three);
            }
        });
        NextButton_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WordLayout_two.startAnimation(AnimationLeft);
                constraintLayout.removeView(WordLayout_two);
            }
        });
        NextButton_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WordLayout_one.startAnimation(AnimationLeft);
                constraintLayout.removeView(WordLayout_one);
            }
        });
    }


    private void init() {
        WordLayout_five = findViewById(R.id.WordLayout_five);
        WordLayout_four = findViewById(R.id.WordLayout_four);
        WordLayout_three = findViewById(R.id.WordLayout_three);
        WordLayout_two = findViewById(R.id.WordLayout_two);
        WordLayout_one = findViewById(R.id.WordLayout_one);

        NextButton_five = findViewById(R.id.NextButton_five);
        NextButton_four = findViewById(R.id.NextButton_four);
        NextButton_three = findViewById(R.id.NextButton_three);
        NextButton_two = findViewById(R.id.NextButton_two);
        NextButton_one = findViewById(R.id.NextButton_one);

        constraintLayout = findViewById(R.id.main);

        AnimationLeft = AnimationUtils.loadAnimation(this, R.anim.left_anim_layout);
    }
}