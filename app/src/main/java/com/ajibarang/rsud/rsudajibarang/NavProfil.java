package com.ajibarang.rsud.rsudajibarang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class NavProfil extends AppCompatActivity {
    private Toolbar mTopToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_profil);

        mTopToolbar = (Toolbar) findViewById(R.id.toolbarprofil);
        mTopToolbar.setTitle("Profil Pasien");
        setSupportActionBar(mTopToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTopToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), Navigasi.class);
                startActivity(i);
            }
        });

    }
}
