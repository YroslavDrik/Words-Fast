package com.example.wordsfast;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LearnNewWordsActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    private CardView WordLayout_five, WordLayout_four, WordLayout_three, WordLayout_two, WordLayout_one;
    private Button NextButton_five, NextButton_four, NextButton_three, NextButton_two, NextButton_one;

    private TextView OneEngWordText, OneTranscriptionWordText, OneUkWordText;
    private TextView TwoEngWordText, TwoTranscriptionWordText, TwoUkWordText;
    private TextView ThreeEngWordText, ThreeTranscriptionWordText, ThreeUkWordText;
    private TextView FourEngWordText, FourTranscriptionWordText, FourUkWordText;
    private TextView FiveEngWordText, FiveTranscriptionWordText, FiveUkWordText;

    private ImageView OneWordImage,TwoWordImage,ThreeWordImage,FourWordImage,FiveWordImage ;

    private SetData SetDataActivity;

    private Animation AnimationLeft;
    private ConstraintLayout constraintLayout;

    private int IndexWord;

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

        OneEngWordText = findViewById(R.id.OneEngWordText);
        OneUkWordText = findViewById(R.id.OneUkWordText);
        OneTranscriptionWordText = findViewById(R.id.OneTranscriptionWordText);
        OneWordImage = findViewById(R.id.OneWordImage);

        TwoEngWordText = findViewById(R.id.TwoEngWordText);
        TwoUkWordText = findViewById(R.id.TwoUkWordText);
        TwoTranscriptionWordText = findViewById(R.id.TwoTranscriptionWordText);
        TwoWordImage = findViewById(R.id.TwoWordImage);

        ThreeEngWordText = findViewById(R.id.ThreeEngWordText);
        ThreeUkWordText = findViewById(R.id.ThreeUkWordText);
        ThreeTranscriptionWordText = findViewById(R.id.ThreeTranscriptionWordText);
        ThreeWordImage = findViewById(R.id.ThreeWordImage);

        FourEngWordText = findViewById(R.id.FourEngWordText);
        FourUkWordText = findViewById(R.id.FourUkWordText);
        FourTranscriptionWordText = findViewById(R.id.FourTranscriptionWordText);
        FourWordImage = findViewById(R.id.FourWordImage);

        FiveEngWordText = findViewById(R.id.FiveEngWordText);
        FiveUkWordText = findViewById(R.id.FiveUkWordText);
        FiveTranscriptionWordText = findViewById(R.id.FiveTranscriptionWordText);
        FiveWordImage = findViewById(R.id.FiveWordImage);

        AnimationLeft = AnimationUtils.loadAnimation(this, R.anim.left_anim_layout);

        IndexWord = 1;

        //set data
        setDataOneCard(OneEngWordText , OneTranscriptionWordText , OneUkWordText,OneWordImage , IndexWord);
        setDataOneCard(TwoEngWordText,TwoTranscriptionWordText,TwoUkWordText,TwoWordImage , IndexWord+1);
        setDataOneCard(ThreeEngWordText,ThreeTranscriptionWordText,ThreeUkWordText,ThreeWordImage,IndexWord+2);
        setDataOneCard(FourEngWordText , FourTranscriptionWordText,FourUkWordText,FourWordImage,IndexWord+3);
        setDataOneCard(FiveEngWordText , FiveTranscriptionWordText , FiveUkWordText,FiveWordImage,IndexWord+4);;
    }

    public void setDataOneCard(TextView EngWordText, TextView TranscriptionWordText, TextView UkWordText, ImageView Image ,int IndexWord) {
        dataBaseHelper = new DataBaseHelper(this);
        String[] WordDataBase = dataBaseHelper.getWordsDataBase(IndexWord);
        int drawableId = getResources().getIdentifier(WordDataBase[2], "drawable", getPackageName());
        SetDataActivity = new SetData(EngWordText, TranscriptionWordText, UkWordText, Image);
        SetDataActivity.setAllData(WordDataBase[0], WordDataBase[1], WordDataBase[3], drawableId);
    }
}