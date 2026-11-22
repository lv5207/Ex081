package com.example.ex081;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author  Lavi Vainer
 * @version 1.0
 * @since   17/11/2026
 *
 * Logic handling for the game itself (giving points to red and blue).
 */
public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
private Button btnBlue, btnRed, btnWinners;
private int countBlue, countRed;
private final int POINTS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBlue = findViewById(R.id.btnBlue);
        btnRed = findViewById(R.id.btnRed);
        btnWinners = findViewById(R.id.btnWinners);
        countBlue = 0; countRed = 0;

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countBlue += POINTS;
            }
        });

        btnRed.setOnLongClickListener(this);

        btnWinners.setOnClickListener(new View.OnClickListener() {
            /**
             * Sends the player and the points to the Winners screen.
             * @param view The view (in this case, the button) which was clicked
             */
            @Override
            public void onClick(View view) {

                // send data to winners screen via intent
                Intent si = new Intent(MainActivity.this, Winners.class);
                si.putExtra("blue", countBlue);
                si.putExtra("red", countRed);
                startActivity(si);

                // reset counts following intent finish
                countRed = 0; countBlue = 0;
            }
        });
    }

    /**
     * Adds two points to red when the player long clicks the red button.
     *
     * @param view The view (in this case, the button) which was clicked
     */
    @Override
    public boolean onLongClick(View view) {
        countRed += POINTS;
        return true;
    }
}