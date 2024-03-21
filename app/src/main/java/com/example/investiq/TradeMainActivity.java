package com.example.investiq;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

public class TradeMainActivity extends AppCompatActivity {

    LinearLayout screen;
    ImageView guidance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_main);

        screen = findViewById(R.id.screen);
        guidance = findViewById(R.id.btnGuidanceOne);

        guidance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatePopUpWindow();
            }
        });
    }

    private void CreatePopUpWindow() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.trading_guidance_popup, null);

        int width = ViewGroup.LayoutParams.WRAP_CONTENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        PopupWindow popupWindow = new PopupWindow(popUpView, width, height, focusable);
        screen.post(new Runnable() {
            @Override
            public void run() {
                popupWindow.showAtLocation(screen, Gravity.CENTER,0,0);
            }
        });

        popUpView.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}