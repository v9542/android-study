package com.somo.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.somo.test.server.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yebonkim on 2016. 11. 24..
 */

public class UserDBDAO {
    DatabaseHelper helper;
    SQLiteDatabase database;
    Context context;
    private String tableName;
    private String[] columnList;

    public UserDBDAO(Context context) {
        this.context = context;
        this.helper = DatabaseHelper.getHelper(context);
        database = this.helper.getWritableDatabase();
        tableName = DBLiteral.USER_TABLE;
        columnList = new String[] {DBLiteral.id_column, DBLiteral.user_id_column};
        open();
    }

    private void open() {
        if(this.helper==null) {
            this.helper = DatabaseHelper.getHelper(context);
            this.database = this.helper.getWritableDatabase();
        }
    }

    public void insert(User data) {
        ContentValues values = getContentValues(data);

        try {
            database.insert(tableName, null, values);
        }catch(SQLiteConstraintException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    private ContentValues getContentValues(User data) {
        ContentValues values = new ContentValues();
        values.put(DBLiteral.id_column, data.getId());
        values.put(DBLiteral.user_id_column, data.getUser_id());
        return values;
    }

    public void delete(int id) {
        database.delete(tableName,
                DBLiteral.WHERE_ID_EQUALS, new String[] {   String.valueOf(id) });
    }

    public void update(User data, int id) {
        ContentValues values = getContentValues(data);

        database.update(tableName, values, DBLiteral.WHERE_ID_EQUALS, new String[] {   String.valueOf(id) });
    }

    public List<User> selectAll() {
        List<User> result = new ArrayList<User>();

        Cursor cursor = database.query(tableName, columnList, null, null, null, null, null);

        if(cursor==null || cursor.getCount()==0)
            return result;

        cursor.moveToFirst();

        do {
            result.add(cursorToUser(cursor));
        }while(cursor.moveToNext());

        cursor.close();

        return result;
    }

    private User cursorToUser(Cursor cursor) {
        User data = new User();

        data.setId(cursor.getInt(0));
        data.setUser_id(cursor.getString(1));

        return data;
    }

    public User selectById(int id) {
        Cursor cursor = database.query(tableName, columnList,
                DBLiteral.WHERE_ID_EQUALS, new String[]{ String.valueOf(id)}, null, null, null);
        cursor.moveToFirst();

        return cursorToUser(cursor);
    }

}
