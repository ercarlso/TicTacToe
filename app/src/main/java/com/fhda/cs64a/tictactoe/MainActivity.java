package com.fhda.cs64a.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnStartGame (View view) {
        Intent newIntent = new Intent (this, GameBoard.class);
        startActivity(newIntent);
    }

    public void OnViewHighScores (View view) {
        Intent viewScores = new Intent (this, HiScoresActivity.class);
        startActivity(viewScores);
    }
}
