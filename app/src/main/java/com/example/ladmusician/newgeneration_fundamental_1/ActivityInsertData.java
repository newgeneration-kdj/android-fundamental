package com.example.ladmusician.newgeneration_fundamental_1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ladmusician.newgeneration_fundamental_1.DTO.TelephoneDTO;
import com.example.ladmusician.newgeneration_fundamental_1.Database.TelephoneBookDB;

/**
 * Created by ladmusician on 15. 7. 11..
 */
public class ActivityInsertData extends Activity implements View.OnClickListener{
    private static final String TAG = "ACTIVITY_INSERT_DATA";
    private Context mContext;

    private EditText mEditTxtName;
    private EditText mEditTxtPhone;
    private Button mBtnCreate;

    private TelephoneDTO mDTO;

    private TelephoneBookDB mDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        setElement();
        setOnClickListener();
    }

    void setElement () {
        mContext = getApplicationContext();
        mDB = new TelephoneBookDB(mContext, null);
        mEditTxtName = (EditText) findViewById(R.id.edittxt_name);
        mEditTxtPhone = (EditText) findViewById(R.id.edittxt_phone);

        mBtnCreate = (Button) findViewById(R.id.btn_insert_data);
    }

    void setOnClickListener () {
        mBtnCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_insert_data:
                mDTO = new TelephoneDTO();
                mDTO.setName(mEditTxtName.getText().toString());
                mDTO.setPhoneNm(mEditTxtPhone.getText().toString());

                boolean rtv = mDB.insert(mDTO);
                if (rtv) {
                    Log.e(TAG, "SUCCESS");
                    finish();
                } else {
                    Log.e(TAG, "FAIL");
                }
                break;
            default:
                break;
        }
    }
}
