package com.example.wordsfast;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MixedModeActivity extends AppCompatActivity {


    private DataBaseHelper dataBaseHelper;

    private SharedPreferences sharedPref;

    private TextView EngWordText, TranscriptionWordText, UkWordText;
    private ImageView ImageWord;
    private Button NextButton;
    private CardView WordCardView;

    private Button AnswerOptionOneButton, AnswerOptionTwoButton, AnswerOptionThreeButton;
    private TextView WordTestTextView;

    private SetData SetDataActivity;

    private ConstraintLayout constraintLayout;

    private int IndexWord = 0;
    private boolean isButton = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mixed_mode);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    private void init() {
        constraintLayout = findViewById(R.id.main);
        sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        IndexWord = sharedPref.getInt("myNumber", 0);
        dataBaseHelper = new DataBaseHelper(this);


        AddCardTestWord();
        AddCardNewWord();
    }


    private void AddCardNewWord() {

        for (int Index = -10; Index < 5; Index++) {
            if (IndexWord > 10 && Index == -10) {
                IndexWord -= 10;
            } else {
                IndexWord++;
            }

            //add
            View CardWord = LayoutInflater.from(this).inflate(R.layout.card_word_item, constraintLayout, false);
            constraintLayout.addView(CardWord);
            //find
            EngWordText = CardWord.findViewById(R.id.EngWordText);
            TranscriptionWordText = CardWord.findViewById(R.id.TranscriptionWordText);
            UkWordText = CardWord.findViewById(R.id.UkWordText);
            ImageWord = CardWord.findViewById(R.id.WordImage);
            NextButton = CardWord.findViewById(R.id.NextButton);

            //set data
            setDataOneCard(EngWordText, TranscriptionWordText, UkWordText, ImageWord, IndexWord);

            NextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Animation AnimationLeft = AnimationUtils.loadAnimation(MixedModeActivity.this, R.anim.left_anim_layout);
                    WordCardView = CardWord.findViewById(R.id.WordLayoutCard);
                    CardView ColorCardReplase = WordCardView.findViewById(R.id.CardColorReplese);
                    int color = ContextCompat.getColor(MixedModeActivity.this, R.color.CardAnimDark);

                    ColorCardReplase.setCardBackgroundColor(color);
                    WordCardView.startAnimation(AnimationLeft);
                    constraintLayout.removeView(CardWord);
                    Log.d("fod", "index" + IndexWord);
                    //save
                    sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putInt("myNumber", IndexWord+1);
                    editor.apply();
                }
            });
        }
    }

    public void setDataOneCard(TextView EngWordText, TextView TranscriptionWordText, TextView UkWordText, ImageView Image, int IndexWord) {
        String[] WordDataBase = dataBaseHelper.getWordsDataBase(IndexWord);
        int drawableId = getResources().getIdentifier(WordDataBase[2], "drawable", getPackageName());
        SetDataActivity = new SetData(EngWordText, TranscriptionWordText, UkWordText, Image);
        SetDataActivity.setAllData(WordDataBase[0], WordDataBase[1], WordDataBase[3], drawableId);
    }

    private void AddCardTestWord() {
        for (int Index = 0; Index < 10; Index++) {
            if(Index == 0){
                isButton = true;
            }else{
                isButton = false;
            }
            IndexWord++;
            Random random = new Random();

            String[] WordDataBase = dataBaseHelper.getWordsDataBase(IndexWord);
            //add
            View CardWordTest = LayoutInflater.from(this).inflate(R.layout.test_card_words_item, constraintLayout, false);
            constraintLayout.addView(CardWordTest);


            AnswerOptionOneButton = CardWordTest.findViewById(R.id.AnswerOptionOneButton);
            AnswerOptionTwoButton = CardWordTest.findViewById(R.id.AnswerOptionTwoButton);
            AnswerOptionThreeButton = CardWordTest.findViewById(R.id.AnswerOptionThreeButton);
            WordTestTextView = CardWordTest.findViewById(R.id.WordTestTextView);

            int randomNumber = random.nextInt((10 - 1) + 1) + 1;

            String[] WordArray = GenerationQuestions(randomNumber, WordDataBase);

            setViewQuestions(WordArray, WordTestTextView, AnswerOptionOneButton, AnswerOptionTwoButton, AnswerOptionThreeButton, CardWordTest ,isButton);


        }
        IndexWord -= 10;
    }
    public static int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }


    public String[] GenerationQuestions(int NumberRandom, String[] WordArray) {
        String[] WordArrayReturn = new String[4];
        if (NumberRandom > 5) {
            WordArrayReturn[0] = WordArray[0];
            WordArrayReturn[1] = WordArray[3];
            WordArrayReturn[2] = getGenerationRandomWordUk();
            WordArrayReturn[3] = getGenerationRandomWordUk();
        } else {
            WordArrayReturn[0] = WordArray[3];
            WordArrayReturn[1] = WordArray[0];
            WordArrayReturn[2] = getGenerationRandomWordEng();
            WordArrayReturn[3] = getGenerationRandomWordEng();
        }
        return WordArrayReturn;
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    protected void setViewQuestions(String[] Array, TextView Text, Button ButtonOne, Button ButtonTwo, Button ButtonThree, View CardDel ,boolean IsButton) {
        Text.setText(Array[0]);
        int Num = getRandomNumberInRange(1, 3);
        if (Num == 1) {
            ButtonOne.setForeground(getResources().getDrawable(R.drawable.color_transition_green, null));
            ButtonOne.setText(Array[1]);
            ButtonOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //right
                    Animation AnimationLeft = AnimationUtils.loadAnimation(MixedModeActivity.this, R.anim.left_anim_layout);
                    CardDel.startAnimation(AnimationLeft);
                    constraintLayout.removeView(CardDel);
                    if(IsButton){
                        startActivity(new Intent(MixedModeActivity.this , WordsFast.class));
                        isButton = false;
                    }
                }
            });

            ButtonTwo.setForeground(getResources().getDrawable(R.drawable.color_transition_red, null));
            ButtonTwo.setText(Array[2]);

            ButtonTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Animation AnimationLeft = AnimationUtils.loadAnimation(MixedModeActivity.this, R.anim.left_anim_layout);
                    CardDel.startAnimation(AnimationLeft);
                    constraintLayout.removeView(CardDel);
                    if(IsButton){
                        startActivity(new Intent(MixedModeActivity.this , WordsFast.class));
                        isButton = false;
                    }
                }

            });

            ButtonThree.setForeground(getResources().getDrawable(R.drawable.color_transition_red, null));
            ButtonThree.setText(Array[3]);
            ButtonThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Animation AnimationLeft = AnimationUtils.loadAnimation(MixedModeActivity.this, R.anim.left_anim_layout);
                    CardDel.startAnimation(AnimationLeft);
                    constraintLayout.removeView(CardDel);
                    if(IsButton){
                        startActivity(new Intent(MixedModeActivity.this , WordsFast.class));
                        isButton = false;
                    }
                }
            });

        } else if (Num == 2) {
            ButtonOne.setForeground(getResources().getDrawable(R.drawable.color_transition_red, null));
            ButtonOne.setText(Array[2]);
            ButtonOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Animation AnimationLeft = AnimationUtils.loadAnimation(MixedModeActivity.this, R.anim.left_anim_layout);
                    CardDel.startAnimation(AnimationLeft);
                    constraintLayout.removeView(CardDel);
                    if(IsButton){
                        startActivity(new Intent(MixedModeActivity.this , WordsFast.class));
                        isButton = false;
                    }
                }
            });

            ButtonTwo.setForeground(getResources().getDrawable(R.drawable.color_transition_green, null));
            ButtonTwo.setText(Array[1]);
            ButtonTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //right
                    Animation AnimationLeft = AnimationUtils.loadAnimation(MixedModeActivity.this, R.anim.left_anim_layout);
                    CardDel.startAnimation(AnimationLeft);
                    constraintLayout.removeView(CardDel);
                    if(IsButton){
                        startActivity(new Intent(MixedModeActivity.this , WordsFast.class));
                        isButton = false;
                    }
                }
            });

            ButtonThree.setForeground(getResources().getDrawable(R.drawable.color_transition_red, null));
            ButtonThree.setText(Array[3]);
            ButtonThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Animation AnimationLeft = AnimationUtils.loadAnimation(MixedModeActivity.this, R.anim.left_anim_layout);
                    CardDel.startAnimation(AnimationLeft);
                    constraintLayout.removeView(CardDel);
                    if(IsButton){
                        startActivity(new Intent(MixedModeActivity.this , WordsFast.class));
                        isButton = false;
                    }
                }
            });
        } else {
            ButtonOne.setForeground(getResources().getDrawable(R.drawable.color_transition_red, null));
            ButtonOne.setText(Array[3]);

            ButtonOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Animation AnimationLeft = AnimationUtils.loadAnimation(MixedModeActivity.this, R.anim.left_anim_layout);
                    CardDel.startAnimation(AnimationLeft);
                    constraintLayout.removeView(CardDel);
                    if(IsButton){
                        startActivity(new Intent(MixedModeActivity.this , WordsFast.class));
                        isButton = false;
                    }
                }
            });

            ButtonTwo.setForeground(getResources().getDrawable(R.drawable.color_transition_red, null));
            ButtonTwo.setText(Array[2]);

            ButtonTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Animation AnimationLeft = AnimationUtils.loadAnimation(MixedModeActivity.this, R.anim.left_anim_layout);
                    CardDel.startAnimation(AnimationLeft);
                    constraintLayout.removeView(CardDel);
                    if(IsButton){
                        startActivity(new Intent(MixedModeActivity.this , WordsFast.class));
                        isButton = false;
                    }
                }
            });

            ButtonThree.setForeground(getResources().getDrawable(R.drawable.color_transition_green, null));
            ButtonThree.setText(Array[1]);
            ButtonThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //right
                    Animation AnimationLeft = AnimationUtils.loadAnimation(MixedModeActivity.this, R.anim.left_anim_layout);
                    CardDel.startAnimation(AnimationLeft);
                    constraintLayout.removeView(CardDel);
                    if(IsButton){
                        startActivity(new Intent(MixedModeActivity.this , WordsFast.class));
                        isButton = false;
                    }
                }
            });
        }
    }

    protected String getGenerationRandomWordUk() {
        int randomNumber = getRandomNumberInRange(1, 570);
        String[] WordDataBase = dataBaseHelper.getWordsDataBase(randomNumber);
        return WordDataBase[3];
    }

    protected String getGenerationRandomWordEng() {
        int randomNumber = getRandomNumberInRange(1, 570);
        String[] WordDataBase = dataBaseHelper.getWordsDataBase(randomNumber);
        return WordDataBase[0];
    }


}