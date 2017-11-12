package com.fhda.cs64a.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameBoard extends AppCompatActivity  {
    public String player1;
    public String player2;
    public boolean playerOnePlaysX;
    public boolean computerPlays;
    private String currentPlayer;

    private TextView txtMsgTop;
    private TextView txtMsgBottom;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private View.OnClickListener btnView;

    private void checkForWin(){

        if(currentPlayer.equalsIgnoreCase(player1)){
            currentPlayer = player2;
        }
        else{
            currentPlayer = player1;
        }

        if(!computerPlays && playerOnePlaysX && currentPlayer.equalsIgnoreCase(player1)){
            txtMsgTop.setText(player1+"'s turn (x)");
        }
        else if(!computerPlays && !playerOnePlaysX && currentPlayer.equalsIgnoreCase(player1)){
            txtMsgTop.setText(player1+"'s turn (o)");
        }
        else if(!computerPlays && playerOnePlaysX && currentPlayer.equalsIgnoreCase(player2)){
            txtMsgTop.setText(player2+"'s turn (o)");
        }
        else if(!computerPlays && !playerOnePlaysX && currentPlayer.equalsIgnoreCase(player2)){
            txtMsgTop.setText(player1+"'s turn (x)");
        }
        
        else if (computerPlays && playerOnePlaysX){
            txtMsgTop.setText("Computer's turn (x)");
            //TODO invoke computer play method
        }
        else if (computerPlays && playerOnePlaysX){
            txtMsgTop.setText("Computer's turn (o)");
            //TODO invoke computer play method
        }
        else {
            txtMsgTop.setText("Error occured, please, restart.");
        }

    };


//    @Override
//    public void onClick(View v) {
//        String s = " R.id." + Integer.toString(v.getId());
//        Button b = (Button)v;
//        String buttonText = b.getText().toString();
//        txtMsgTop.setText(buttonText);
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
        txtMsgTop = (TextView) findViewById(R.id.txtMsgTop);
        txtMsgBottom = (TextView) findViewById(R.id.txtMsgBottom);

        //This is data needed from welcome screen.
        player1 = "Steven";
        player2 = "Maya";
        playerOnePlaysX = true;
        computerPlays = false;
        //This is data needed from welcome screen.

        currentPlayer = player2;


        checkForWin(); //Run once in the begining

        btnView = new View.OnClickListener(){
            public void onClick(View v){

                Button b = (Button)v;
                String buttonText = b.getText().toString();
                if (!(buttonText.equalsIgnoreCase("x") || buttonText.equalsIgnoreCase("o"))){

                    if(currentPlayer.equalsIgnoreCase(player1) && playerOnePlaysX){
                        b.setText("X");
                    }
                    else if (currentPlayer.equalsIgnoreCase(player1) && !playerOnePlaysX){
                        b.setText("O");
                    }
                    else if (currentPlayer.equalsIgnoreCase(player2) && playerOnePlaysX){
                        b.setText("O");
                    }
                    else if (currentPlayer.equalsIgnoreCase(player2) && !playerOnePlaysX){
                        b.setText("X");
                    }
                    else{
                        txtMsgTop.setText("Error occured, please, restart.");
                    }

                    checkForWin();
                }

                else{
                    Toast.makeText(getApplicationContext(),"Please, select blank spot!", Toast.LENGTH_LONG).show();
                }

            }
        };
        btn1  = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(btnView);
        btn2  = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(btnView);
        btn3  = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(btnView);
        btn4  = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(btnView);
        btn5  = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(btnView);
        btn6  = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(btnView);
        btn7  = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(btnView);
        btn8  = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(btnView);
        btn9  = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(btnView);




}



    //Testing git push
    //Testing git update project -- erin
}
