package com.example.zerlin.activitylife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Zerlin on 2018/3/19.
 */

public class OtherActivity extends AppCompatActivity{
    static final String OtherDate = "OtherDate";
    private static final String TAG = "OtherActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        if(getIntent() != null){
            Bundle bundle = getIntent().getBundleExtra(MainActivity.MainDate);
            if(bundle != null){
                String title = bundle.getString(MainActivity.MainDate);
                setTitle(title);
            }

        }
        final EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.putExtra(OtherDate,editText.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        Log.d(TAG, "onCreate: ");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}
