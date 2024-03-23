package com.example.investiq;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class Chapter extends AppCompatActivity {

    private LinearLayout bornATrader;
    private LinearLayout expandedView;
private ImageView arrowImageView,arrowImageView2,arrowImageView3,arrowImageView4;
    private boolean isExpanded=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        bornATrader = findViewById(R.id.bornATrader);
    expandedView = findViewById(R.id.expandedView);
        arrowImageView = findViewById(R.id.arrowImageView);


        bornATrader.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (expandedView.getVisibility() == View.GONE) {
                expandedView.setVisibility(View.VISIBLE);
                toggleExpandedState();

            } else {
                expandedView.setVisibility(View.GONE);
                toggleExpandedState();

            }
        }
    });
}

    private void toggleExpandedState() {
        if (isExpanded) {
            // Collapse the expanded view
            expandedView.setVisibility(View.GONE);
            ObjectAnimator.ofFloat(arrowImageView, "rotationX", 0f).setDuration(150).start();

        } else {
            // Expand the view
            expandedView.setVisibility(View.VISIBLE);
            ObjectAnimator.ofFloat(arrowImageView, "rotationX", 180f).setDuration(150).start();


        }
        isExpanded = !isExpanded;
    }


}
