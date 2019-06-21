package com.example.vkcofficial;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vkcofficial.fragment.CompletedPoFragment;
import com.example.vkcofficial.fragment.NotificationandMessage;
import com.example.vkcofficial.fragment.PendingPOFragment;
import com.example.vkcofficial.fragment.ReportFragment;
import com.example.vkcofficial.fragment.ViewDefectsFragment;
import com.example.vkcofficial.util.UserLoggedInSession;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

  public   static TextView plan,entry,textTitle,tv_defects;
    LinearLayout tablayout;
    UserLoggedInSession userLoggedInSession;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        textTitle=findViewById(R.id.textTitle);
        userLoggedInSession = new UserLoggedInSession(HomeActivity.this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);
        toolbar.setOutlineProvider(ViewOutlineProvider.BACKGROUND);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        textTitle.setText("PENDING PO");
        PendingPOFragment myPhotosFragment = new PendingPOFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, myPhotosFragment, "TAG")
                .commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);


        if (id == R.id.nav_po) {


            textTitle.setText("PENDING PO");
            PendingPOFragment myPhotosFragment = new PendingPOFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, myPhotosFragment, "TAG")
                    .commit();

        }
        else
        if (id == R.id.na_complete) {


            textTitle.setText("COMPLETED PO");
            CompletedPoFragment myPhotosFragment = new CompletedPoFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, myPhotosFragment, "TAG")
                    .addToBackStack("PendingPOFragment")

                    .commit();

        } else   if (id == R.id.viewdefects) {


            textTitle.setText("VIEW DEFECTS");
            ViewDefectsFragment myPhotosFragment = new ViewDefectsFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, myPhotosFragment, "TAG")
                    .addToBackStack("PendingPOFragment")

                    .commit();

        }  else if (id == R.id.report) {


            textTitle.setText("REPORT");
            ReportFragment myPhotosFragment = new ReportFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, myPhotosFragment, "TAG")
                    .addToBackStack("PendingPOFragment")

                    .commit();

        }
        else if (id == R.id.nav_noti) {


            textTitle.setText("NOTIFICATIONS & MESSAGES");
            NotificationandMessage myPhotosFragment = new NotificationandMessage();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, myPhotosFragment, "TAG")
                    .addToBackStack("PendingPOFragment")

                    .commit();

        } else if (id == R.id.nav_logout) {


            userLoggedInSession.logoutUser();


        }



        return false;
    }
}
