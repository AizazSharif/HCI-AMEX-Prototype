package com.example.aizaz.proto2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class MainActivity extends AppCompatActivity {


    private android.support.v7.widget.Toolbar toolbar;
    Button walk,run;
    private View myView;
    private Vibrator myVib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        walk= (Button) findViewById(R.id.button);
        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        PieChart mPieChart = (PieChart) findViewById(R.id.piechart);


        mPieChart.addPieSlice(new PieModel("Others", 25, Color.parseColor("#ffffff")));
        mPieChart.addPieSlice(new PieModel("Walk", 35, Color.parseColor("#285c80")));
        mPieChart.addPieSlice(new PieModel("Run", 9, Color.parseColor("#ff0033")));

        mPieChart.startAnimation();


        run=(Button) findViewById(R.id.button2);
        walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVib.vibrate(15);

                Intent intent = new Intent(MainActivity.this,Walk.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVib.vibrate(15);
                Intent intent = new Intent(MainActivity.this,Run.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
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

        if (id == R.id.help) {
            startActivity(new Intent(this, Help.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
