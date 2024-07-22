package com.example.wordsfast;

import android.widget.ImageView;
import android.widget.TextView;

public class SetData {
    private TextView EngWordText, TranscriptionWordText, UkWordText;
    private ImageView Image;

    public SetData(TextView EngWordText, TextView TranscriptionWordText, TextView UkWordText, ImageView Image) {
        this.EngWordText = EngWordText;
        this.TranscriptionWordText = TranscriptionWordText;
        this.UkWordText = UkWordText;
        this.Image = Image;
    }

    public void setAllData(String EngWordText , String TranscriptionWordText ,String UkWordText , int IdImage){
        setEngWord(EngWordText);
        setTranscription(TranscriptionWordText);
        setUkWord(UkWordText);
        setImage(IdImage);
    }


    public void setEngWord(String text) {
        EngWordText.setText(text);
    }

    public void setTranscription(String text) {
        TranscriptionWordText.setText(text);
    }

    public void setUkWord(String text) {
        UkWordText.setText(text);
    }

    public void setImage(int resourceId) {
        Image.setImageResource(resourceId);
    }
}
