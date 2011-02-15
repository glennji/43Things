package com.glennji.f3t;

import com.glennji.f3t.R;

import android.content.Context;
import android.content.res.Resources;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class F3TDaoFactory {
    
    private static F3TDaoFactory instance;
    private Context ctx;
    private SimpleDatabaseHelper helper;
    private SQLiteDatabase database;
    
    private F3TDaoFactory(Context context) {
        ctx = context;
        Resources r = context.getResources();
        helper = new SimpleDatabaseHelper(ctx, r.getString(R.string.db_name),
                null, r.getInteger(R.integer.db_version));
        helper.setCreateSql(r.getString(R.string.db_create_query));
        Log.i("F3T", "DAO Factory constructed, helper is " + helper);
    }

    public synchronized static F3TDaoFactory getFactory(Context context) throws SQLException {
        if (instance == null) {
            instance = new F3TDaoFactory(context);
        }
        return instance;
    }
    
    public F3TDao getDao() {
        database = helper.getWritableDatabase();
        Log.d("F3T", "Database is " + database);
        return new F3TDao(database);
    }
}
