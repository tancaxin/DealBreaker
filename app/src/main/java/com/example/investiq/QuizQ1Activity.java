package com.example.investiq;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class QuizQ1Activity extends AppCompatActivity {

    Button opt1, opt2, opt3, opt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_q1);

        opt1 = findViewById(R.id.btnAns1);
        opt2 = findViewById(R.id.btnAns2);
        opt3 = findViewById(R.id.btnAns3);
        opt4 = findViewById(R.id.btnAns4);

        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerSelection(false, opt1);
            }
        });
        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerSelection(true, opt2);
            }
        });
        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerSelection(false, opt3);
            }
        });
        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerSelection(false, opt4);
            }
        });

    }

    private void handleAnswerSelection(boolean isCorrect, Button selectedOption) {
        Drawable backgroundDrawable;
        if (isCorrect) {
            // Inflate the green color drawable XML file
            backgroundDrawable = ContextCompat.getDrawable(this, R.drawable.rectangle_gradient_green_correct);
        } else {
            // Inflate the red color drawable XML file
            backgroundDrawable = ContextCompat.getDrawable(this, R.drawable.rectangle_gradient_red_wrong);
        }

        // Set the background drawable to the selected option (Button)
        selectedOption.setBackground(backgroundDrawable);

        // Delay for 1-2 seconds before moving to the next question (next activity)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an Intent to start the next activity
                Intent intent = new Intent(QuizQ1Activity.this, QuizQ7Activity.class);
                startActivity(intent);

                // Finish the current activity to prevent the user from going back to it
                finish();
            }
        }, 700); // 1500 milliseconds = 1.5 seconds
    }
}