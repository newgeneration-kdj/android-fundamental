package com.example.ladmusician.newgeneration_fundamental_1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ladmusician.newgeneration_fundamental_1.Adapter.TelephoneBookAdapter;
import com.example.ladmusician.newgeneration_fundamental_1.DTO.TelephoneDTO;
import com.example.ladmusician.newgeneration_fundamental_1.Database.TelephoneBookDB;

import java.util.ArrayList;

/**
 * Created by ladmusician on 15. 7. 11..
 */
public class ActivitySelectAll extends Activity {
    private static final String TAG = "ACTIVITY_SELECT_ALL";
    private TelephoneBookDB mDB;
    private Context mContext;
    private ArrayList<TelephoneDTO> mTelephones;

    private ListView mListItems = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_all);

        setElement();
        getDataInDB();

        mListItems.setAdapter(new TelephoneBookAdapter(mContext, mTelephones));
    }

    void setElement () {
        mContext = getApplicationContext();
        mDB = new TelephoneBookDB(mContext, null);
        mTelephones = new ArrayList<TelephoneDTO>();

        mListItems = (ListView) findViewById(R.id.list_telephones);
    }

    void getDataInDB () {
        mTelephones = mDB.getTelephones();
    }
}
