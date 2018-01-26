package com.hooper.kenneth.fooddiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_options);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button aAndBButton = findViewById(R.id.AandBMainButton);
        aAndBButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent AandBIntent = new Intent(getApplicationContext(), AandBActivity.class);
                startActivity(AandBIntent);
            }
        });

        Button foodButton = findViewById(R.id.FoodMainButton);
        foodButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent AandBIntent = new Intent(getApplicationContext(), BreakLunchDinnerActivity.class);
                startActivity(AandBIntent);
            }
        });

        Button snacksButton = findViewById(R.id.SnacksTreatsWaterMainButton);
        snacksButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent snakcsIntent = new Intent(getApplicationContext(), SnacksTreatsWaterActivity.class);
                startActivity(snakcsIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
