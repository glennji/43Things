package com.glennji.f3t;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SimpleDatabaseHelper extends SQLiteOpenHelper {

	private String mCreateQuery;
	private Map<Integer, String> mUpgradeList;

	/**
	 * Call superclass constructor.
	 * 
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public SimpleDatabaseHelper(Context context, String name,
			CursorFactory factory, int version, String createQuery,
			Map<Integer, String> upgradeList) {
		super(context, name, factory, version);

		if (upgradeList == null) {
			mUpgradeList = new HashMap<Integer, String>(0);
		}
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// no database exists, create one from scratch
		if (mCreateQuery != null && !"".equals(mCreateQuery.trim())) {
			db.execSQL(mCreateQuery);
		} else {
			Log.w("SimpleDatabaseHelper",
					"No database creation script specified");
			// TODO: throw an exception here
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String upgradeSql;
		for (int i = oldVersion; i <= newVersion; i++) {
			upgradeSql = mUpgradeList.get(i);
			if (null != upgradeSql) {
				db.execSQL(upgradeSql);
			}
		}
	}

}
