package com.glennji.f3t;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SimpleDatabaseHelper extends SQLiteOpenHelper {
    
    private String createSql;
    private Map<Integer, String> upgradeMap;
    private SQLiteDatabase db;
    
    /**
     * Call superclass constructor.
     * 
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public SimpleDatabaseHelper(Context context, String name,
            CursorFactory factory, int version) {
        super(context, name, factory, version);
        upgradeMap = new HashMap<Integer, String>(0);
        Log.i("F3T", "Helper created");
    }
    
    /**
     * @return the createSql
     */
    public String getCreateSql() {
        return createSql;
    }

    /**
     * @param createSql the createSql to set
     */
    public void setCreateSql(String createSql) {
        this.createSql = createSql;
    }

    /**
     * @return the upgradeMap
     */
    public Map<Integer, String> getmUpgradeList() {
        return upgradeMap;
    }

    /**
     * @param upgradeMap the upgradeMap to set
     */
    public void setmUpgradeList(Map<Integer, String> mUpgradeList) {
        this.upgradeMap = mUpgradeList;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        // no database exists, create one from scratch
        Log.d("F3T", "Creating database with " + createSql);
        db = database;
        if (createSql != null && !"".equals(createSql.trim())) {
            db.execSQL(createSql);
            Log.d("F3T", "executed creation SQL");
        } else {
            Log.w("F3T",
                    "No database creation script specified");
            // TODO: throw an exception here
        }
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("F3T", "Upgrading database with " + createSql);
        // The simplest case is to drop the old table and create a new one.
        db.execSQL("DROP TABLE IF EXISTS goals");
        // Create a new one.
        onCreate(db);
        
        String upgradeSql;
        for (int i = oldVersion; i <= newVersion; i++) {
            upgradeSql = upgradeMap.get(i);
            if (null != upgradeSql) {
                db.execSQL(upgradeSql);
            }
        }
    }
}
