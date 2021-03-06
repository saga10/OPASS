package com.example.admin.opass;

import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final EditText source = (EditText) findViewById(R.id.Source);
        final EditText desti= (EditText) findViewById(R.id.Destination);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button FindPath = (Button) findViewById(R.id.FindPath);
        FindPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sourceaddress = source.getText().toString();
                String destinationaddress = desti.getText().toString();
                View focusview1 = null;
                boolean exit = false;
                if (sourceaddress.isEmpty()) {
                    source.setError("Field required!");
                    focusview1 = source;
                    exit = true;
                }
                if (destinationaddress.isEmpty()) {
                    desti.setError("Field required!");
                    focusview1 = desti;
                    exit = true;
                }
                if (exit) {
                    focusview1.requestFocus();
                } else {
                    Intent intent = new Intent(v.getContext(), Maps.class);
                    startActivity(intent);
                }

            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.rides) {
            Intent intent = new Intent(Home.this, Welcome.class);
            startActivity(intent);

        } else if (id == R.id.nbh) {
            Intent intent = new Intent(Home.this, Welcome.class);
            startActivity(intent);

        } else if (id == R.id.sett) {
            Intent intent = new Intent();
            intent.setClassName("com.android.settings", "com.android.settings.Settings");
            startActivity(intent);

        } else if (id == R.id.has) {
            Intent intent = new Intent(Home.this, Welcome.class);
            startActivity(intent);

        } else if (id == R.id.au) {
            Intent intent = new Intent(Home.this, AboutUs.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }







}
