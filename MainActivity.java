package com.example.viikko_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textOutput;
    String text;

    EditText textInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textOutput = (TextView) findViewById(R.id.textView);
        textInput = (EditText) findViewById(R.id.textInput);

        //this.printWorld();
        textInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //Tämä kopioi tekstin syöttökentästä TextView kenttään aina kun kenttään tehdään muutoksia
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text = textInput.getText().toString();
                textOutput.setText(text);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void printWorld(View v){
        System.out.println("Hello World!");
        //text = textInput.getText().toString();
        //textOutput.setText(text);
    }
}