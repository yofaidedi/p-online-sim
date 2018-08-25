package com.ajibarang.rsud.rsudajibarang;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import android.widget.TextView;

public class Navigasi extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView text_username;
    String nomr;
    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "NOMR";
    SharedPreferences sharedpreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigasi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Pendaftaran Online");
        setSupportActionBar(toolbar);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Tombol untuk pendaftaran online", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        text_username=(TextView) findViewById(R.id.txt_username);
        sharedpreferences = getSharedPreferences(login.my_shared_preferences, Context.MODE_PRIVATE);
        nomr=getIntent().getStringExtra(TAG_USERNAME);
        text_username.setText(nomr);



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
        getMenuInflater().inflate(R.menu.navigasi, menu);
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

        if (id == R.id.nav_profil) {
            Intent intent = new Intent(Navigasi.this, NavProfil.class);
            startActivity(intent);
        } else if (id == R.id.nav_tagihan) {
            Intent intent = new Intent(Navigasi.this, NavTagihan.class);
            startActivity(intent);

        } else if (id == R.id.nav_riwayat) {
            Intent intent = new Intent(Navigasi.this, NavRiwayat.class);
            startActivity(intent);

        } else if (id == R.id.nav_bed) {
            Intent intent = new Intent(Navigasi.this, NavBed.class);
            startActivity(intent);

        } else if (id == R.id.nav_alur) {
            Intent intent = new Intent(Navigasi.this, NavAlur.class);
            startActivity(intent);

        } else if (id == R.id.nav_layanan) {
            Intent intent = new Intent(Navigasi.this, NavLayanan.class);
            startActivity(intent);

        } else if (id == R.id.nav_keluar) {

            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(login.session_status, false);
            editor.putString(TAG_ID, null);
            editor.putString(TAG_USERNAME, null);
            editor.commit();

            Intent intent = new Intent(Navigasi.this, MenuTab.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
