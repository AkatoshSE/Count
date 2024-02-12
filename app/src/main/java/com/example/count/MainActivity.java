package com.example.count;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    private TextView score1;
    private  TextView score2;
    private Button team1, team2;
    private int count1 = 0, count2 = 0;
    SharedPreferences prefs;
    @SuppressLint("MissingInflatedId")//gggggggggggggg
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);
        team1 = findViewById(R.id.team1);
        team2 = findViewById(R.id.team2);
        team1.setOnClickListener(listener);
        team2.setOnClickListener(listener);
    }
    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences prefs = this.getSharedPreferences(
                "com.example.app", Context.MODE_PRIVATE);
        count1=Integer.parseInt(prefs.getString("1","0"));
        count2=Integer.parseInt(prefs.getString("2","0"));
        score1.setText(String.valueOf(count1));
        score2.setText(String.valueOf(count2));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences prefs = this.getSharedPreferences(
                "com.example.app", Context.MODE_PRIVATE);
        prefs.edit().putString("1", score1.getText().toString()).apply();;
        prefs.edit().putString("2", score2.getText().toString()).apply();
    }

    private View.OnClickListener listener = new View.OnClickListener() {
@Override
        public  void onClick(View view) {
    switch (view.getId()) {
        case R.id.team1:
        count1 ++;
        break;
        case R.id.team2:
            count2 ++;
            break;
    }
    score1.setText(String.format("%02d", count1));
    score2.setText(String.format("%02d", count2));
}
    };
}