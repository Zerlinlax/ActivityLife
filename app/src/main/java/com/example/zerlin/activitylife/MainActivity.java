package com.example.zerlin.activitylife;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    Button button1;
    Button button2;
    Button button3;
    EditText editText;

    static final String MainDate = "MainDate";
    private static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        initView();
        setListener();
        
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == -1){
            if(data != null){
                setTitle(data.getStringExtra(OtherActivity.OtherDate));
            }
        }
        if(requestCode == 2 && resultCode == 0){
            if(data != null){
                    Bundle bundle = data.getBundleExtra(DialogActivity.name);
                    if(bundle != null){
                        String title = bundle.getString(DialogActivity.name);
                        setTitle(title);
                    }
            }
        }
        Log.d(TAG, "onActivityResult: ");
    }

    private void initView() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        editText = findViewById(R.id.editText);
    }

    private void setListener() {
        MyListener myListener = new MyListener();
        button1.setOnClickListener(myListener);
        button2.setOnClickListener(myListener);
        button3.setOnClickListener(myListener);
    }

    class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.button1:
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,OtherActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(MainDate,true);
                    bundle.putString(MainDate,editText.getText().toString());
                    intent.putExtra(MainDate,bundle);
                    startActivityForResult(intent,1);
                    break;
                case R.id.button2:
                    Intent it = new Intent();
                    it.setClass(MainActivity.this,DialogActivity.class);
                    startActivityForResult(it,2);
                    break;
                case R.id.button3:
                    showADialog();
                    break;

            }
        }
    }

    private void showADialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("想想判断")
                .setMessage("你有信心过N2吗?")
                .setPositiveButton("必须啊", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "祝你好运，一起加油吧！"
                                , Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("没有信心啊", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "相信自己呀！"
                                , Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("我也不知道", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "那就每天坚持，你一定能行"
                                , Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}
