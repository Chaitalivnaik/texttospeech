package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {
    Button speak;
    TextView edtxt;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtxt=(EditText)findViewById(R.id.btnedt);
        speak=(Button) findViewById(R.id.btnspch);
        speak.setOnClickListener(this);
        textToSpeech=new TextToSpeech(getBaseContext(),this);
        textToSpeech.setLanguage(Locale.ENGLISH);
    }

    @Override
    public void onClick(View view) {
        String text=edtxt.getText().toString();
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
    }

    @Override
    public void onInit(int i) {
        if(i!=TextToSpeech.ERROR){
            Toast.makeText(getBaseContext(),"success",Toast.LENGTH_LONG).show();
        }

    }
}