package com.cofc.buttoncounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int appCountNum = 0;

    // 1 create button in activity xml with id A
    Button btnAdd, btnSub, btnReset, btnApply;
    TextView txtvDispCount;
    EditText userCapNum;
    ProgressBar countProgBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2 create button in main activity (OnCreate) and link up with id A
        btnAdd = (Button) findViewById(R.id.btnIncrease);
        btnSub = (Button) findViewById(R.id.btnDecrease);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnApply = (Button) findViewById(R.id.btnApply);

        int F_Max = 100;
        txtvDispCount = (TextView) findViewById(R.id.txtCount);
        userCapNum = (EditText) findViewById(R.id.entCap);

        countProgBar = (ProgressBar) findViewById(R.id.progressBar2);

        countProgBar.setMax(F_Max);

        //integer.valueOf();


        // 3 set onlcick listener for button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                appCountNum++;
                txtvDispCount.setText(Integer.toString(appCountNum));
                countProgBar.setProgress(appCountNum);




            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (appCountNum==0){
                    countProgBar.setProgress(appCountNum);

                }
                else {
                    appCountNum--;
                    txtvDispCount.setText(Integer.toString(appCountNum));
                    countProgBar.setProgress(appCountNum);
                }




            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                appCountNum = 0;
                txtvDispCount.setText(Integer.toString(appCountNum));
                countProgBar.setProgress(appCountNum);
                userCapNum.setText("");



            }
        });

        btnApply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String progressMax = userCapNum.getText().toString();
                txtvDispCount.setText(Integer.toString(appCountNum));
                countProgBar.setProgress(appCountNum);
                countProgBar.setMax((((Integer.parseInt(progressMax)))));



            }
        });

        // set num given by user to be max for progress bar
        //if counter is above full progress bar stays full
        // change int A to be equal to the counter, set the progress status to A
        // or int version o
        // change a second int B is to take user input for max capacity for the pprogress bar



        //track increase and decreases every miunte (or hour ) from start to reset
        // when + is increased, start timer, when + is increased, save 1




    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        String value = txtvDispCount.getText().toString();

        outState.putString("key", value);

    }
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String value = savedInstanceState.getString("key");
        appCountNum = Integer.parseInt(value);
        txtvDispCount.setText(value);
        countProgBar.setProgress(appCountNum);


    }

}
