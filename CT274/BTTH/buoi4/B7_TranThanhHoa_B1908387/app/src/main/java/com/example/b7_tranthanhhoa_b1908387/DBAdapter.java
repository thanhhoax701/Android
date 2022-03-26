package com.example.b7_tranthanhhoa_b1908387;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBAdapter {
    static final String KEY_ROWID = "_id";
    static final String KEY_MSSV = "mssv";
    static final String KEY_NAME = "name";
    static final String KEY_EMAIL = "email";
    static final String KEY_PHONE = "phone";
    static final String TAG = "DBAdapter";
    static final String DATABASE_NAME = "MyDB";
    static final String DATABASE_TABLE = "students";
    static final int DATABASE_VERSION = 1;
    final Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;
    //Định nghĩa chuỗi sinh ra bảng sinh viêns.
    static final String DATABASE_CREATE = "create table students (_id integer primary key autoincrement, "
            + "mssv text not null, name text not null, email text not null, phone text not null);";

    //Hàm tạo (contractor)
    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        //Hàm tạo
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        //Sinh ra CSDL SQLite tên db và tạo bảng sinh viên.
        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Tạo hàm cập nhật CSDL
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //Tạo thông báo trên màn hình console của IDE
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            // Dùng hàm execSQL để xóa bảng cũ.
            db.execSQL("DROP TABLE IF EXISTS students");
            // Tạo CSLD cho phiên bản mới
            onCreate(db);
        }

    }

    //---Tạo hàm mở CSDL---
    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //--- Hàm đóng CSDL---
    public void close() {
        DBHelper.close();
    }

    //---Hàm chèn một nội dung (sinh viên) vào CSDL
    public long insertStudent(String name, String mssv, String email, String phone) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_MSSV, mssv);
        initialValues.put(KEY_EMAIL, email);
        initialValues.put(KEY_PHONE, phone);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //---Hàm xoá nột nội dung (SV) xác định---
    public boolean deleteStudent(long rowId) {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    //---Hàm lấy tất cả các nội dung (Danh sách SV)---
    public Cursor getAllStudent() {
        return db.query(DATABASE_TABLE, new String[]{KEY_ROWID, KEY_MSSV, KEY_NAME, KEY_EMAIL, KEY_PHONE},
                null, null, null, null, null, null);
    }

    //--- Hàm lấy một nội dung xác định (1 SV)---
    public Cursor getStudent(int chiso) throws SQLException {
        Cursor mCursor = db.query(true, DATABASE_TABLE, new String[]{KEY_ROWID, KEY_MSSV, KEY_NAME, KEY_EMAIL, KEY_PHONE},
                KEY_ROWID + "=" + chiso, null, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //--- Hàm cập nhật một nội dung (sinh viên)---
    public boolean updateStudent(long rowId, String mssv, String name, String email, String phone) {
        ContentValues args = new ContentValues();
        args.put(KEY_MSSV, mssv);
        args.put(KEY_NAME, name);
        args.put(KEY_EMAIL, email);
        args.put(KEY_PHONE, phone);
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}
