package com.mvp_model.datamanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mvp_model.datamanager.model.UserInfo;
import com.mvp_model.di.ApplicationContext;
import com.mvp_model.di.DatabaseInfo;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DatabaseHelper extends SQLiteOpenHelper {

    private String NAME = "name";
    private String PHONE = "phone";
    private String EMAIL = "email";
    private String ID = "id";

    @Inject
    public DatabaseHelper(@ApplicationContext Context context,
                           @DatabaseInfo String databaseName,
                           @DatabaseInfo int versionName){
        super(context,databaseName,null,versionName);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // TODO Auto-generated method stub
        sqLiteDatabase.execSQL(
                "create table contacts " +
                        "("+ID+" integer primary key, " + NAME + " text, " + PHONE + " text, " + EMAIL + " text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertData(UserInfo userInfo){

        ContentValues cv = new ContentValues();

        cv.put(NAME, userInfo.getName());
        cv.put(PHONE, userInfo.getNumber());
        cv.put(EMAIL, userInfo.getEmail());

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        long insertData = sqLiteDatabase.insert("contacts", EMAIL, cv);
        Log.d("ong value inserted", ""+ insertData);

        return insertData;

    }

    public ArrayList<UserInfo> getAllUser(){

        ArrayList<UserInfo> contactlist = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from contacts", null);

        if(cursor == null || cursor.getCount() <= 0)
            return contactlist;

        cursor.moveToFirst();
        do {

            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            String email = cursor.getString(3);

            UserInfo userInfo = new UserInfo(name, phone, email);
            contactlist.add(userInfo);

            } while (cursor.moveToNext());

        return contactlist;
    }
}
