package com.fhda.cs64a.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
public class MainActivity extends AppCompatActivity {

    private Button btnShufflePlayers;
    private Button btnStartGame;
    private Button btnSeeHighScore;
    private Button btnReadRules;
    private Button btnExit;
    private CheckBox chkboxPlayWithPC;
    private TextView player1Letter;
    private TextView player2Letter;
    private TextView player1;
    private TextView player2;
    private EditText etFirstPlayerName;
    private EditText etSecondPlayerName;
    private boolean playerOnePlaysX = true;
    private boolean playWithComputer = false;
    private String playerOneName = "";
    private String PlayerTwoName = "";
    private String tempName = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShufflePlayers = (Button) findViewById(R.id.btnShuffle);
        btnStartGame = (Button) findViewById(R.id.btnStart);
        btnSeeHighScore = (Button) findViewById(R.id.btnHighScore);
        btnReadRules = (Button) findViewById(R.id.btnReadRules);
        btnExit = (Button) findViewById(R.id.btnQuit);
        chkboxPlayWithPC = (CheckBox) findViewById(R.id.chkboxPlayWithPC);
        player1Letter = (TextView) findViewById(R.id.player1Letter);
        player2Letter = (TextView) findViewById(R.id.player2Letter);
        player1 = (TextView) findViewById(R.id.tvPlayer1);
        player2 = (TextView) findViewById(R.id.tvPlayer2);
        etFirstPlayerName = (EditText) findViewById(R.id.etFirstPlayerName);
        etSecondPlayerName = (EditText) findViewById(R.id.etSecondPlayerName);

        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(player1Letter.getText().toString().equals("X")){
                   player1Letter.setText("O");
                   player2Letter.setText("X");
                   playerOnePlaysX = false;
               }
               else{
                   player1Letter.setText("X");
                   player2Letter.setText("O");
                   playerOnePlaysX = true;
               }
            }
        });

        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(player1Letter.getText().toString().equals("X")){
                    player1Letter.setText("O");
                    player2Letter.setText("X");
                    playerOnePlaysX = false;
                }
                else{
                    player1Letter.setText("X");
                    player2Letter.setText("O");
                    playerOnePlaysX = true;
                }
            }
        });

        chkboxPlayWithPC.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                final boolean isChecked = chkboxPlayWithPC.isChecked();
                if (isChecked){
                    playWithComputer = true;
                    tempName =  etSecondPlayerName.getText().toString();
                    etSecondPlayerName.setText("Computer");
                    etSecondPlayerName.setEnabled(false);

                }else{
                    playWithComputer = false;

                    if(etFirstPlayerName.getText().toString().equalsIgnoreCase("Computer")){
                        etFirstPlayerName.setEnabled(true);
                        etFirstPlayerName.setText(tempName);
                    }
                    else {
                        etSecondPlayerName.setEnabled(true);
                        etSecondPlayerName.setText(tempName);
                    }
                }

            }
        });

        btnShufflePlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempplayer1 = etFirstPlayerName.getText().toString();
                String tempplayer2 = etSecondPlayerName.getText().toString();

                Random rand = new Random();
                int x = rand.nextInt(101);

                if (x<=25){
                    player1Letter.setText("X");
                    player2Letter.setText("O");
                    playerOnePlaysX = true;

                }
                else if (x >25 && x <=50){
                    player1Letter.setText("O");
                    player2Letter.setText("X");
                    playerOnePlaysX = false;

                }
                else if (x >50 && x <=75){
                    etFirstPlayerName.setEnabled(true);
                    etSecondPlayerName.setEnabled(true);
                    etFirstPlayerName.setText(tempplayer2);
                    etSecondPlayerName.setText(tempplayer1);
                    player1Letter.setText("X");
                    player2Letter.setText("O");
                    playerOnePlaysX = true;

                    if(tempplayer2.equalsIgnoreCase("Computer")){
                        etFirstPlayerName.setEnabled(false);
                    }
                    else if(tempplayer1.equalsIgnoreCase("Computer")){
                        etSecondPlayerName.setEnabled(false);
                    }

                }
                else{
                    etFirstPlayerName.setEnabled(true);
                    etSecondPlayerName.setEnabled(true);
                    etFirstPlayerName.setText(tempplayer2);
                    etSecondPlayerName.setText(tempplayer1);
                    player1Letter.setText("O");
                    player2Letter.setText("X");
                    playerOnePlaysX = false;
                    if(tempplayer2.equalsIgnoreCase("Computer")){
                        etFirstPlayerName.setEnabled(false);
                    }
                    else if(tempplayer1.equalsIgnoreCase("Computer")){
                        etSecondPlayerName.setEnabled(false);
                    }
                }
            }
        });

        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String player1 = etFirstPlayerName.getText().toString();
                String player2 = etSecondPlayerName.getText().toString();
                if (player1.isEmpty() || player2.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Please, specify both players' names!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (player1.equalsIgnoreCase("Computer") && player2.equalsIgnoreCase("Computer")){
                    Toast.makeText(getApplicationContext(),"Sorry, but name Computer is reserved for computer!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(getApplicationContext(), GameBoard.class);

                i.putExtra("player1",player1);
                i.putExtra("player2",player2);
                i.putExtra("playerOnePlaysX",playerOnePlaysX);
                i.putExtra("computerPlays",playWithComputer);

                startActivity(i);

            }
        });


        btnSeeHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent (MainActivity.this, HiScoresActivity.class);
                startActivity(newIntent);
            }
        });

        btnReadRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent (MainActivity.this, GameRulesActivity.class);
                startActivity(newIntent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
