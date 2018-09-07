package com.example.jesus_pc.partialexam;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Exam extends AppCompatActivity {

    Random myRandom = new Random();

    private Button rock;
    private Button paper;
    private Button scissor;
    private Button reset;
    private TextView score;
    private TextView option;
    private TextView winner;

    private String strScore;
    int player1 = 0;
    int player2 = 0;
    int rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        rock = findViewById(R.id.button);
        paper = findViewById(R.id.button2);
        scissor = findViewById(R.id.button3);
        reset = findViewById(R.id.button4);
        score = findViewById(R.id.textView);
        option = findViewById(R.id.textView3);
        winner = findViewById(R.id.textView4);


        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               rand = myRandom.nextInt(3);

               if(rand == 1){
                   player2++;

                   Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                   long pattern[] = {0, 800, 100};
                   vib.vibrate(pattern, 2);

                   winner.setText("You lose");
                   option.setText("Player 2 chose: Paper");
                   Toast.makeText(Exam.this, "Player 2 Wins", Toast.LENGTH_SHORT).show();
               } else if(rand == 2){
                   player1++;
                   winner.setText("You win");
                   option.setText("Player 2 chose: Scissors");
                   Toast.makeText(Exam.this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
               } else {
                   winner.setText("It's a Tie");
                   option.setText("Player 2 chose: Rock");
               }

                strScore = "Player1  " + player1 + " - " + player2 + "  Player2";
                score.setText(strScore);

            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rand = myRandom.nextInt(3);

                if(rand == 0){
                    player1++;
                    option.setText("Player 2 chose: Rock");
                    winner.setText("You win");
                    Toast.makeText(Exam.this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
                } else if(rand == 2){
                    player2++;

                    Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                    long pattern[] = {0, 800, 100};
                    vib.vibrate(pattern, 2);

                    winner.setText("You lose");
                    option.setText("Player 2 chose: Scissors");
                    Toast.makeText(Exam.this, "Player 2 Wins", Toast.LENGTH_SHORT).show();
                } else {
                    winner.setText("It's a Tie");
                    option.setText("Player 2 chose: Paper");
                }

                strScore = "Player1  " + player1 + " - " + player2 + "  Player2";
                score.setText(strScore);

            }
        });

        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rand = myRandom.nextInt(3);

                if(rand == 0){
                    player2++;

                    Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                    long pattern[] = {0, 800, 100};
                    vib.vibrate(pattern, 2);

                    winner.setText("You lose");
                    option.setText("Player 2 chose: Rock");
                    Toast.makeText(Exam.this, "Player 2 Wins", Toast.LENGTH_SHORT).show();
                } else if(rand == 1){
                    player1++;
                    winner.setText("You win");
                    option.setText("Player 2 chose: Paper");
                    Toast.makeText(Exam.this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
                } else {
                    winner.setText("It's a Tie");
                    option.setText("Player 2 chose: Scissors");
                }

                strScore = "Player1  " + player1 + " - " + player2 + "  Player2";
                score.setText(strScore);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1 = 0;
                player2 = 0;

                Toast.makeText(Exam.this, "The Game was Restarted", Toast.LENGTH_SHORT).show();
                strScore = "Player1  0 - 0  Player2";
                winner.setText("-");
                option.setText("-");
                score.setText(strScore);
            }
        });

    }
}
