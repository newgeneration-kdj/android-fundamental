package com.example.ladmusician.newgeneration_fundamental_1.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ladmusician.newgeneration_fundamental_1.DTO.TelephoneDTO;

import java.util.ArrayList;

/**
 * Created by ladmusician on 15. 7. 11..
 */
public class TelephoneBookDB extends SQLiteOpenHelper {
    private static final String TAG = "DB_HELPER";

    private static final String TABLE_NAME = "TELEPHONE_BOOK";
    private static final int VERSION = 1;
    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final String PHONE_NM = "phone_nm";

    public TelephoneBookDB(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, TABLE_NAME, factory, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + PHONE_NM + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(TelephoneDTO DAO) {
        try {
            SQLiteDatabase db = getWritableDatabase();

            ContentValues newValue = new ContentValues();
            newValue.put(NAME, DAO.getName());
            newValue.put(PHONE_NM, DAO.getPhoneNm());

            db.insert(TABLE_NAME, null, newValue);
            db.close();
            return true;
        } catch (Exception e) {
            Log.e(TAG, "EXCEPTION : " + e.getMessage() );
            return false;
        }
    }

    public boolean update(TelephoneDTO DAO) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues updateValue = new ContentValues();
            updateValue.put(NAME, DAO.getName());
            updateValue.put(PHONE_NM, DAO.getPhoneNm());

            String whereArg = ID + "=" + DAO.getId();
            db.update(TABLE_NAME, updateValue, whereArg, null);
            db.close();
            return true;
        } catch (Exception e) {
            Log.e(TAG, "EXCEPTION : " + e.getMessage());
            return false;
        }
    }

    public boolean delete(TelephoneDTO DAO) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            String whereArg = ID + "=" + DAO.getId();
            db.delete(TABLE_NAME, whereArg, null);
            db.close();
            return true;
        } catch (Exception e) {
            Log.e(TAG, "EXCEPTION : " + e.getMessage());
            return false;
        }
    }

    public ArrayList<TelephoneDTO> getTelephones() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<TelephoneDTO> rtv = new ArrayList<TelephoneDTO>();

        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);

        while(cursor.moveToNext()) {
            TelephoneDTO val = new TelephoneDTO();
            val.setId(cursor.getInt(0));
            val.setName(cursor.getString(1));
            val.setPhoneNm(cursor.getString(2));

            rtv.add(val);
        }

        return rtv;
    }

    public TelephoneDTO getTelephoneById(int id) {
        SQLiteDatabase db = getReadableDatabase();

        TelephoneDTO rtv = new TelephoneDTO();

        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME + " where " + ID + "=" + id, null);
        cursor.moveToNext();
        rtv.setId(cursor.getInt(0));
        rtv.setName(cursor.getString(1));
        rtv.setPhoneNm(cursor.getString(2));

        return rtv;
    }
}
