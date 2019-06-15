package android.example.hw_database.activities.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="USER_DB";
    public static final String TABLE_NAME="User";
    public static final int DATABASE_VERSION=1;

    public static final String COLUMN_ID="ID";
    public static final String COLUMN_NAME="NAME";
    public static final String COLUMN_PHONE="PHONE";
    public static final String COLUMN_ADDRESS="ADDRESS";
    public static final String CREATE_TABLE_QUERY="CREATE TABLE "+TABLE_NAME+" ("+COLUMN_ID+" VARCHAR(10) NOT NULL PRIMARY KEY ,"+COLUMN_NAME+
            " VARCHAR(40),"+COLUMN_PHONE+" VARCHAR(10),"+COLUMN_ADDRESS+" VARCHAR(200));";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i("MyTag","Database created");
        //onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            db.execSQL(CREATE_TABLE_QUERY);
            Log.i("MyTag","Table created");
        }catch (SQLException e){
            Log.i("MyTag",e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        Log.i("MyTag","Table Upgraded");
        onCreate(db);
    }

    public void addData(int id,String name, String phone, String address){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_ID,id);
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_PHONE,phone);
        values.put(COLUMN_ADDRESS,address);
        db.insert(TABLE_NAME,null,values);
        Log.i("MyTag","data had been added into table");


    }

    public void updateTable(int id, String address){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_ADDRESS,address);
        String temp[]=new String[]{String.valueOf(id)};
        database.update(TABLE_NAME,values,COLUMN_ADDRESS+"=?",temp);
        Log.i("MyTag","You updated: "+temp[0]+" "+address);
    }

    public void deleteID(int id){
        SQLiteDatabase database=getWritableDatabase();
        database.delete(TABLE_NAME,COLUMN_ID+"=?",new String[]{String.valueOf(id)});
        Log.i("MyTag","Deleted done");
    }
}
