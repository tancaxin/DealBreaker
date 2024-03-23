package com.example.investiq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class profile_page extends AppCompatActivity {
    TextView txtMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        txtMore = findViewById(R.id.txtMore);

        txtMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile_page.this, TradingHistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}