package com.jainshobhit.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    boolean gameActive = true;

//    Player Representation
//            0 --> X
//            1 --> O

    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
//    0 --> X
//    1 --> O
//    2 --> null

    int[][] winPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public static int counter = 0;

//    Function Calls whenever user taps within the grid

    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if (!gameActive){
            gameReset(view);
        }

        if(gameState[tappedImage]==2){
            counter++;


            if (counter==9){
                // Reset Game
                gameActive = false;
            }

            gameState[tappedImage] = activePlayer;

            // Motion Effect Translation
            img.setTranslationY(-1000f);

            if (activePlayer == 0) {
                // set the image of x
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);

                // change the status
                status.setText("O's Turn - Tap to play");
            }
            else{
                // set the image of o
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);

                // change the status
                status.setText("X's Turn - Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        int flag =0;

        for(int[] winPosition : winPositions){
            if(gameState[winPosition[0]]==gameState[winPosition[1]] && gameState[winPosition[1]]==gameState[winPosition[2]] && gameState[winPosition[0]]!= 2){
                flag=1;

                String winnerstr;
                // Game Finished
                gameActive=false;

                if (gameState[winPosition[0]] == 0){
                    winnerstr = "X has Won";
                }
                else{
                    winnerstr = "O has Won";
                }
                // Updating status bar
                TextView status = findViewById(R.id.status);
                status.setText(winnerstr);

            }



        }
        // If Match draw
        if (counter==9 && flag==0){
            gameActive=false;
            TextView status = findViewById(R.id.status);
            status.setText("Match Draw!! Play Again");
        }

    }
    // Reset the game
    public void gameReset(View view){
        gameActive=true;
        activePlayer=0;
        Arrays.fill(gameState, 2);
        counter = 0;
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}