package com.example.contactversion2.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.contactversion2.Contact;

import java.util.ArrayList;

public class Data extends SQLiteOpenHelper {
    public static  String DATABASE_NAME ="ListContact";
    private static final String TABLE_CONTACT = "contacts";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String NUMBER_PHONE = "numberPhone";
    private static final int DATABASE_VERSION = 2;
    private static final String CREATE_TABLE = "CREATE TABLE "
            + TABLE_CONTACT + "(" + ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT, "+ NUMBER_PHONE + " TEXT );";
    public Data(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("table", CREATE_TABLE);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_CONTACT + "'");
        onCreate(db);
    }

    public long addContact(String name, String number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(NUMBER_PHONE, number);
        long insert = db.insert(TABLE_CONTACT, null, values);
        return insert;
    }
    public int updateContact(int id, String name, String number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(NUMBER_PHONE, number);
        return db.update(TABLE_CONTACT, values, ID + " = ?",
                new String[]{String.valueOf(id)});
    }
    public void deleteContact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACT, ID + " = ?",
                new String[]{String.valueOf(id)});
    }
    public ArrayList<Contact> getAllContacts() {
        ArrayList<Contact> list = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Contact contact= new Contact();
                contact.setId(c.getInt(c.getColumnIndex(ID)));
                contact.setName(c.getString(c.getColumnIndex(NAME)));
                contact.setNumberPhone(c.getString(c.getColumnIndex(NUMBER_PHONE)));
                list.add(contact);
            } while (c.moveToNext());
        }
        return list;
    }



}
