package com.example.viikko_7_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {

    Context context = null;
    String fileName;
    EditText textInput;
    EditText fName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        fName = (EditText) findViewById(R.id.fName);
        textInput = (EditText) findViewById(R.id.textInput);


    }

    public void readFile(View v){
        try{
            fileName = fName.getText().toString();
            InputStream ins = context.openFileInput(fileName);

            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String s = "";
            StringBuilder sb = new StringBuilder();

            while ((s=br.readLine()) != null){
                sb.append(s + "\n");        //Luetaan rivit tiedostosta ja lisätään ne muuttujaan 'sb'
            }
            textInput.setText(sb);
            ins.close();
        }catch (IOException e){
            Log.e("IOException", "Virhe syötteessä");
        }finally{
            System.out.println("LUETTU");
        }



    }

    public void writeFile(View v){
        try{
            fileName = fName.getText().toString();
            OutputStreamWriter osw = new OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_PRIVATE));

            String s = textInput.getText().toString();
            osw.write(s);
            osw.close();
        }catch (IOException e){
            Log.e("IOException", "Virhe syötteessä");
        }finally{
            System.out.println("KIRJOITETTU");
        }
    }
}