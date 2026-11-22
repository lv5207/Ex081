package com.example.ex081;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * @author  Lavi Vainer
 * @version 1.0
 * @since   17/11/2026
 *
 * Displaying the results of the game and the winner.
 */
public class Winners extends AppCompatActivity {
private Button btnRestart;
private TextView tvRed, tvBlue;
private Intent gi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winners);

        gi = getIntent();
        int blue = gi.getIntExtra("blue", 0);
        int red = gi.getIntExtra("red", 0);

        btnRestart = findViewById(R.id.btnRestart);
        tvRed = findViewById(R.id.tvRed);
        tvBlue = findViewById(R.id.tvBlue);

        btnRestart.setOnClickListener(new View.OnClickListener() {
            /**
             * Send the player back to the Main screen and start a new round.
             * @param view The view (in this case, button) which was clicked.
             */
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tvBlue.setText("Blue: " + blue);
        tvRed.setText("Red: " + red);

        if(blue > red)
        {
            tvBlue.setText(tvBlue.getText() + "\nWINNER");
        }
        else if(blue < red)
        {
            tvRed.setText(tvRed.getText() + "\nWINNER");
        }
    }
}