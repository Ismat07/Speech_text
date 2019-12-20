package com.example.ismatkhanam.speech_text;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Locale;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.speech.tts.TextToSpeech;

public class MainActivity extends AppCompatActivity {

    TextToSpeech t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS)
                {
                    t.setLanguage(Locale.US);
                }
            }
        });
        final EditText e=(EditText)findViewById(R.id.editText1);
        Button b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                t.speak(e.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

}
