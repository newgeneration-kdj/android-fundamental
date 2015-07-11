package com.example.ladmusician.newgeneration_fundamental_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class ActivityMain extends ActionBarActivity implements View.OnClickListener{
    private static final String TAG = "ACTIVITY_MAIN";
    private Context mContext;

    private Button mBtnSelectAll;
    private Button mBtnInsertData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();

        setElement();
        setOnClickListener();
    }

    void setElement () {
        mBtnSelectAll = (Button) findViewById(R.id.btn_select_all);
        mBtnInsertData = (Button) findViewById(R.id.btn_insert);
    }

    void setOnClickListener () {
        mBtnSelectAll.setOnClickListener(this);
        mBtnInsertData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_select_all:
                startActivity(new Intent(mContext, ActivitySelectAll.class));
                break;
            case R.id.btn_insert:
                startActivity(new Intent(mContext, ActivityInsertData.class));
                break;
            default:
                break;
        }
    }
}
