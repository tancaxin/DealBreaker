    package com.example.investiq;

    import android.animation.ObjectAnimator;
    import android.content.Intent;
    import android.media.Image;
    import android.os.Bundle;

    import com.google.android.material.snackbar.Snackbar;

    import androidx.appcompat.app.AppCompatActivity;

    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.LinearLayout;
    import android.widget.RelativeLayout;

    import androidx.navigation.NavController;
    import androidx.navigation.Navigation;
    import androidx.navigation.ui.AppBarConfiguration;
    import androidx.navigation.ui.NavigationUI;

    public class Chapter extends AppCompatActivity {

        ImageView back;
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
            back = findViewById(R.id.imageArrowBack);

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Chapter.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();                }
            });

            boolean cameFromFragment = getIntent().getBooleanExtra("came_from_fragment", false);
            if (cameFromFragment) {
                // Set a flag indicating that we need to return to the fragment
                setResult(RESULT_OK);
            }

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

            expandedView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Chapter.this, VideoActivity.class);
                    startActivity(intent);
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
