package com.example.investiq;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


public class MainActivity extends AppCompatActivity {

    FragmentContainerView mainFragmentContainer;
    BottomNavigationView bottomBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragmentContainer = findViewById(R.id.mainFragmentContainer);
        bottomBar = findViewById(R.id.bottom_nav_view);

        NavHostFragment host = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragmentContainer);
        NavController navController = host.getNavController();


        setupBottomNavMenuNormUser(navController);
        navController.setGraph(R.navigation.bottom_nav);
    }

    private void setupBottomNavMenuNormUser(NavController navController) {
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        bottomNav.getMenu().clear();  // Clear existing menu items
        bottomNav.inflateMenu(R.menu.bottom_nav_menu);
        NavigationUI.setupWithNavController(bottomNav, navController);

    }
}