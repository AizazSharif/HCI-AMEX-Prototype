package com.example.aizaz.proto2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;

/**
 * Created by Aizaz on 11/9/2015.
 */
public class Walk extends AppCompatActivity implements SensorEventListener {

    private android.support.v7.widget.Toolbar toolbar;

    Button back,maps,run;
    TextView txt1;
    private Vibrator myVib;
    private SensorManager mSensorManager;

    private Sensor mStepCounterSensor;

    private Sensor mStepDetectorSensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walk);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     //   getSupportActionBar().setHomeAsUpIndicator(R.drawable.homie);
        back= (Button) findViewById(R.id.button3);
        maps=(Button) findViewById(R.id.button4);
        run= (Button) findViewById(R.id.button2);
        txt1= (TextView) findViewById(R.id.textView);
        myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        BarChart mBarChart = (BarChart) findViewById(R.id.barchart);


        mBarChart.addBar(new BarModel(2f, Color.parseColor("#3f6dca")));
        mBarChart.addBar(new BarModel(2f,  Color.parseColor("#375185")));
        mBarChart.addBar(new BarModel(3f, Color.parseColor("#5f6d89")));
        mBarChart.addBar(new BarModel(1f, Color.parseColor("#5f6d89")));
        mBarChart.addBar(new BarModel(2f, Color.parseColor("#5f6d89")));
        mBarChart.addBar(new BarModel(2f,  Color.parseColor("#0040c1")));
        mBarChart.addBar(new BarModel(2f, Color.parseColor("#5a5f69")));


        mBarChart.startAnimation();

        mSensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        mStepCounterSensor=mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);



        mSensorManager.registerListener(this, mStepCounterSensor, SensorManager.SENSOR_DELAY_GAME);


        txt1.setText("Footsteps " + 1545);

        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVib.vibrate(15);

                Intent intent = new Intent(Walk.this, Run.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                myVib.vibrate(15);
                Intent intent = new Intent(Walk.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVib.vibrate(15);
                AlertDialog.Builder alert = new AlertDialog.Builder(Walk.this);
                alert.setTitle("Location Alert");
                alert.setIcon(R.drawable.ic_location_red_12);
                alert.setMessage("GPS must be turned on before going into Maps");


                alert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Intent intent = new Intent(Walk.this, Maps.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                dialog.dismiss();
                            }
                        });

                alert.show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_walk, menu);
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

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;


        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            txt1.setText(" Footsteps "+(int)(event.values[0]));

        }
    }
    protected void onResume() {

        super.onResume();

        mSensorManager.registerListener(this, mStepCounterSensor,

                SensorManager.SENSOR_DELAY_FASTEST);
        mSensorManager.registerListener(this, mStepDetectorSensor,

                SensorManager.SENSOR_DELAY_FASTEST);

    }

    protected void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this, mStepCounterSensor);
        mSensorManager.unregisterListener(this, mStepDetectorSensor);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
