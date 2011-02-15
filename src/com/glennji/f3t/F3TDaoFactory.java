package com.glennji.f3t;

import com.glennji.f3t.R;

import android.content.Context;
import android.content.res.Resources;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class F3TDaoFactory {
    
    private static F3TDaoFactory instance;
    private Context ctx;
    private SimpleDatabaseHelper helper;
    private SQLiteDatabase database;
    
    private F3TDaoFactory(Context context) {
        ctx = context;
        Resources r = context.getResources();
        helper = new SimpleDatabaseHelper(ctx, r.getString(R.string.db_name),
                null, r.getInteger(R.integer.db_version),
                r.getString(R.string.db_create_query), null);
        database = helper.getWritableDatabase();
    }

    public synchronized static F3TDaoFactory getFactory(Context context) throws SQLException {
        if (instance == null) {
            instance = new F3TDaoFactory(context);
        }
        return instance;
    }
    
    public F3TDao getDao() {
        return new F3TDao(helper);
    }
}
