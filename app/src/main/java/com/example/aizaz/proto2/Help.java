package com.example.aizaz.proto2;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Aizaz on 11/9/2015.
 */
public class Help extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;

    private Button b1;
int i=0;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        b1 = (Button) findViewById(R.id.button5);
       img= (ImageView) findViewById(R.id.imageView4);
        final Vibrator myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        //img.setBackgroundResource(R.drawable.t);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //img.setBackgroundResource(R.drawable.t);
                myVib.vibrate(15);

               i++;
                if(i==1){
                    img.setImageResource(R.drawable.u);
                }
                if(i==2){
                    img.setImageResource(R.drawable.v);
                }
                if(i==3){
                    img.setImageResource(R.drawable.w);
                }
                if(i==4){
                    img.setImageResource(R.drawable.x);
                }
                if(i==5){
                    img.setImageResource(R.drawable.y);
                }
                if(i==6){
                    img.setImageResource(R.drawable.z);
                }
                if(i==7){
                    img.setImageResource(R.drawable.t);
                    i=0;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_help, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}